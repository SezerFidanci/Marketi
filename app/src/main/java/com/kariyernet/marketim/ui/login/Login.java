package com.kariyernet.marketim.ui.login;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.kariyernet.marketim.App;
import com.kariyernet.marketim.R;

public class Login extends AppCompatActivity implements LoginContract.View{

    Button btnLogin;
    EditText edtUsername;
    EditText edtPassword;
    Switch swKeepLogin;
    boolean isKeepLogin=false;
    LoginPresenter mLoginPresenter;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.act_login);
        mContext=this;
        mLoginPresenter = new LoginPresenter();
        mLoginPresenter.setView(this);
        mLoginPresenter.created();
    }

    @Override
    public void bindView() {
        btnLogin = findViewById(R.id.btnLogin);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        swKeepLogin = findViewById(R.id.swKeepLogin);

    }

    @Override
    public void initOnClicks() {

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uName = edtUsername.getText().toString().trim();
                String uPass = edtPassword.getText().toString().trim();
                boolean loginCheck = mLoginPresenter.checkLogin(uName,uPass);
                if(loginCheck)
                {

                    Toast.makeText(mContext,"true",Toast.LENGTH_SHORT).show();
                    App.prefsSet.putBoolean("isKeepLogin",isKeepLogin);
                    App.prefsSet.commit();
                }
                else
                {
                    Toast.makeText(mContext,"false",Toast.LENGTH_SHORT).show();
                }
            }
        });

        swKeepLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                   isKeepLogin=true;
                } else {
                    isKeepLogin=false;
                }
            }
        });

    }


}
