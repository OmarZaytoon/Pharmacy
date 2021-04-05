package com.example.pharmacy.avtivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pharmacy.R;

public class UpdateProfile extends AppCompatActivity {


    EditText number,email,address;

    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        number = findViewById(R.id.profile_et_number1);
        email = findViewById(R.id.profile_et_email1);
        address = findViewById(R.id.profile_et_address1);

        save=findViewById(R.id.save);

        Intent i = getIntent();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                i.putExtra("number",number.getText().toString());
                i.putExtra("email",email.getText().toString());
                i.putExtra("address",address.getText().toString());
                setResult(1,i);
                finish();
            }
        });
    }
}