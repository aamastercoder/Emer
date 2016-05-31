package com.ash.emer.emergency;

/**
 * Created by ashish on 9/12/2015.
 */

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

//import com.example.ashish.emergency.R;

//package com.example.ashish.emergency;


/**
 * Created by ashish on 8/15/2015.
 */
public  class edit3 extends Activity implements View.OnClickListener {
    private Button bu1;
  //  private Button bu2;
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
            setContentView(R.layout.editthenumber3);
            bu1 = (Button) findViewById(R.id.buttonef);
            bu1.setOnClickListener(this);
       // bu2 = (Button) findViewById(R.id.buttontwof);
       // bu2.setOnClickListener(this);
        e1 = (EditText) findViewById(R.id.editText1f);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonef) {
            if(e1.getText().toString().matches(""))
            {
                value="101";
                Toast.makeText(getApplicationContext(), "No. changed successfully to 101", Toast.LENGTH_SHORT).show();
            }
            else {
                value = e1.getText().toString();
                Toast.makeText(getApplicationContext(), "No. changed successfully", Toast.LENGTH_SHORT).show();
            }
            //String value = e1.getText().toString();
           // Toast.makeText(getApplicationContext(), "No. changed sucessfully", Toast.LENGTH_SHORT).show();
           // numb = Integer.parseInt(value);
            // SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

            //SharedPreferences.Editor editor = preferences.edit();
            SharedPreferences pref3 = getApplicationContext().getSharedPreferences("MyPref3", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref3.edit();
            editor.putString("numb", value);
            editor.commit();

//to store variablein global class
            //globalVariable.setName(String.valueOf(numb));


        }/* else if (v.getId() == R.id.buttontwof) {
            Intent intent = new Intent(context, firebrigade.class);
            startActivity(intent);
            finish();
        }
        */
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(context, firebrigade.class);
        startActivity(intent);
        finish();
    }

}
