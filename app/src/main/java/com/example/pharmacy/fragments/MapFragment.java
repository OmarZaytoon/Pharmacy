package com.example.pharmacy.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import com.example.pharmacy.R;
import com.example.pharmacy.avtivities.StoreDetailes;
import com.example.pharmacy.adapters.StoresAdapter;
import com.example.pharmacy.models.Store;
import com.example.pharmacy.models.User;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    User user;
    ArrayList<Store> list;
    GoogleMap map;
    SearchView searchView;
    FusedLocationProviderClient fusedLocationProviderClient;

    private StoresAdapter adapter3;
    private RecyclerView rv3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_map, container, false);
        user =new Gson().fromJson(getArguments().getString("user"),User.class);
        list=new Gson().fromJson(getArguments().getString("stores"), new TypeToken<List<Store>>(){}.getType());
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(), new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);


        }
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        searchView = v.findViewById(R.id.sv_location);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getContext());

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                String location = searchView.getQuery().toString();
                List<Address> addressList = null;
                if (location != null || !location.equals("")) {
                    Geocoder geocoder = new Geocoder(getContext());
                    try {
                        addressList = geocoder.getFromLocationName(location, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Address address = addressList.get(0);
                    address.getAddressLine(0);
                    LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                    map.addMarker((new MarkerOptions().position(latLng).title(location)));
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17.0f));

                }
                return false;

            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        mapFragment.getMapAsync(this);


        //Stores
        rv3 = v.findViewById(R.id.stores_rv2);
        rv3.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv3.setHasFixedSize(true);

        adapter3 = new StoresAdapter();
        rv3.setAdapter(adapter3);
        adapter3.setItems(list);

        adapter3.OnItemClickListner(new StoresAdapter.OnClickListner() {
            @Override
            public void onClick(Store category) {
                Intent i = new Intent(getContext(), StoreDetailes.class);
                startActivity(i);
            }
        });
        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        for(int i=0;i<list.size();i++){
            LatLng address=new LatLng(list.get(i).getLatitude(),list.get(i).getLongitude());
            map.getUiSettings().setZoomControlsEnabled(true);
            map.addMarker(new MarkerOptions().position(address).title(list.get(i).getStore_name()));
        }
        LatLng latLng1=new LatLng(list.get(0).getLatitude(),list.get(0).getLongitude());
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng1));

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng1, 16));


        if (ActivityCompat.checkSelfPermission(getContext().getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext().getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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


            AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
            alertDialog.setTitle("Select Location");
            alertDialog.setMessage("Are you sure to choose this location?");
            alertDialog.setCancelable(false);
            alertDialog.setPositiveButton("yes", (dialogInterface, i) -> {




            });
            alertDialog.setNegativeButton("no", (dialogInterface, i) -> {
                //  Toast.makeText(mappp.this,"",Toast.LENGTH_SHORT).show();
            });
            AlertDialog alertDialog1 = alertDialog.create();
            alertDialog1.show();

        });



    }

}


