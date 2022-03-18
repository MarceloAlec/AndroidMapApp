package com.androidmap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    private SupportMapFragment mMapaFragment;

    private double mLugarLat;
    private double mLugarLng;

    private LatLng mLugarLatLng;
    private String mNombreLugar;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        setTitle("Lugar Turístico - Quito");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mLugarLat = getIntent().getDoubleExtra("lugarLat",0);
        mLugarLng = getIntent().getDoubleExtra("lugarLng", 0);
        mNombreLugar = getIntent().getStringExtra("nombreLugar");

        mLugarLatLng = new LatLng(mLugarLat, mLugarLng);

        mMapaFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mMapaFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.addMarker(new MarkerOptions().position(mLugarLatLng).title(mNombreLugar)).showInfoWindow();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mLugarLatLng, 15f));

    }
}