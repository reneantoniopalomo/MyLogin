package com.example.personal.mylogin.Splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.personal.mylogin.Activities.LoginActivity;
import com.example.personal.mylogin.Activities.MainActivity;
import com.example.personal.mylogin.Utils.util;

public class SplashActivity extends AppCompatActivity {
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs=getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        Intent intentlogin=new Intent(this, LoginActivity.class);
        Intent intentMain=new Intent(this, MainActivity.class);
       if(!TextUtils.isEmpty(util.getUsersMailspref(prefs))&& !TextUtils.isEmpty(util.getUserspasspref(prefs))){
           startActivity(intentMain);
       }else{
           startActivity(intentlogin);
       }
        finish();
    }





    }



