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
import com.example.pharmacy.Requseter.Requseter;
import com.example.pharmacy.models.Store;
import com.example.pharmacy.models.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

public class SignIn extends AppCompatActivity {
    EditText email,password;
    Button signIn;
    TextView goToSignIUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email=findViewById(R.id.SignIn_et_email);
        password=findViewById(R.id.SignIn_et_password);
        signIn=findViewById(R.id.SignIn_btn_signin);

        goToSignIUp=findViewById(R.id.SignIn_tv_signup);

        goToSignIUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, CreateAnAccount1.class);
                startActivity(intent);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ema=email.getText().toString();
                String pass=password.getText().toString();
                if(pass.compareTo("")==0||ema.compareTo("")==0){
                    Toast.makeText(SignIn.this, "Please Fill all the blanks", Toast.LENGTH_SHORT).show();
                }else {
                    User user=new User();
                    user.setPassword(pass);
                    user.setUsername(ema);
                    HashMap<User, ArrayList<Store>> listHashMap=new Requseter().Login(user);
                    if(!listHashMap.isEmpty()){
                        Gson gson=new Gson();
                        Intent intent = new Intent(SignIn.this, MainActivity.class);
                        for(User i: listHashMap.keySet()){
                            intent.putExtra("user",gson.toJson(i));
                            Log.d("user",gson.toJson(i));
                            intent.putExtra("stores",gson.toJson(listHashMap.get(i)));
                        }
                        startActivity(intent);
                    }else Toast.makeText(SignIn.this, "incorrect Username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}