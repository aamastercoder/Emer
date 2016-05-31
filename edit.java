package com.ash.emer.emergency;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

//import com.example.ashish.emergency.R;

/**
 * Created by ashish on 8/15/2015.
 */
public  class edit extends Activity implements View.OnClickListener {
    private Button bu1;
    //private Button bu2;
    private EditText e1;
    public long numb;
    final Context context = this;
    //calling applicationclass androidmainfest
    //final globalclass globalVariable = (globalclass) getApplicationContext();
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.editthenumber);
        bu1 = (Button) findViewById(R.id.buttone);
        bu1.setOnClickListener(this);
        // bu2 = (Button) findViewById(R.id.buttontwo);
        // bu2.setOnClickListener(this);
        e1 = (EditText) findViewById(R.id.editText1);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttone) {
            if (e1.getText().toString().matches("")) {
                value = "100";
                Toast.makeText(getApplicationContext(), "No. changed successfully to 100", Toast.LENGTH_SHORT).show();
            } else {
                value = e1.getText().toString();
                Toast.makeText(getApplicationContext(), "No. changed successfully", Toast.LENGTH_SHORT).show();
            }
            //String value = e1.getText().toString();
            // Toast.makeText(getApplicationContext(), "No. changed sucessfully", Toast.LENGTH_SHORT).show();
            numb = Long.parseLong(value);
            // SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

            //SharedPreferences.Editor editor = preferences.edit();
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("numb", value);
            editor.commit();

//to store variablein global class
            //globalVariable.setName(String.valueOf(numb));


        }
        /*
        else if (v.getId() == R.id.buttontwo) {
            Intent intent = new Intent(context, police.class);
            startActivity(intent);
            finish();
        }
        */
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(context, police.class);
        startActivity(intent);
        finish();
    }
}

