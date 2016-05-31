package com.ash.emer.emergency;

import android.app.Activity;
//import android.support.v7.app.ActionBarActivity;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.content.Intent;
import android.content.Context;
import android.widget.ImageButton;
import android.widget.Toast;

//import com.example.ashish.emergency.R;


public class MainActivity extends Activity implements View.OnClickListener {

   ImageButton b3,b4,b5,b6,b7,b8,b9;
   // Button b9;
    ImageButton b1,b2;
    final Context context = this;
   int backButtonCount=0;
   // boolean doubleBackToExitPressedOnce = false;
   private ScreenReceiver mReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        /*SharedPreferences settings = getSharedPreferences("prefs", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("firstRun", false);
        editor.commit();

        boolean firstRun = settings.getBoolean("firstRun", true);
        Log.d("TAG1", "firstRun: " + Boolean.valueOf(firstRun).toString());*/
        //////////////////
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
         mReceiver = new ScreenReceiver (this);
        registerReceiver(mReceiver, filter);
        /////////////////////
        b1 = (ImageButton) findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2 = (ImageButton) findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3 = (ImageButton) findViewById(R.id.b3);
        b3.setOnClickListener(this);
        b4 = (ImageButton) findViewById(R.id.b4);
        b4.setOnClickListener(this);
        b5 = (ImageButton) findViewById(R.id.b5);
        b5.setOnClickListener(this);
        b6 = (ImageButton) findViewById(R.id.b6);
        b6.setOnClickListener(this);
        b7 = (ImageButton) findViewById(R.id.b7);
        b7.setOnClickListener(this);
        b8 = (ImageButton) findViewById(R.id.b8);
        b8.setOnClickListener(this);
        b9 = (ImageButton) findViewById(R.id.b9);
        b9.setOnClickListener(this);

    }
    @Override
    protected void onDestroy()
    {
        if (mReceiver != null)
        {
            unregisterReceiver(mReceiver);
            mReceiver = null;
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    long back_pressed;
    @Override
    public void onBackPressed() {


        if (back_pressed + 1000 > System.currentTimeMillis()){
            super.onBackPressed();
        }
        else{
            Toast.makeText(getBaseContext(),
                    "Press once again to exit!", Toast.LENGTH_SHORT)
                    .show();
        }
        back_pressed = System.currentTimeMillis();
    }
    @Override
    public void onClick(View arg0)
    {

        switch(arg0.getId())
        {
            case R.id.b1:
            {
                Intent intent= new Intent(context,flash.class);
                startActivity(intent);
                break;

            }
            case R.id.b2:
            {
                Intent intent= new Intent(context,police.class);
                startActivity(intent);
                break;

            }
            case R.id.b3:
                          {
                              Intent intent= new Intent(context,ambulance.class);
                              startActivity(intent);
                              break;


            }
            case R.id.b4:
            {
                Intent intent= new Intent(context,firebrigade.class);
                startActivity(intent);
                break;
            }
            case R.id.b5:
            {
                Intent intent= new Intent(context,sirenplayer.class);
                startActivity(intent);
                break;
            }
            case R.id.b6:
            {
                Intent intent= new Intent(context,morsecodeflash.class);
                startActivity(intent);
                break;
                //GPSTracker gps = new GPSTracker(this);
                //if(gps.canGetLocation()){ // gps enabled} // return boolean true/false

                }
            case R.id.b7:
            {
                Intent intent= new Intent(context,knowurloc.class);
                startActivity(intent);
                break;
                //GPSTracker gps = new GPSTracker(this);
                //if(gps.canGetLocation()){ // gps enabled} // return boolean true/false

            }
            case R.id.b8:
            {
               Intent intent= new Intent(context,compas.class);
                startActivity(intent);
                break;
                //GPSTracker gps = new GPSTracker(this);
                //if(gps.canGetLocation()){ // gps enabled} // return boolean true/false

            }
            case R.id.b9: {
                 Intent intent= new Intent(context,about.class);
                startActivity(intent);
                break;
            }

        }
    }
    /*@Override
    public void onBackPressed() {
        //super.onBackPressed();

        finish();
    }*/
    /**
     * Back button listener.
     * Will close the application if the back button pressed twice.
     */

    /*@Override
    public void onBackPressed()
    {
        int pid = android.os.Process.myPid();
        android.os.Process.killProcess(pid);
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
        //finish();
        //moveTaskToBack(true);
        //this.finishAffinity();
    }
     /*   if(backButtonCount >= 1)
        {
            backButtonCount=0;




            /*Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }
        else
        {
            Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }
    }*/

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
