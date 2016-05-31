package com.ash.emer.emergency;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

/*class abc extends Activity{
    private  BroadcastReceiver mReceiver;
void onCreate() {

    IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);

    filter.addAction(Intent.ACTION_SCREEN_OFF);
    filter.addAction(Intent.ACTION_USER_PRESENT);
    mReceiver = new ScreenReceiver();
    this.registerReceiver(mReceiver, filter);

}
        }
        */
public class ScreenReceiver extends BroadcastReceiver {

    static int countPowerOff = 0;
    private Activity activity = null;

    public ScreenReceiver(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.v("onReceive", "Power button is pressed.");
       System.out.println(intent.getAction());
        Toast.makeText(context, "power button clicked", Toast.LENGTH_LONG)
                .show();

        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
         //   countPowerOff++;
            System.out.println("screen offf");
        }
         if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
             System.out.println("screen onnnn");
           //  if (countPowerOff == 5) {
                //Intent i = new Intent(activity, flash.class);
               // activity.startActivity(i);
          //  }
        }

    }
}