package com.example.pharmacy.fragments;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.pharmacy.R;
import com.example.pharmacy.avtivities.MyOrders;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Checkout extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap map;
    FusedLocationProviderClient fusedLocationProviderClient;
    Button checkout;
    Double lati,longi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        checkout = findViewById(R.id.checkout_checkout);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map1);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        mapFragment.getMapAsync(this);


        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(longi!=null && lati!=null){
                    Toast.makeText(Checkout.this, ""+lati+" " +longi, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Checkout.this, MyOrders.class);
                    i.putExtra("lati",lati);
                    i.putExtra("longi",longi);
                    startActivity(i);
                }else
                    Toast.makeText(Checkout.this, "Please select Location", Toast.LENGTH_SHORT).show();


            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;


        LatLng address = new LatLng(31.953944, 35.910636);
        map.getUiSettings().setZoomControlsEnabled(true);
        map.addMarker(new MarkerOptions().position(address).title("Amman"));
        map.moveCamera(CameraUpdateFactory.newLatLng(address));

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(address, 16));


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        map.setMyLocationEnabled(true);
        map.setOnMapClickListener(latLng -> {
            //  Toast.makeText(this, latLng.latitude+","+latLng.longitude, Toast.LENGTH_SHORT).show();
            map.clear();
            map.addMarker(new MarkerOptions().position(latLng).title("My location ")).showInfoWindow();


            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("Select Location");
            alertDialog.setMessage("Are you sure to choose this location?");
            alertDialog.setCancelable(false);
            alertDialog.setPositiveButton("yes", (dialogInterface, i) -> {

                lati=latLng.latitude;
                longi=latLng.longitude;

                Toast.makeText(this, ""+latLng.latitude + " "+ latLng.longitude, Toast.LENGTH_SHORT).show();


            });
            alertDialog.setNegativeButton("no", (dialogInterface, i) -> {
                //  Toast.makeText(mappp.this,"",Toast.LENGTH_SHORT).show();
            });
            AlertDialog alertDialog1 = alertDialog.create();
            alertDialog1.show();

        });

    }
}