package com.kariyernet.marketim;

import android.app.Application;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kariyernet.marketim.interfaces.APIService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


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
    public static APIService getApiService()
    {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(App.BASEURL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        APIService apis = retrofit.create(APIService.class);

        return apis;
    }
}
