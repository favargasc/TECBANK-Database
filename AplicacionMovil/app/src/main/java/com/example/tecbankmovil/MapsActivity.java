package com.example.tecbankmovil;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.tecbankmovil.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    private int accountId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accountId = getIntent().getIntExtra("accountId",-1);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng AlajuelaCentro = new LatLng(10.012097117212127, -84.21592265422746);
        mMap.addMarker(new MarkerOptions().position(AlajuelaCentro).title("Sucursal TECBANK Alajuela centro").snippet("Horario:"+ "\n" + " L-V 7:00am a 8:00pm" + "\n" + "S-D: 7:00am a 12:00md"));
        LatLng oxigenoMall = new LatLng(9.994062551330842, -84.13133197458215);
        mMap.addMarker(new MarkerOptions().position(oxigenoMall).title("Sucursal TECBANK Oxigeno").snippet("Horario:"+ "\n" + " L-V 7:00am a 8:00pm" + "\n" + "S-D: 7:00am a 12:00md"));
        LatLng paseoMetropoli = new LatLng(9.867174054011855, -83.94256866108913);
        mMap.addMarker(new MarkerOptions().position(paseoMetropoli).title("Sucursal TECBANK Paseo Metropoli").snippet("Horario:"+ "\n" + " L-V 7:00am a 8:00pm" + "\n" + "S-D: 7:00am a 12:00md"));
        LatLng citymall = new LatLng(10.004497047283103, -84.21166294125608);
        mMap.addMarker(new MarkerOptions().position(citymall).title("Sucursal TECBANK City Mall").snippet("Horario:"+ "\n" + " L-V 7:00am a 8:00pm" + "\n" + "S-D: 7:00am a 12:00md"));

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                LinearLayout info = new LinearLayout(MapsActivity.this);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(MapsActivity.this);
                title.setBackgroundColor(getResources().getColor(R.color.red));
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(MapsActivity.this);
                //snippet.setBackgroundColor(getResources().getColor(R.color.redlight));
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }
        });

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(AlajuelaCentro,10));
    }
}