package com.example.pharmacy.avtivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pharmacy.R;
import com.example.pharmacy.Requseter.Requseter;
import com.example.pharmacy.models.Cart;
import com.example.pharmacy.models.Product;
import com.example.pharmacy.models.User;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductDetailes extends AppCompatActivity {
    Toolbar toolbar;
    RatingBar ratingBar;
    ImageView arrow;
    LinearLayout description,description_container;
    boolean active=false;
    TextView product_name,product_price,product_old_price,product_details_rating,product_details_desc,product_details_category;
    Product product;
    User user;
    Cart cart;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detailes);
        toolbar = findViewById(R.id.toolbar_main);
        Intent i = getIntent();
        int id= Integer.parseInt(i.getExtras().getString("product_id"));
        user=new Gson().fromJson(i.getExtras().getString("user"),User.class);
        cart=new Gson().fromJson(i.getExtras().getString("cart"),Cart.class);
        product=new Requseter().getProductDetails(id);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        arrow=findViewById(R.id.arrow);

        product_name=findViewById(R.id.product_name);
        product_price=findViewById(R.id.product_price);
        product_details_rating=findViewById(R.id.product_details_rating);
        product_details_desc=findViewById(R.id.product_details_desc);
        product_details_category=findViewById(R.id.product_details_category);

        product_name.setText(product.getProduct_name());
        product_price.setText(product.getProduct_price()+"");
        product_details_rating.setText(product.getTotal_rate()+"");
        product_details_desc.setText(product.getProduct_desc());
        product_details_category.setText(product.getCategoryname());

        button=findViewById(R.id.product_details_btn_addtocart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cart!=null){
                    boolean flag=new Requseter().addToCart(product.getProduct_id()+"N"+cart.getCart_id());
                    if(flag){
                        Toast.makeText(ProductDetailes.this, product.getProduct_name()+" Added To Your Cart Successfully", Toast.LENGTH_SHORT).show();
                    }else Toast.makeText(ProductDetailes.this, "Can't add to your Cart", Toast.LENGTH_SHORT).show();
                }else {
                    Cart cart1=new Cart();
                    cart1.setUserid(user.getUser_id());
                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String strDate= formatter.format(date);
                    cart1.setAdded_date(strDate);
                    int id=new Requseter().CreateNewCart(cart1);
                    new Requseter().addToCart(product.getProduct_id()+"N"+id);
                    Toast.makeText(ProductDetailes.this, product.getProduct_name()+" Added To Your Cart Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

        description=findViewById(R.id.description);
        description_container=findViewById(R.id.description_container);
        description_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!active){
                    arrow.setImageResource(R.drawable.ic_arrow_up);
                    description.setVisibility(View.VISIBLE);
                    active=true;
                }else{
                    arrow.setImageResource(R.drawable.ic_arrow_down);
                    description.setVisibility(View.GONE);
                    active=false;
                }

            }
        });


    }
}