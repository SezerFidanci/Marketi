package com.kariyernet.marketim.ui.login;

import android.widget.Toast;

import com.kariyernet.marketim.ui.main.MainContract;
import com.kariyernet.marketim.utils.Constants;

public class LoginPresenter implements LoginContract.Presenter{

    private LoginContract.View mView;


    @Override
    public void setView(LoginContract.View view) {
        mView = view;

    }

    @Override
    public void created() {
        this.mView.bindView();
        this.mView.initOnClicks();
    }


    @Override
    public boolean checkLogin(String uName,String uPass) {

        if(uName.equals(Constants.USERNAME) && uPass.equals(Constants.USERPASS))
        {
            return true;
        }

        return false;

    }
}
