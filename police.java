package com.ash.emer.emergency;

import android.app.Activity;
//import android.
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.content.Intent;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;

//import com.example.ashish.emergency.R;


/**
 * Created by ashish on 8/15/2015.
 */
public class police extends Activity implements View.OnClickListener {
    private Button a1;
    private Button a2;
    private Button a3;
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
        setContentView(R.layout.policecall);
        a1 = (Button) findViewById(R.id.button1p);
        a1.setOnClickListener(this);
        a2 = (Button) findViewById(R.id.button2p);
        a2.setOnClickListener(this);
       // a3 = (Button) findViewById(R.id.back1);
        //a3.setOnClickListener(this);
       // a3 = (Button) findViewById(R.id.button3p);
        //a3.setOnClickListener(this);
        //final String previ  = globalVariable.getName();
        text1 = (TextView) findViewById(R.id.textView3);
       //text1.setText(previ);
        //Toast.makeText(getApplicationContext(), previ, Toast.LENGTH_SHORT).show();
        //edit1 = (EditText) findViewById(R.id.textView3);
//obeject not working to get string from another class
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
       SharedPreferences.Editor editor = pref.edit();
       changednum= pref.getString("numb", null);
        z=changednum;
        //Toast.makeText(getApplicationContext(), changednum, Toast.LENGTH_SHORT).show();
        if(z==null) {
            z = "100";
            text1.setText("100");
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

            case R.id.button1p:
            {
                {
                    Intent intent = new Intent(context, edit.class);
                    startActivity(intent);
                    finish();
                }

               //String z = edit.numb.getText().toString();
               // Toast.makeText(getApplicationContext(), "number changes successfully", Toast.LENGTH_SHORT).show();
            break;
            }



            case R.id.button2p: {

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
            case R.id.back1:
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
        Intent intent= new Intent(context,MainActivity.class);
        startActivity(intent);
    }
}
