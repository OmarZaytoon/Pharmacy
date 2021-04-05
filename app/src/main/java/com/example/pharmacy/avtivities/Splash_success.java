package com.example.pharmacy.avtivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.pharmacy.R;
import com.example.pharmacy.models.User;
import com.google.gson.Gson;

public class Splash_success extends AppCompatActivity {
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_success);
        user=new Gson().fromJson(getIntent().getExtras().getString("user"),User.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash_success.this,SignIn.class);
                intent.putExtra("user",new Gson().toJson(user));
                startActivity(intent);
                finish();
            }
        },2000);
    }
}