package com.ash.emer.emergency;

/**
 * Created by ashish on 9/12/2015.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.ToggleButton;
import static android.widget.CompoundButton.OnCheckedChangeListener;
//import com.example.ashish.emergency.R;

import java.io.IOException;

public class sirenplayer extends Activity {
    final Context context = this;

    private ToggleButton a1;
    private ToggleButton a2;
    private ToggleButton a3;
    private ToggleButton a4;
    private Switch s1;
    private Switch s2;
    private Button bck;
    final MediaPlayer mp1 = new MediaPlayer();
    final MediaPlayer mp2 = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.siren);
        /*
        a1 = (ToggleButton) findViewById(R.id.buttons);
        a1.setOnClickListener(this);
        a2 = (ToggleButton) findViewById(R.id.button2s);
        a2.setOnClickListener(this);
        a3 = (ToggleButton) findViewById(R.id.button3s);
        a3.setOnClickListener(this);
        a4 = (ToggleButton) findViewById(R.id.button4s);
        a4.setOnClickListener(this);
        */
        //bck=(Button) findViewById(R.id.buttonback2);
        //bck.setOnClickListener(this);
        s1 = (Switch) findViewById(R.id.switch1);
        s2 = (Switch) findViewById(R.id.switch2);
       // s1.setOnCheckedChangeListener(this);

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                              if (s1.isChecked() == true) {
                                                  mp1.seekTo(0);
                                                  mp1.setLooping(true);
                                                  mp1.start();

                                              } else if (s1.isChecked() == false) {
                                                  if (mp1.isPlaying() == true)
                                                      // Pause the music player
                                                      mp1.pause();
                                                  // mp1.reset();
                                              }
                                          }
                                      });

        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
            {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (s2.isChecked() == true) {
                        mp2.seekTo(0);

                        mp2.setLooping(true);
                        mp2.start();
                    } else if (s2.isChecked() == false) {
                        if (mp2.isPlaying() == true)
                            // Pause the music player
                            mp2.pause();
                    }
                }
            });
       // loadDataFromassets();

        AssetFileDescriptor afd;
        AssetFileDescriptor afd2;
        try {
            afd = getAssets().openFd("ambulance.mp3");
            mp1.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            mp1.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            afd2 = getAssets().openFd("policealarm.mp3");
            mp2.setDataSource(afd2.getFileDescriptor(),afd2.getStartOffset(),afd2.getLength());
            mp2.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.n);
    }

/*
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        {
if(s1.isChecked()==true)
{
    mp1.seekTo(0);
    mp1.setLooping(true);
    mp1.start();

    }
        else if(s1.isChecked()==false)
{if(mp1.isPlaying() == true)
    // Pause the music player
    mp1.pause();
    // mp1.reset();
    }
        if(s2.isChecked()==true)
        {mp2.seekTo(0);
            mp2.setLooping(true);
            mp2.start();}
        else if(s2.isChecked()==false)
        {if(mp2.isPlaying() == true)
            // Pause the music player
            mp2.pause();
        }

    /*
    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.buttons: {
                //final MediaPlayer mp1 = new MediaPlayer();

                mp1.seekTo(0);
                mp1.setLooping(true);
                mp1.start();

                break;
            }
            case R.id.button2s: {
                if(mp1.isPlaying() == true)
                    // Pause the music player
                    mp1.pause();
               // mp1.reset();
                break;
            }
            case R.id.button3s: {
                mp2.seekTo(0);
                mp2.setLooping(true);
                mp2.start();
                break;
            }
            case R.id.button4s: {
                if(mp2.isPlaying() == true)
                    // Pause the music player
                    mp2.pause();

                break;

            }
            case R.id.buttonback2: {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }
    }
    */
    @Override
    public void onBackPressed() {
        Intent intent= new Intent(context,MainActivity.class);
        startActivity(intent);
    }
}