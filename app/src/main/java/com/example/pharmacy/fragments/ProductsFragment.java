package com.example.pharmacy.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.example.pharmacy.R;
import com.example.pharmacy.adapters.ProductAdapter;
import com.example.pharmacy.adapters.StoresAdapter;
import com.example.pharmacy.models.Product;

import java.util.ArrayList;

public class ProductsFragment extends Fragment {


    private ProductAdapter adapter;
    private RecyclerView rv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_products, container, false);
        rv=v.findViewById(R.id.product_rv2);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);

/*        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product("Product Name"));
//        list.add(new Product("Product Name"));
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
  */
        return v;

    }
}