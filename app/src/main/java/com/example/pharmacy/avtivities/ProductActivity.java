package com.example.pharmacy.avtivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.pharmacy.R;
import com.example.pharmacy.adapters.ProductAdapter;
import com.example.pharmacy.models.Product;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        rv = findViewById(R.id.product_rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
/*
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product("Product Name"));
        list.add(new Product("Product Name"));
        list.add(new Product("Product Name"));
        list.add(new Product("Product Name"));
        list.add(new Product("Product Name"));
        list.add(new Product("Product Name"));
        list.add(new Product("Product Name"));
        list.add(new Product("Product Name"));
        list.add(new Product("Product Name"));
        list.add(new Product("Product Name"));
        adapter = new ProductAdapter();
        rv.setAdapter(adapter);
        adapter.setItems(list);

        adapter.OnItemClickListner(new ProductAdapter.OnClickListner() {
            @Override
            public void onClick(Product category) {
                Intent intent = new Intent(ProductActivity.this, ProductDetailes.class);
                intent.putExtra("productName",category.getProduct_name());
                startActivity(intent);
            }
        });
    }
    */

    }
}