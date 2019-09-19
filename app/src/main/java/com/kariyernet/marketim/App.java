package com.kariyernet.marketim;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kariyernet.marketim.interfaces.APIService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class App extends Application {

    public static String BASEURL = "http://kariyertechchallenge.mockable.io";  // Verileri aldığımız servis URL'i
    public static SharedPreferences.Editor prefsSet; // Kullanıcı session bilgilerinin tutulduğu SharedPrefences nesnesi
    public static SharedPreferences prefsGet;
    @Override
    public void onCreate() {
        super.onCreate();
        prefsSet = getSharedPreferences("login", MODE_PRIVATE).edit();  // login isimli değişkende login işlemlerinin initialize edilmesi
        prefsGet = getSharedPreferences("login", MODE_PRIVATE);

    }
    public static APIService getApiService() // Retrofit
    {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(App.BASEURL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        APIService apis = retrofit.create(APIService.class);

        return apis;
    }

    public static boolean isNetworkAvailable(Context context) // Cihaz internet bağlantısı kontrolü
    {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();

    }
}
