package com.kariyernet.marketim.ui.main;

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View mView;


    @Override
    public void setView(MainContract.View view) {
        mView = view;

    }

    @Override
    public void created() {
        this.mView.bindView();
        this.mView.initOnClicks();
    }

    @Override
    public void checkLogin() {



    }


}
