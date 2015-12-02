package com.dexdrip.stephenblack.nightwatch;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.widget.TextView;

public class ChargerActivity extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = this.getIntent().getExtras();
        if (extras == null || extras.getBoolean("start", true)) {
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            setContentView(R.layout.activity_charger);
            final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
            stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
                @Override
                public void onLayoutInflated(WatchViewStub stub) {
                    mTextView = (TextView) stub.findViewById(R.id.text);
                }
            });
            setAmbientEnabled();

            //some more tests:
            getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        } else {
            Log.d("Adrian", "finish onCreate");
            this.finish();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.d("Adrian", "onNewIntent");
        super.onNewIntent(intent);
        boolean start = intent.getExtras().getBoolean("start", true);
        if (start == false) {
            Log.d("Adrian", "finish onNewIntent");
            this.finish();
        }
    }
}
