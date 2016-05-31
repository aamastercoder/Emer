package com.ash.emer.emergency;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;



/**
 * Created by ashish on 10/25/2015.
 */

public class about extends Activity  {
    //implements View.OnClickListener {
    final Context context = this;
   // private TextView text;
    //private Button bk2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.about);
      //  text = (TextView)findViewById(R.id.b1);
       // bk2 = (Button) findViewById(R.id.buttonbk2);
        //bk2.setOnClickListener(this);
        //text.setOnClickListener(this);
    }
/*
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.buttonbk2: {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();
            }
            break;
        }
    }
    */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

    //@Override
    //public void onClick(View arg0) {
    //}


