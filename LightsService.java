package com.ash.emer.emergency;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

//public class LightsService extends Service {
    /*
    public static final int MSG_REGISTER_CLIENT = 1;
    public static final int MSG_SET_INT_VALUE = 3;
    public static final int MSG_UNREGISTER_CLIENT = 2;
    public static final int NEED_TO_CLOSE_WHITE_SCREEN_ACTIVITY = 11;
    public static final int WHITE_SCREEN_ACTIVITY_WAS_CLOSED = 10;
    private boolean isLightOn;
    private final ReentrantLock isLightOntLock;
    ArrayList<Messenger> mClients;
    final Messenger mMessenger;
    private BroadcastReceiver mReceiver;
    private Intent mWhiteScreenActivityIntent;

    class IncomingHandler extends Handler {
        IncomingHandler() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case LightsService.MSG_REGISTER_CLIENT /*1*:
                    LightsService.this.mClients.add(msg.replyTo);
                case LightsService.MSG_UNREGISTER_CLIENT /*2*:
                    LightsService.this.mClients.remove(msg.replyTo);
                case LightsService.MSG_SET_INT_VALUE /*3*:
                    if (msg.arg1 == LightsService.WHITE_SCREEN_ACTIVITY_WAS_CLOSED) {
                        try {
                            LightsService.this.isLightOntLock.lock();
                            LightsService.this.isLightOn = false;
                        } catch (Exception e) {
                        } finally {
                            LightsService.this.isLightOntLock.unlock();
                        }
                    }
                default:
                    super.handleMessage(msg);
            }
        }
    }

    public LightsService() {
        this.isLightOntLock = new ReentrantLock();
        this.isLightOn = false;
        this.mClients = new ArrayList();
        this.mMessenger = new Messenger(new IncomingHandler());
    }

    private void sendMessageToUI(int intvaluetosend) {
        for (int i = this.mClients.size() - 1; i >= 0; i--) {
            try {
                ((Messenger) this.mClients.get(i)).send(Message.obtain(null, MSG_SET_INT_VALUE, intvaluetosend, 0));
            } catch (RemoteException e) {
                this.mClients.remove(i);
            }
        }
    }

    public void onCreate() {
        super.onCreate();
      //  this.mWhiteScreenActivityIntent = new Intent(this, WhiteScreenActivity.class);
      // this.mWhiteScreenActivityIntent.addFlags(268435456);
        IntentFilter filter = new IntentFilter("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        this.mReceiver = new ScreenReceiver();
        registerReceiver(this.mReceiver, filter);
    }

    public void onStart(Intent intent, int startId) {
        if (intent.getBooleanExtra(ScreenReceiver.DOUBLE_CLICK_MESSAGE, false)) {
            onDoubleClickOccured();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
   // private void onDoubleClickOccured() {
        /*
        r2 = this;
        r0 = r2.isLightOntLock;	 Catch:{ Exception -> 0x0020, all -> 0x0027 }
        r0.lock();	 Catch:{ Exception -> 0x0020, all -> 0x0027 }
        r0 = r2.isLightOn;	 Catch:{ Exception -> 0x0020, all -> 0x0027 }
        if (r0 != 0) goto L_0x0017;
    L_0x0009:
        r0 = r2.mWhiteScreenActivityIntent;	 Catch:{ Exception -> 0x0020, all -> 0x0027 }
        r2.startActivity(r0);	 Catch:{ Exception -> 0x0020, all -> 0x0027 }
        r0 = 1;
        r2.isLightOn = r0;	 Catch:{ Exception -> 0x0020, all -> 0x0027 }
    L_0x0011:
        r0 = r2.isLightOntLock;
        r0.unlock();
    L_0x0016:
        return;
    L_0x0017:
        r0 = 11;
        r2.sendMessageToUI(r0);	 Catch:{ Exception -> 0x0020, all -> 0x0027 }
        r0 = 0;
        r2.isLightOn = r0;	 Catch:{ Exception -> 0x0020, all -> 0x0027 }
        goto L_0x0011;
    L_0x0020:
        r0 = move-exception;
        r0 = r2.isLightOntLock;
        r0.unlock();
        goto L_0x0016;
    L_0x0027:
        r0 = move-exception;
        r1 = r2.isLightOntLock;
        r1.unlock();
        throw r0;
        *
        throw new UnsupportedOperationException("Method not decompiled: com.yohad.LightsService.onDoubleClickOccured():void");
    }

    public IBinder onBind(Intent intent) {
        return this.mMessenger.getBinder();
    }

    public void onDestroy() {
        super.onDestroy();
        sendMessageToUI(NEED_TO_CLOSE_WHITE_SCREEN_ACTIVITY);
        unregisterReceiver(this.mReceiver);
    }
*///}}
