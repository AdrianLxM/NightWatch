package com.dexdrip.stephenblack.nightwatch;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class NWPreferences extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = this.getIntent().getExtras();
        if (extras == null || extras.getBoolean("start", true)) {
            //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            addPreferencesFromResource(R.xml.preferences);
        } else {
            this.finish();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        boolean start = intent.getExtras().getBoolean("start");
        if (start == false) {
            this.finish();
        }
    }

}