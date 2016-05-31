package com.ash.emer.emergency;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//package com.example.ashish.emergency;

//import com.example.ashish.emergency.R;

/**
 * Created by ashish on 8/15/2015.
 */
public  class edit2 extends Activity implements View.OnClickListener {
    private Button bu1;
   // private Button bu2;
    private EditText e1;
    public long numb;
    final Context context = this;
    String value;
    //calling applicationclass androidmainfest
    //final globalclass globalVariable = (globalclass) getApplicationContext();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.editthenumber2);
        bu1 = (Button) findViewById(R.id.buttonea);
        bu1.setOnClickListener(this);
       // bu2 = (Button) findViewById(R.id.buttontwoa);
      //  bu2.setOnClickListener(this);
        e1 = (EditText) findViewById(R.id.editText1a);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonea) {
                  if(e1.getText().toString().matches(""))
                  {
                      value="102";
                      Toast.makeText(getApplicationContext(), "No. changed successfully to 102", Toast.LENGTH_SHORT).show();
                  }
            else {
                      value = e1.getText().toString();
                      Toast.makeText(getApplicationContext(), "No. changed successfully", Toast.LENGTH_SHORT).show();
                  }
           // Toast.makeText(getApplicationContext(), "No. changed sucessfully", Toast.LENGTH_SHORT).show();
            //numb = Integer.parseInt(value);
            // SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

            //SharedPreferences.Editor editor = preferences.edit();
            SharedPreferences pref2 = getApplicationContext().getSharedPreferences("MyPref2", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref2.edit();
            editor.putString("numb", value);
            editor.commit();

//to store variablein global class
            //globalVariable.setName(String.valueOf(numb));


        } /*else if (v.getId() == R.id.buttontwoa) {
            Intent intent = new Intent(context, ambulance.class);
            startActivity(intent);
            finish();
        }
        */
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(context, ambulance.class);
        startActivity(intent);
        finish();
    }
}
