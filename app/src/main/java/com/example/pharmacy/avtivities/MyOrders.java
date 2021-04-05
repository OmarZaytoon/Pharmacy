package com.example.pharmacy.avtivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pharmacy.R;
import com.example.pharmacy.fragments.ConfirmedFragment;
import com.example.pharmacy.fragments.OrderPlacedFragment;
import com.example.pharmacy.fragments.ProductsFragment;
import com.example.pharmacy.fragments.processedFragment;

public class MyOrders extends AppCompatActivity {

    Button orderPlaced,confirmed,processed;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        fragment = new OrderPlacedFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.myOrders_container, fragment).commit();

        orderPlaced=findViewById(R.id.myOrders_btn_orderPlaced);
        confirmed=findViewById(R.id.myOrders_btn_confirmed);
        processed=findViewById(R.id.myOrders_btn_processed);

        orderPlaced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderPlaced.setBackgroundColor(Color.parseColor("#ffc8c3"));
                confirmed.setBackgroundColor(Color.WHITE);
                processed.setBackgroundColor(Color.WHITE);
                fragment = new OrderPlacedFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.myOrders_container, fragment).commit();
            }
        });
        confirmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderPlaced.setBackgroundColor(Color.WHITE);
                confirmed.setBackgroundColor(Color.parseColor("#ffc8c3"));
                processed.setBackgroundColor(Color.WHITE);
                fragment = new ConfirmedFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.myOrders_container, fragment).commit();

            }
        });
        processed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderPlaced.setBackgroundColor(Color.WHITE);
                confirmed.setBackgroundColor(Color.WHITE);
                processed.setBackgroundColor(Color.parseColor("#ffc8c3"));
                fragment = new processedFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.myOrders_container, fragment).commit();

            }
        });
    }
}