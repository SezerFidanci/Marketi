package com.kariyernet.marketim.ui.login;


public class LoginContract {


    interface View
    {
        void bindView();
        void initOnClicks();

    }

    interface Presenter
    {
        void setView(LoginContract.View view);
        void created();
        boolean checkLogin(String uName,String uPass);

    }
}
