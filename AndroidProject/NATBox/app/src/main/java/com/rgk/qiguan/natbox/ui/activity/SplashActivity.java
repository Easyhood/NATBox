package com.rgk.qiguan.natbox.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.rgk.qiguan.natbox.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                  startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                    finish();
                }
            },3000);



    }




}
