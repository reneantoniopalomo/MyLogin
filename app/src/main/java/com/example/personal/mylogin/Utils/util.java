package com.example.personal.mylogin.Utils;

import android.content.SharedPreferences;

public class util {
    public static String getUsersMailspref(SharedPreferences preferences) {
        return preferences.getString("email", "");
    }

    public static String getUserspasspref(SharedPreferences preferences){
        return preferences.getString("pass", "");
    }
}