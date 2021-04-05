package com.example.pharmacy.avtivities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pharmacy.R;
import com.example.pharmacy.models.User;
import com.google.gson.Gson;

public class CreateAnAccount1 extends AppCompatActivity {
    EditText email;
    EditText phone;
    Button next;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_an_account1);
        email=findViewById(R.id.createAccount1_et_email);
        phone=findViewById(R.id.createAccount1_et_phone);
        next=findViewById(R.id.creatAccount1_btn_next);
        textView=findViewById(R.id.createAccount1_tv_singIn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em=email.getText().toString();
                String ph=phone.getText().toString();
                if(ph.compareTo("")==0){
                    Toast.makeText(CreateAnAccount1.this, "Please Enter your Phone Number", Toast.LENGTH_SHORT).show();
                }
                else if(em.compareTo("")!=0 && !em.contains("@") && !em.contains(".com")){
                    Toast.makeText(CreateAnAccount1.this, "Please Enter The Email Correctly", Toast.LENGTH_SHORT).show();
                } else if(ph.length()<4){
                    Toast.makeText(CreateAnAccount1.this, "Please Enter your Phone Number Correctly", Toast.LENGTH_SHORT).show();
                }else {
                    User user=new User();
                    if (em.compareTo("")==0) {
                        user.setEmail(null);
                    }else user.setEmail(em);
                    user.setPhone_number(ph);
                    Intent intent = new Intent(CreateAnAccount1.this, CreateAnAccount2.class);
                    intent.putExtra("user",new Gson().toJson(user));
                    startActivity(intent);
                }
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateAnAccount1.this, SignIn.class);
                startActivity(intent);
            }
        });
    }
}