package com.ash.emer.emergency;

/**
 * Created by ashish on 5/14/2016.
 */
import java.util.ArrayList;

import android.app.Activity;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
//class broadcast extends Activity{
/*private void registerBroadcastReceiver() {
final IntentFilter theFilter = new IntentFilter();
        /** System Defined Broadcast
        theFilter.addAction(Intent.ACTION_SCREEN_ON);
        theFilter.addAction(Intent.ACTION_SCREEN_OFF);

        BroadcastReceiver screenOnOffReceiver = new BroadcastReceiver() {
@Override
public void onReceive(Context context, Intent intent) {
        String strAction = intent.getAction();

        KeyguardManager myKM = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);

        if (strAction.equals(Intent.ACTION_SCREEN_OFF) || strAction.equals(Intent.ACTION_SCREEN_ON))
        {
        if( myKM.inKeyguardRestrictedInputMode())
        {
                Log.v("#@%@%#", "Power button is lockedddd.");
                Toast.makeText(getApplicationContext(),"locked iygyguygoyoygoy",Toast.LENGTH_LONG).show();
        System.out.println("Screen off " + "LOCKED");
        } else
        {
                Log.v("#@%@%#", "Power button iunlocked.");

                Toast.makeText(getApplicationContext(),"unlocked",Toast.LENGTH_LONG).show();
        System.out.println("Screen off " + "UNLOCKED");
        }
        }
        }
        };

      //  getApplicationContext().registerReceiver(screenOnOffReceiver, theFilter);
        }
*/
public class broadcast extends BroadcastReceiver {

public boolean qwer;
    @Override
    public void onReceive(Context arg0, Intent intent) {
        System.out.println("broadcast 1");
        // TODO Auto-generated method stub
if(intent.getAction().equals("android.intent.action.SCREEN_OFF"))
{
    qwer=true;
    }
        else if(intent.getAction().equals("android.intent.action.SCREEN_ON")) {
qwer=false;
}

        Log.v("#@%@%#", "Power button is pressed.");

        Toast.makeText(arg0, "power button clicked",Toast.LENGTH_LONG).show();

        //perform what you want here
    }
}
