package com.example.pharmacy.avtivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.pharmacy.R;
import com.example.pharmacy.Requseter.Requseter;
import com.example.pharmacy.adapters.CategoriesAdapter;
import com.example.pharmacy.adapters.OffersAdapter;
import com.example.pharmacy.adapters.SeeAllCtegoriesAdapter;
import com.example.pharmacy.adapters.SeeAllOffersAdapter;
import com.example.pharmacy.adapters.StoresAdapter;
import com.example.pharmacy.models.Categories;
import com.example.pharmacy.models.Offers;
import com.example.pharmacy.models.Store;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SeeAll extends AppCompatActivity {

    private RecyclerView rv;
    private SeeAllCtegoriesAdapter adapter1;
    private SeeAllOffersAdapter adapter2;
    private StoresAdapter adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all);

        rv = findViewById(R.id.seeAll_rv);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);

        //Categories
        Intent i = getIntent();
        if (i.hasExtra("type")) {
            if (i.getStringExtra("type").equals("categories")) {
                adapter1 = new SeeAllCtegoriesAdapter();
                ArrayList<Categories> categories = new Requseter().getAllCategories();
                rv.setAdapter(adapter1);
                adapter1.setItems(categories);

            } else if (i.getStringExtra("type").equals("offers")) {
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String strDate = formatter.format(date);
                ArrayList<Offers> offers = new Requseter().getOffers(strDate);
                rv.setLayoutManager(new LinearLayoutManager(this));
                adapter2 = new SeeAllOffersAdapter();
                rv.setAdapter(adapter2);
                adapter2.setItems(offers);

            } else if (i.getStringExtra("type").equals("stores")) {

                ArrayList<Store> stores = new Requseter().getAllStore();
                adapter3 = new StoresAdapter();
                rv.setAdapter(adapter3);
                adapter3.setItems(stores);
            }

        }
    }
}
