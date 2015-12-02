package com.dexdrip.stephenblack.nightwatch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by adrian on 02/12/15.
 */
public class PowerStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_POWER_CONNECTED)) {
            startStopActivity(true,ChargerActivity.class,context);
        } else if (action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
            startStopActivity(false, ChargerActivity.class, context);
        }
    }

    private void startStopActivity(boolean start, Class activityClass, Context context){
        Intent intent = new Intent(context, activityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("start", start);
        context.startActivity(intent);
    }
}
