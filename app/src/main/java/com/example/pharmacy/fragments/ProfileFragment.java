package com.example.pharmacy.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.pharmacy.R;
import com.example.pharmacy.avtivities.UpdateProfile;

public class ProfileFragment extends Fragment {

    EditText number,email,address;
    Button update;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_profile, container, false);
        number = v.findViewById(R.id.profile_et_number);
        email = v.findViewById(R.id.profile_et_email);
        address = v.findViewById(R.id.profile_et_address);

        update = v.findViewById(R.id.prifile_update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), UpdateProfile.class);
                i.putExtra("number",number.getText().toString());
                i.putExtra("email",email.getText().toString());
                i.putExtra("address",address.getText().toString());
                startActivityForResult(i,1);

            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&& resultCode==1){

            if(data.hasExtra("name") || data.hasExtra("email") || data.hasExtra("address"))
            number.setText(data.getStringExtra("number"));
            email.setText(data.getStringExtra("email"));
            address.setText(data.getStringExtra("address"));
        }
    }
}