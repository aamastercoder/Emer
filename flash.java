package com.ash.emer.emergency;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

//import com.example.ashish.emergency.R;

/**
 * Created by ashish on 8/15/2015.
 */

public class flash extends Activity implements View.OnClickListener {
    private Camera camera;
    ImageButton flashlightSwitchImg;
    Button onoff;
    private boolean isFlashlightOn;
    Parameters params;
    final Context context = this;
   //private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this,"NOTE: Tap on bulb to turn flashlight ON/OFF",
                Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.flashlight);
      //  back=(Button)findViewById(R.id.buttonbac2);
     //   back.setOnClickListener(this);
        // flashlight on off Image
        flashlightSwitchImg = (ImageButton) findViewById(R.id.flashlightSwitch);
        onoff=(Button)findViewById(R.id.buttonqwedc);
        onoff.setOnClickListener(this);
        boolean isCameraFlash = getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if (!isCameraFlash) {
            showNoCameraAlert();
        } else {
            camera = Camera.open();
            params = camera.getParameters();
        }

        flashlightSwitchImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFlashlightOn) {
                    setFlashlightOff();
                } else {
                    setFlashlightOn();
                }
            }
        });
    }
    /*
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_POWER) {
            Toast.makeText(getApplicationContext(), "shortttt...", Toast.LENGTH_SHORT).show();
            event.startTracking(); // Needed to track long presses
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_POWER) {
            Toast.makeText(getApplicationContext(), "longgggggg...", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onKeyLongPress(keyCode, event);
    }
    */
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "not working...", Toast.LENGTH_SHORT).show();
        switch (v.getId()) {
            case R.id.buttonqwedc: {
                //Toast.makeText(getApplicationContext(), "hello its working", Toast.LENGTH_SHORT).show();

                break;
            }
        }
    }
    int i = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_POWER)
        {
            i++;
            if(i == 4)
            {
              System.out.println("4 power button clicks");
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private void showNoCameraAlert(){
        new AlertDialog.Builder(this)
                .setTitle("Error: No Camera Flash!")
                .setMessage("Camera flashlight not available in this Android device!")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish(); // close the Android app
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
        return;
    }
    private void setFlashlightOn() {
        params = camera.getParameters();
        params.setFlashMode(Parameters.FLASH_MODE_TORCH);
        camera.setParameters(params);
        camera.startPreview();
        isFlashlightOn = true;
        flashlightSwitchImg.setImageResource(R.drawable.onbulbp);
    }

    private void setFlashlightOff() {
        params.setFlashMode(Parameters.FLASH_MODE_OFF);
        camera.setParameters(params);
        camera.stopPreview();
        isFlashlightOn = false;
        flashlightSwitchImg.setImageResource(R.drawable.offbulbp);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (camera != null) {
            camera.release();
            camera = null;
        }
    }
    @Override
    public void onBackPressed() {
        Intent callIntent = new Intent(context,MainActivity.class);
        startActivity(callIntent);
        finish();
    }
}
