package com.kiwi.fluttercrashlytics;

import android.app.Activity;
import android.os.Bundle;
import io.fabric.sdk.android.Fabric;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;

public class CrashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        super.onCreate(savedInstanceState);
        if (!BuildConfig.DEBUG) {
            Fabric.with(this, new Crashlytics());
            throw (FlutterException) getIntent().getSerializableExtra("exception");
        } else {
            final CrashlyticsCore core = Crashlytics.getInstance().core;
            core.crash();
        }
    }
}
