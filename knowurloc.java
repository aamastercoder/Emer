package com.ash.emer.emergency;

 import android.app.Activity;
 import android.app.AlertDialog;
 import android.content.Context;
 import android.content.DialogInterface;
 import android.content.SharedPreferences;
 import android.location.LocationListener;
import android.os.Bundle;

import android.location.Location;
//import android.location.LocationListener;
import android.location.LocationManager;

 import android.provider.Settings;
 import android.view.View;
 import android.view.Window;
 import android.widget.Button;
 import android.widget.TextView;
 import android.widget.Toast;
 import android.content.Intent;

 //import com.example.ashish.emergency.R;


/**
 * Created by ashish on 8/28/2015.
 */
public class knowurloc extends Activity implements LocationListener, View.OnClickListener {
    final Context context = this;
    private LocationManager locationManager;

    private TextView text1;
    private TextView text2;
    private Button bu1;
    //private Button bubk;
    private Button gm;


    /**
     * Called when the activity is first created.
     */

    //@Override

        /*public void onCreate(Bundle savedInstanceState)

        {

            super.onCreate(savedInstanceState);

            setContentView(R.layout.gps);
            text1 = (TextView) findViewById(R.id.textView4);
            //text1.setText("100");
            text1 = (TextView) findViewById(R.id.textView5);
            //text1.setText("100");
*/
    double lati;
    double longi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.gps);
        text1 = (TextView) findViewById(R.id.textView4);
        //text1.setText("100");
        text2 = (TextView) findViewById(R.id.textView5);
        bu1 = (Button) findViewById(R.id.btnfamily);
        bu1.setOnClickListener(this);
        //bubk = (Button) findViewById(R.id.buttonbk);
      //  bubk.setOnClickListener(this);
        gm = (Button) findViewById(R.id.buttongmgps);
        gm.setOnClickListener(this);

gm.setEnabled(false);
        gm.setClickable(false);
       // gm.setVisibiity(VIEW.INVISIBLE);


        /********** get Gps location service LocationManager object ***********/
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

                /* CAL METHOD requestLocationUpdates */

        // Parameters :
        //   First(provider)    :  the name of the provider with which to register
        //   Second(minTime)    :  the minimum time interval for notifications,
        //                         in milliseconds. This field is only used as a hint
        //                         to conserve power, and actual time between location
        //                         updates may be greater or lesser than this value.
        //   Third(minDistance) :  the minimum distance interval for notifications, in meters
        //   Fourth(listener)   :  a {#link LocationListener} whose onLocationChanged(Location)
        //                         method will be called for each location update


        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                5000,   // 5 sec
                10, this);

        /********* After registration onLocationChanged method  ********/
        /********* called periodically after each 3 sec ***********/
    }

    /**
     * ********** Called after each 3 sec *********
     */
    @Override
    public void onLocationChanged(Location location) {

        String str = "Latitude: " + location.getLatitude() + "Longitude: " + location.getLongitude();
        lati = location.getLatitude();
        //String la=lati.toString;
        text1.setText(String.valueOf(lati));
        longi = location.getLongitude();
        text2.setText(String.valueOf(longi));
        if(lati!=0&&longi!=0) {
            gm.setEnabled(true);
            gm.setClickable(true);
        }

    }

    @Override
    public void onProviderDisabled(String provider) {

        /******** Called when User off Gps *********/
      //  startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));

       Toast.makeText(getBaseContext(), "Gps turned off ,Please switch on GPS LOCATION", Toast.LENGTH_LONG).show();
                 }

    @Override
    public void onProviderEnabled(String provider) {

        /******** Called when User on Gps  *********/

        Toast.makeText(getBaseContext(), "Gps turned on ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onClick(View arg0) {
        System.out.println("latitide"+lati+"longitude"+longi);

        SharedPreferences pref5 = getApplicationContext().getSharedPreferences("famsms", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref5.edit();
        editor.putString("lat", String.valueOf(lati));
        //  Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
        editor.putString("lon", String.valueOf(longi));
        editor.commit();
        if(lati!=0&&longi!=0) {
            gm.setEnabled(true);
            gm.setClickable(true);
        }
        //Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
        switch (arg0.getId()) {
            case R.id.btnfamily: {
                //Toast.makeText(getApplicationContext(), "hello yo button working", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, familysms.class);
                startActivity(intent);

                break;

            }
            /*
            case R.id.buttonbk: {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            }
            */
            case R.id.buttongmgps: {
                SharedPreferences pref_gps = getApplicationContext().getSharedPreferences("ggps", MODE_PRIVATE);
                SharedPreferences.Editor editor1 = pref_gps.edit();
                editor1.putString("lat", String.valueOf(lati));
                editor1.putString("lon", String.valueOf(longi));
                editor1.commit();

                    Intent intent = new Intent(context, mapp.class);
                    startActivity(intent);
                    finish();
                    break;

            }
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent= new Intent(context,MainActivity.class);
        startActivity(intent);
    }
}

