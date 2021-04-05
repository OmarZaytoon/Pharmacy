package com.example.pharmacy.avtivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.pharmacy.R;
import com.example.pharmacy.fragments.DescriptionFragment;
import com.example.pharmacy.fragments.ProductsFragment;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

public class StoreDetailes extends AppCompatActivity {


    Button product,description;
    Fragment fragment;
    LinearLayout image_container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detailes);
        ImageView roundedimag = (ImageView) findViewById(R.id.roundedimag);
        // Load an image using Picasso library
        Picasso.with(getApplicationContext())
                .load(R.drawable.store_logo)
                .into(roundedimag);

        // Load an image using Glide library
//        Glide.with(getApplicationContext())
//                .load("YOUR IMAGE URL")
//                .into(roundedimag);

      //  image_container.setBackground(new ShapeDrawable(new WeirdShape()));




        product=findViewById(R.id.storeDetail_btn_products);
        description=findViewById(R.id.storeDetail_btn_description);
        fragment = new ProductsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.storeDetail_container, fragment).commit();
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                description.setBackgroundColor(Color.WHITE);
                product.setBackgroundColor(Color.parseColor("#FF4956"));
                fragment = new ProductsFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.storeDetail_container, fragment).commit();
            }
        });
        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product.setBackgroundColor(Color.WHITE);
                description.setBackgroundColor(Color.parseColor("#FF4956"));
                fragment = new DescriptionFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.storeDetail_container, fragment).commit();
            }
        });


    }
}
