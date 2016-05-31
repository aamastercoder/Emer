package com.ash.emer.emergency;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ash.emer.emergency.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.common.GooglePlayServicesUtil;


public class mapp extends FragmentActivity implements OnMapReadyCallback,View.OnClickListener {
private double latitude;
    private double longitude;
    // Google Map
    private GoogleMap googleMap;
    private Button btnFind;
    private Button placeText;
    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.map);
        SharedPreferences pref_gps = getApplicationContext().getSharedPreferences("ggps", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref_gps.edit();
        latitude = Double.parseDouble(pref_gps.getString("lat", null));
        longitude = Double.parseDouble(pref_gps.getString("lon", null));
       //* Button btnFind = (Button) findViewById(R.id.btnFind);
       // btnFind.setOnClickListener(this);
        //EditText placeText=(EditText)findViewById(R.id.edtText4map);
        //placeText.setOnClickListener(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }
    @Override
    public void onClick(View v) {
    }


    @Override
    public void onMapReady(GoogleMap map) {
        // Add a marker in Sydney, Australia, and move the camera.

       // googleMap.getUiSettings().setZoomGesturesEnabled(true);
        SharedPreferences pref_gps = getApplicationContext().getSharedPreferences("ggps", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref_gps.edit();
        latitude = Double.parseDouble(pref_gps.getString("lat", null));
        longitude = Double.parseDouble(pref_gps.getString("lon", null));
        LatLng sydney = new LatLng(latitude, longitude);
        map.addMarker(new MarkerOptions().position(sydney).title("YOUR CURRENT LOCATION"));
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        LatLng coordinate = new LatLng(latitude,longitude);
        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 10);
        map.animateCamera(yourLocation);


    }
    public void onBackPressed() {
        Intent intent = new Intent(context, knowurloc.class);
        startActivity(intent);
        finish();
    }

}
