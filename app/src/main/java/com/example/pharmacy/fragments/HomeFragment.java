package com.example.pharmacy.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pharmacy.Requseter.Requseter;
import com.example.pharmacy.avtivities.ProductActivity;
import com.example.pharmacy.avtivities.ProductDetailes;
import com.example.pharmacy.R;
import com.example.pharmacy.avtivities.SeeAll;
import com.example.pharmacy.avtivities.StoreDetailes;
import com.example.pharmacy.adapters.CategoriesAdapter;
import com.example.pharmacy.adapters.OffersAdapter;
import com.example.pharmacy.adapters.StoresAdapter;
import com.example.pharmacy.models.Cart;
import com.example.pharmacy.models.Categories;
import com.example.pharmacy.models.Home;
import com.example.pharmacy.models.Offers;
import com.example.pharmacy.models.Product;
import com.example.pharmacy.models.Store;
import com.example.pharmacy.models.User;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class HomeFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    Home home;
    private RecyclerView rv1,rv2,rv3;
    private CategoriesAdapter adapter1;
    private OffersAdapter adapter2;
    private StoresAdapter adapter3;
    Button buy_now;
    TextView seeAllCategories,seeAllOffers,seeAllStores;
    User user;
    Cart cart;
    ArrayList<Store> stores;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        user=new Gson().fromJson(getArguments().getString("user"),User.class);
        stores=new Gson().fromJson(getArguments().getString("stores"), new TypeToken<List<Store>>(){}.getType());
        cart=new Gson().fromJson(getArguments().getString("cart"),Cart.class);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate= formatter.format(date);
        home= new Requseter().GoToHome(user.getUser_id()+"N"+strDate);
        seeAllCategories=v.findViewById(R.id.see_all_categories);
        seeAllOffers=v.findViewById(R.id.see_all_offers);
        seeAllStores=v.findViewById(R.id.see_all_stores);


        rv1=v.findViewById(R.id.category_rv);
        rv1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        rv1.setHasFixedSize(true);
        buy_now = v.findViewById(R.id.home_buy_now);

        ArrayList<Categories> list = home.getCategories();
        adapter1 = new CategoriesAdapter();
        rv1.setAdapter(adapter1);
        adapter1.setItems(list);

        //Offers
        rv2=v.findViewById(R.id.deals_rv);
        rv2.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        rv2.setHasFixedSize(true);

        ArrayList<Offers> list2 = home.getOffers();
        adapter2 = new OffersAdapter();
        rv2.setAdapter(adapter2);

        for(int i=0;i<list2.size();i++){
            adapter2.setItems(list2.get(i).getProducts(),list2.get(i).getDiscount_value());
        }

        //Stores
        rv3=v.findViewById(R.id.stores_rv);
        rv3.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        rv3.setHasFixedSize(true);


        adapter3 = new StoresAdapter();
        rv3.setAdapter(adapter3);
        adapter3.setItems(stores);

        adapter1.OnItemClickListner(new CategoriesAdapter.OnClickListner() {
            @Override
            public void onClick(Categories category) {
                Intent i = new Intent (getContext(), ProductActivity.class);
                startActivity(i);
            }
        });

        adapter2.OnItemClickListner(new OffersAdapter.OnClickListner() {
            @Override
            public void onClick(Product product) {
                Intent i = new Intent (getContext(), ProductDetailes.class);
                int id=product.getProduct_id();
                i.putExtra("product_id",id+"");
                i.putExtra("user",new Gson().toJson(user));
                startActivity(i);
            }
        });

        adapter3.OnItemClickListner(new StoresAdapter.OnClickListner() {
            @Override
            public void onClick(Store category) {
                Intent i = new Intent (getContext(), StoreDetailes.class);
                startActivity(i);
            }
        });



        seeAllCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getContext(), SeeAll.class);
                i.putExtra("type","categories");
                startActivity(i);

            }
        });
        seeAllOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getContext(),SeeAll.class);
                i.putExtra("type","offers");
                startActivity(i);

            }
        });
        seeAllStores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getContext(),SeeAll.class);
                i.putExtra("type","stores");
                startActivity(i);

            }
        });
        return v;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

}