package com.ash.emer.emergency;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

//import com.example.ashish.emergency.R;

/**
 * Created by ashish on 9/13/2015.
 */
public class morsecodeflash extends Activity implements View.OnClickListener {
    final Context context = this;
    String myMorseString = "111000111";
    private Button bum;
    private Button bk3;
    public int click=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.morse);
        bum = (Button) findViewById(R.id.buttonm);
        bum.setOnClickListener(this);
        //bk3 = (Button) findViewById(R.id.buttonbk3);
        // bk3.setOnClickListener(this);
    }
    static Camera cam = null;
    @Override
    public void onClick(View v) {
        //final int cam;
        //sleeptime;
      //  switch(v.getId())
      //  {
        //    case R.id.buttonm: {
        ++click;
        System.out.println("click is"+click);
        if(click==1) {
            // bum.setEnabled(false);
            // bum.setClickable(false);

            new Thread() {
                public void run() {
                    if (myMorseString != null) {
                        for (int x = 0; x < myMorseString.length(); x++) {
                            if (myMorseString.charAt(x) == '2') {
                                cam = Camera.open();
                                int sleepTime = 500;
                                Camera.Parameters p = cam.getParameters();
                                p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                                cam.setParameters(p);
                                cam.startPreview();
                                try {
                                    Thread.sleep(sleepTime);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                // power off after signal
                                cam.stopPreview();
                                cam.release();
                                cam = null;
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (myMorseString.charAt(x) == '1') {
                                cam = Camera.open();
                                int sleepTime = 250;
                                Camera.Parameters p = cam.getParameters();
                                p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                                cam.setParameters(p);
                                cam.startPreview();
                                try {
                                    Thread.sleep(sleepTime);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                // power off after signal
                                cam.stopPreview();
                                cam.release();
                                cam = null;
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (myMorseString.charAt(x) == '0') {
                                cam = Camera.open();
                                int sleepTime = 250;
                                Camera.Parameters p = cam.getParameters();
                                cam.setParameters(p);
                                //cam.startPreview();
                                cam.stopPreview();
                                cam.release();
                                cam = null;
                                try {
                                    Thread.sleep(sleepTime);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        click = 0;
                        System.out.println("click is after"+click);
                    }
                }
            }.start();
        }



         //   bum.setEnabled(true);
          //  bum.setClickable(true);
          ///  break;
            /*
            case R.id.buttonbk3:
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();
                break;
                */
      //  }

    }
    @Override
    public void onBackPressed() {
        Intent callIntent = new Intent(context,MainActivity.class);
        startActivity(callIntent);
        finish();
    }
}
