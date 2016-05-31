package com.ash.emer.emergency;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.telephony.gsm.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.ashish.emergency.R;

/**
 * Created by ashish on 9/19/2015.
 */
public class familysms  extends Activity implements View.OnClickListener {
    private Button b1;
    private ImageButton im1,im2,im3;
    private Button b2;
   // private Button b3;
    private TextView text1;
    private TextView text2;
    private EditText e1;
    private EditText e2;
    private EditText e3;
    private EditText e4;
    private EditText e5;
    private EditText e6;
    private EditText e7;
    public String latitude, longitude;
    final Context context = this;
    String smsmess;
    String message;
    public String glname1="";
    public String glnum1="";
    public String glname2="";
    public String glnum2="";
    public String glname3="";
    public String glnum3="";
    public int flag=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.family);
        b1 = (Button) findViewById(R.id.buttonfa);
        b1.setOnClickListener(this);

        b2 = (Button) findViewById(R.id.button2fa);
        b2.setOnClickListener(this);
        //b3 = (Button) findViewById(R.id.buttoncontact);
       // b3.setOnClickListener(this);
        im1=(ImageButton)findViewById(R.id.ibutt1);
        im1.setOnClickListener(this);
        im2=(ImageButton)findViewById(R.id.ibutt2);
        im2.setOnClickListener(this);
        im3=(ImageButton)findViewById(R.id.ibutt3);
        im3.setOnClickListener(this);
        e7=(EditText)findViewById(R.id.edit100);
        e7.setOnClickListener(this);
        text1 = (TextView) findViewById(R.id.textView9);
        //text1.setOnClickListener(this);
        text2 = (TextView) findViewById(R.id.textView12);
        //text2.setOnClickListener(this);
        e1 = (EditText) findViewById(R.id.editTexts1);
       // e1.setText("name is bebo");
        e1.setOnClickListener(this);
        e2 = (EditText) findViewById(R.id.editTexts2);
        e2.setOnClickListener(this);
        e3 = (EditText) findViewById(R.id.editTexts3);
        e3.setOnClickListener(this);
        e4 = (EditText) findViewById(R.id.editTexts4);
        e4.setOnClickListener(this);
        e5 = (EditText) findViewById(R.id.editTexts5);
        e5.setOnClickListener(this);
        e6 = (EditText) findViewById(R.id.editTexts6);
        e6.setOnClickListener(this);
        SharedPreferences pref5 = getApplicationContext().getSharedPreferences("famsms", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref5.edit();
        latitude = pref5.getString("lat", null);
        longitude = pref5.getString("lon", null);
        text1.setText(latitude);
        text2.setText(longitude);
        message="HELP ME I AM IN DANGER , MY LOCATION:"+latitude+","+longitude;
        SharedPreferences pref6 = getApplicationContext().getSharedPreferences("savfam", MODE_PRIVATE);
        SharedPreferences.Editor editor2 = pref6.edit();
       // String z=;
        try {


          // if (pref6.getString("name1", null).equals(""))
          //   e1.setText("Enter name here");
          //e
            e1.setText(pref6.getString("name1", null));

          //f (pref6.getString("phone1", null).equals(null))
           //     e2.setText("Enter phone no. here");
      //      else
                e2.setText(pref6.getString("phone1", null));

      //      if (pref6.getString("name2", null).equals(null))
          //      e3.setText("Enter name here");
        //    else
                e3.setText(pref6.getString("name2", null));

        //    if (pref6.getString("phone2", null).equals(null))
         //       e4.setText("Enter phone no. here");
         //   else
                e4.setText(pref6.getString("phone2", null));

       //     if (pref6.getString("name3", null).equals(null))
       //         e5.setText("Enter name here");
        //    else
                e5.setText(pref6.getString("name3", null));

        //    if (pref6.getString("phone3", null).equals(null))
        //        e6.setText("Enter phone no. here");
        //    else
                e6.setText(pref6.getString("phone3", null));
        }
        catch(Exception e)
        {
            System.out.println("exception is"+e);
        }



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2fa:
            {
                String name1 = e1.getText().toString();
                String name2 = e3.getText().toString();
                String name3 = e5.getText().toString();
                String phone1 = e2.getText().toString();
                String phone2 = e4.getText().toString();
                String phone3 = e6.getText().toString();



                //numb = Integer.parseInt(value);
                // SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

                //SharedPreferences.Editor editor = preferences.edit();
                SharedPreferences pref6 = getApplicationContext().getSharedPreferences("savfam", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref6.edit();
                editor.putString("name1", name1);
                editor.putString("name2", name2);
                editor.putString("name3", name3);
                editor.putString("phone1", phone1);
                editor.putString("phone2", phone2);
                editor.putString("phone3", phone3);
                editor.commit();
                Toast.makeText(getApplicationContext(), "Information saved successfully", Toast.LENGTH_SHORT).show();

break;
        }
            case R.id.buttonfa:
            {
                sendSMSMessage();
               // changednum= pref.getString("numb", null);
                break;
            }
            case R.id.ibutt1: {
                flag=1;
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
//readContacts();
                startActivityForResult(intent, 1);

              //  System.out.println("name1" + glname + "number is1" + glnum);
              //  glname="";
              //  glnum="";
                break;
            }
                case R.id.ibutt2: {
                    flag=2;
                   Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
//readContacts();
                    startActivityForResult(intent, 1);
                   // System.out.println("name2"+glname+"number is2"+glnum);
                   // glname="";
                   // glnum="";
                    break;
                }
                    case R.id.ibutt3:
                    {
                        flag=3;
                       Intent intent= new Intent(Intent.ACTION_PICK,  ContactsContract.Contacts.CONTENT_URI);
//readContacts();
                       startActivityForResult(intent, 1);
                      //  System.out.println("name3"+glname+"number is3"+glnum);
                      //  glname="";
                      //  glnum="";
                        break;
        }
        }
    }

    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
/*
        if (resultCode == Activity.RESULT_OK) {
            Uri contactData = data.getData();
            Cursor c =  managedQuery(contactData, null, null, null, null);
            if (c.moveToFirst()) {
                String name = c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                System.out.println("name is "+name);
                //  Intent intent = new Intent(CurrentActivity.this, NewActivity.class);
                //  intent.putExtra("name", name);
                //  startActivityForResult(intent, 0);
            }
            */
        Uri contactData = data.getData();
            ContentResolver cr = getContentResolver();
            Cursor cq = cr.query(contactData, null, null, null, null);
        if (resultCode ==Activity.RESULT_CANCELED)
        {
           // super.onActivityResult(requestCode, resultCode, data);
            Intent intent= new Intent(context,MainActivity.class);
           startActivity(intent);//Here you can handle,do anything you want
        }
        try {

            if (cq.moveToFirst()) {
                String id = cq
                        .getString(cq
                                .getColumnIndexOrThrow(ContactsContract.Contacts._ID));

                String hasPhone = cq
                        .getString(cq
                                .getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

                if (hasPhone.equalsIgnoreCase("1")) {
                    Cursor phones = getContentResolver()
                            .query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                    null,
                                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID
                                            + " = " + id, null, null);
                    phones.moveToFirst();
                    String cNumber = phones
                            .getString(phones
                                    .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    Toast.makeText(getApplicationContext(), cNumber,
                            Toast.LENGTH_SHORT).show();

                    String nameContact = cq
                            .getString(cq
                                    .getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
//System.out.println("name "+nameContact+"phone no"+cNumber);
                    //String number = phones.getString(phones.getColumnIndex(Phone.NUMBER));
                    //glname=nameContact;
                    //glnum=cNumber;
                    if (flag == 1) {
                        System.out.println("flag 1 is " + flag);
                        glname1 = nameContact;
                        glnum1 = cNumber;
                        flag = 0;
                        e1.setText(glname1);
                        e2.setText(glnum1);
                        glname1 = "";
                        glnum1 = "";
                    }
                    if (flag == 2) {
                        glname2 = nameContact;
                        glnum2 = cNumber;
                        System.out.println("flag 2 is " + flag);
                        flag = 0;
                        e3.setText(glname2);
                        e4.setText(glnum2);
                        glname2 = "";
                        glnum2 = "";
                    }

                    if (flag == 3) {
                        glname3 = nameContact;
                        glnum3 = cNumber;
                        System.out.println("flag 3 is " + flag);
                        flag = 0;
                        e5.setText(glname3);
                        e6.setText(glnum3);
                        glname3 = "";
                        glnum3 = "";
                    }
                }
            }
        }

                catch(Exception e)
                {
                    System.out.println("exception is"+e);
                }
            }


    protected void sendSMSMessage() {
        String editedd =e7.getText().toString();
        message=message+"  "+editedd;
        Log.i("Send SMS", "");
        //String phoneNo = txtphoneNo.getText().toString();
       // String message = txtMessage.getText().toString();
        SharedPreferences pref6 = getApplicationContext().getSharedPreferences("savfam", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref6.edit();
        SmsManager smsManager = SmsManager.getDefault();
        try
        {

            //changednum= pref.getString("numb", null);

            ////////important   Toast.makeText(getApplicationContext(), pref6.getString("phone1", null), Toast.LENGTH_SHORT).show();
            smsManager.sendTextMessage(pref6.getString("phone1", null), null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent to " + pref6.getString("phone1", null), Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "SMS for 1st person failed due to wrong number.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } try
        {
            smsManager.sendTextMessage(pref6.getString("phone2", null), null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent to " + pref6.getString("phone2", null), Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "SMS for 2nd person failed due to wrong number. .", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        try
        {
            smsManager.sendTextMessage(pref6.getString("phone3", null), null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent to "+pref6.getString("phone3", null), Toast.LENGTH_LONG).show();
        }

        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "SMS for 3rd person failed due to wrong number. .", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent= new Intent(context,knowurloc.class);
        startActivity(intent);
        finish();
    }
    }

