package com.iav.senamlantai.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import com.iav.senamlantai.MainActivity;
import com.iav.vlvollylearning.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finishAffinity();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                SharedPreferences sp = getSharedPreferences(Config.NAME_PREF, MODE_PRIVATE);
//                String username = sp.getString(Config.USERNAME, "");
//                // TODO jika belum masuk ke LoginActivity
//                if (username.equalsIgnoreCase("") || TextUtils.isEmpty(username)) {
//                    finishAffinity();
//                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
//                }
//                // TODO jika sudah nantinya akan masuk ke Home
//                else {
//                    finishAffinity();
//                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
////                    if (rule.contains("user")) {
////                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
////                    }
////                    else {
////                        startActivity(new Intent(getApplicationContext(), HomePetugasActivity.class));
////                    }
//
//                }
            }
        }, 2000);
    }
}
