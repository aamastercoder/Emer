package com.ash.emer.emergency;

/**
 * Created by ashish on 9/12/2015.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

//import com.example.ashish.emergency.R;

//package com.example.ashish.emergency;

/**
 * Created by ashish on 8/15/2015.
 */


public class firebrigade extends Activity implements View.OnClickListener {
    private Button a1;
    private Button a2;
    private Button back2;
    String changednum;
    String  zeizi;
    String z;

    private TextView text1;
    final Context context = this;
    // Calling Application class (see application tag in AndroidManifest.xml)
    //final globalclass globalVariable = (globalclass) getApplicationContext();
    String previ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.firebrigade);
        a1 = (Button) findViewById(R.id.button1f);
        a1.setOnClickListener(this);
        a2 = (Button) findViewById(R.id.button2f);
        a2.setOnClickListener(this);
        //back2 = (Button) findViewById(R.id.back2);
        //back2.setOnClickListener(this);
        // a3 = (Button) findViewById(R.id.button3p);
        //a3.setOnClickListener(this);
        //final String previ  = globalVariable.getName();
        text1 = (TextView) findViewById(R.id.textView3f);
        //text1.setText(previ);
        //Toast.makeText(getApplicationContext(), previ, Toast.LENGTH_SHORT).show();
        //edit1 = (EditText) findViewById(R.id.textView3);
//obeject not working to get string from another class
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("MyPref3", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref3.edit();
        changednum= pref3.getString("numb", null);
        z=changednum;
        //Toast.makeText(getApplicationContext(), changednum, Toast.LENGTH_SHORT).show();
        if(z==null) {
            z = "101";
            text1.setText("101");
        }
        else
            text1.setText(z);
    }



    @Override
    public void onClick(View v) {
        text1.setText(z);


        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        // changednum = preferences.getString("numb", "");
        // text1.setText(changednum);
        //zeizi=changednum;


        switch (v.getId())
        {

            case R.id.button1f:
            {
                {
                    Intent intent = new Intent(context, edit3.class);
                    startActivity(intent);
                }

                //String z = edit.numb.getText().toString();
                // Toast.makeText(getApplicationContext(), "number changes successfully", Toast.LENGTH_SHORT).show();
                break;
            }



            case R.id.button2f:
            {

                ////// Toast.makeText(getApplicationContext(), changednum, Toast.LENGTH_SHORT).show();
                // Intent intent = new Intent(Intent.ACTION_CALL);
                String number = "tel:" + z;
                //.getText().toString().trim();
                //intent.setData(Uri.parse("tel:z"));
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(number));
                startActivity(callIntent);
                break;


            }
            /*
            case R.id.back2:
                Intent callIntent = new Intent(context,MainActivity.class);
                startActivity(callIntent);
                finish();
                break;
                */


        }

        //edit obj=new edit();
        //int number=obj.numb;
        //Toast.makeText(getApplicationContext(), number, Toast.LENGTH_SHORT).show();

        //text1.setText(a.numb);
    }
    @Override
    public void onBackPressed() {
        Intent callIntent = new Intent(context,MainActivity.class);
        startActivity(callIntent);
        finish();
    }
}
