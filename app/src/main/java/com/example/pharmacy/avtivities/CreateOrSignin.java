package com.example.pharmacy.avtivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import com.example.pharmacy.R;

public class CreateOrSignin extends AppCompatActivity {
    Button createAccount,signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_or_signin);

        createAccount = findViewById(R.id.createOrSignin_btn_createAnAccount);
        signIn = findViewById(R.id.createOrSignin_btn_signIn);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateOrSignin.this, CreateAnAccount1.class);
                startActivity(intent);
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateOrSignin.this, SignIn.class);
                startActivity(intent);
            }
        });
    }
}