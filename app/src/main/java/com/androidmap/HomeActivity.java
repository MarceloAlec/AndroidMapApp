package com.androidmap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.androidmap.adapter.LugarAdapter;
import com.androidmap.model.Lugar;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvLugares;
    private ArrayList<Lugar> lugares;
    private Toolbar mToolbar;

    private LugarAdapter mLugarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvLugares = findViewById(R.id.rvLugares);
        mToolbar = findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        setTitle("Quito-Ecuador");

        lugares = new ArrayList<>();
        lugares.add(new Lugar(R.drawable.mitaddelmundo,"Mitad del Mundo", new LatLng(-0.0021951,-78.457995)));
        lugares.add(new Lugar(R.drawable.parque_lacarolina,"Parque La Carolina",new LatLng(-0.1813659,-78.4864656)));
        lugares.add(new Lugar(R.drawable.plaza_sanfrancisco,"Plaza San Francisco", new LatLng(-0.2207261,-78.5170617)));
        lugares.add(new Lugar(R.drawable.teleferico,"Teleférico",new LatLng(-0.1868535,-78.5393105)));

        GridLayoutManager gm = new GridLayoutManager(this, 2);
        rvLugares.setLayoutManager(gm);

        mLugarAdapter = new LugarAdapter(lugares, HomeActivity.this);
        rvLugares.setAdapter(mLugarAdapter);


    }
}