package com.example.pharmacy.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pharmacy.R;
import com.example.pharmacy.adapters.ProcessedAdapter;
import com.example.pharmacy.adapters.ProductAdapter;
import com.example.pharmacy.models.Cart;

import java.util.ArrayList;


public class processedFragment extends Fragment {

    private ProcessedAdapter adapter;
    private RecyclerView rv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_processed, container, false);
        rv=v.findViewById(R.id.processed_rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);


        ArrayList<Cart> list = new ArrayList<>();
/*        list.add(new Cart("Product Name"));
        list.add(new Cart("Product Name"));
        list.add(new Cart("Product Name"));
      adapter = new ProcessedAdapter();
        rv.setAdapter(adapter);
        adapter.setItems(list);


*/

        return v;
    }
}