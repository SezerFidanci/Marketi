package com.kariyernet.marketim;

import android.app.Application;
import android.content.SharedPreferences;


public class App extends Application {

    public static String BASEURL = "http://kariyertechchallenge.mockable.io/";
    public static SharedPreferences.Editor prefsSet;
    public static SharedPreferences prefsGet;
    @Override
    public void onCreate() {
        super.onCreate();


        prefsSet = getSharedPreferences("login", MODE_PRIVATE).edit();
        prefsGet = getSharedPreferences("login", MODE_PRIVATE);




    }
}
