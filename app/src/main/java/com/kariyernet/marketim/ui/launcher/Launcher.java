package com.kariyernet.marketim.ui.launcher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kariyernet.marketim.App;
import com.kariyernet.marketim.R;
import com.kariyernet.marketim.ui.login.Login;
import com.kariyernet.marketim.ui.main.Main;



public class Launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_launcher);

        boolean isLogin = App.prefsGet.getBoolean("isKeepLogin", false);
        Intent redIntent=null;
        if(isLogin)
        {
            redIntent = new Intent(Launcher.this, Main.class);
        }
        else
        {
            redIntent = new Intent(Launcher.this, Login.class);
        }
        Launcher.this.startActivity(redIntent);
        Launcher.this.finish();
    }
}
