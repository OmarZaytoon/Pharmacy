package com.example.pharmacy.avtivities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pharmacy.R;
import com.example.pharmacy.Requseter.Requseter;
import com.example.pharmacy.models.User;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateAnAccount2 extends AppCompatActivity {

    EditText username,password,confirmPassword;
    Button createAccount;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_an_account2);
        user=new Gson().fromJson(getIntent().getExtras().getString("user"),User.class);

        username = findViewById(R.id.createAccount2_et_username);
        password = findViewById(R.id.createAccount2_et_password);
        confirmPassword = findViewById(R.id.createAccount2_et_confirmPassword);

        createAccount = findViewById(R.id.creatAccount2_btn_createAccount);


        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name=username.getText().toString();
                String pass=password.getText().toString();
                String pass2=confirmPassword.getText().toString();
                if(user_name.isEmpty()){
                    Toast.makeText(CreateAnAccount2.this, "Fill your username please", Toast.LENGTH_SHORT).show();
                }else if(pass.compareTo(pass2)!=0){
                    Toast.makeText(CreateAnAccount2.this, "your Confirm Password is not Correct", Toast.LENGTH_SHORT).show();
                }else  if(pass.length()<5){
                    Toast.makeText(CreateAnAccount2.this, "your password is too short", Toast.LENGTH_SHORT).show();
                }else{
                    user.setUsername(user_name);
                    user.setPassword(pass);
                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String strDate= formatter.format(date);
                    user.setRegister_date(strDate);
                    user.setUser_profile_picture("default.jpg");
                    Log.d("User",new Gson().toJson(user));
                    boolean flag=new Requseter().createNewAccount(user);
                    if(flag)
                    {
                        Intent intent = new Intent(CreateAnAccount2.this, Splash_success.class);
                        intent.putExtra("user",new Gson().toJson(user));
                        startActivity(intent);
                    }else{
                        CreateDialog();
                    }
                }
            }
        });

    }

    private void CreateDialog() {
        new AlertDialog.Builder(this)
                .setTitle("")
                .setMessage("you already Have an Account you can go to Login and sign in ")
                .setPositiveButton("Go To Sign in", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(CreateAnAccount2.this,SignIn.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}