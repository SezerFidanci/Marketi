package com.kariyernet.marketim.ui.main;

public class MainContract {

    interface View
    {
        void bindView();
        void initOnClicks();
        void setDate(String date);


    }

    interface Presenter
    {
        void setView(View view);
        void created();
        void checkLogin();

    }
}
