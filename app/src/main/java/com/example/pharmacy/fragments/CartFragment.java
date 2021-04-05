package com.example.pharmacy.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pharmacy.R;
import com.example.pharmacy.Requseter.Requseter;
import com.example.pharmacy.adapters.CartAdapter;
import com.example.pharmacy.adapters.CategoriesAdapter;
import com.example.pharmacy.models.Cart;
import com.example.pharmacy.models.Categories;
import com.example.pharmacy.models.Product;
import com.example.pharmacy.models.User;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CartFragment extends Fragment {
    private RecyclerView rv;
    private CartAdapter adapter;
    User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_cart, container, false);
        //Cart
        user=new Gson().fromJson(getArguments().getString("user"),User.class);

        rv=v.findViewById(R.id.cart_rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);
        Cart cart=new Requseter().getMyCart(user.getUser_id()+"");
        if(cart==null){
            v=inflater.inflate(R.layout.empty_cart,container,false);
        }else{
            ArrayList<Product> list = cart.getProducts();
            adapter=new CartAdapter();
            rv.setAdapter(adapter);
            adapter.setItems(list);

            TextView textView= v.findViewById(R.id.fragment_cart_tv_total);
            float total=0;
            for(int i=0;i<list.size();i++){
                total+=list.get(i).getProduct_price();
            }

            textView.setText(total+"");
            Button button=v.findViewById(R.id.cart_order);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        return v;
    }
}