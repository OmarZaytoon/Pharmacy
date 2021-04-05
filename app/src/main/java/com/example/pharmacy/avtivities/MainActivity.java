package com.example.pharmacy.avtivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pharmacy.R;
import com.example.pharmacy.Requseter.Requseter;
import com.example.pharmacy.fragments.CartFragment;
import com.example.pharmacy.fragments.HomeFragment;
import com.example.pharmacy.fragments.MapFragment;
import com.example.pharmacy.fragments.ProfileFragment;
import com.example.pharmacy.models.Cart;
import com.example.pharmacy.models.Store;
import com.example.pharmacy.models.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView navigationView1;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    User user;
    String username;
    String email;
    Cart cart;
    ArrayList<Store> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson=new Gson();

        Intent intent=getIntent();

        user=gson.fromJson(intent.getExtras().getString("user"),User.class);
        list=gson.fromJson(intent.getExtras().getString("stores"), new TypeToken<List<Store>>(){}.getType());
        Log.d("user_id",user.getUsername()+" ");
        //Navigation Drawer and Toolbar

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        View headerView = navigationView.getHeaderView(0);
        navigationView.bringToFront();
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setCheckedItem(R.id.nav_myOrders);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setBackgroundColor(getResources().getColor(R.color.white));

        navigationView1 = findViewById(R.id.bottom_navigation);

        Bundle bundle = new Bundle();
        bundle.putString("user", new Gson().toJson(user));
        bundle.putString("stores",new Gson().toJson(list));
        MapFragment mapFragment=new MapFragment();
        mapFragment.setArguments(bundle);
        navigationView1.setSelectedItemId(R.id.menu_map);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mapFragment).commit();
        navigationView1.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment SelectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.menu_home:
                        SelectedFragment = new HomeFragment();
                        break;
                    case R.id.menu_map:
                        SelectedFragment = new MapFragment();
                        break;
                    case R.id.menu_cart:
                        SelectedFragment = new CartFragment();
                        break;
                    case R.id.menu_profile:
                        SelectedFragment = new ProfileFragment();
                        break;


                }
                Bundle bundle = new Bundle();
                bundle.putString("user", new Gson().toJson(user));
                bundle.putString("stores",new Gson().toJson(list));
                bundle.putString("cart",new Gson().toJson(cart));
                // set Fragmentclass Arguments
                SelectedFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, SelectedFragment).commit();
                return true;
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_myOrders:
                Intent i = new Intent(getApplicationContext(),MyOrders.class);
                startActivity(i);
                return true;
            case R.id.nav_myProfilee:
                Fragment SelectedFragment =null;
                SelectedFragment=new ProfileFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, SelectedFragment).commit();
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            case R.id.nav_offers:
                Intent i2 = new Intent(getApplicationContext(),SeeAll.class);
                i2.putExtra("type","offers");
                startActivity(i2);

                return true;
            case R.id.nav_help:
                Intent i3 = new Intent(getApplicationContext(),HelpAndSupport.class);
                startActivity(i3);

                return true;
            case R.id.nav_logout:
                Intent intent = new Intent(getApplicationContext(),CreateOrSignin.class);
                startActivity(intent);
                return true;

        }
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();
        Cart cart=new Requseter().getMyCart(user.getUser_id()+"");
        if(cart==null)user.setHaveAcart(false);else {user.setHaveAcart(true); this.cart=cart;}
    }
}