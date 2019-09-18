package com.kariyernet.marketim.ui.main;

import com.kariyernet.marketim.App;
import com.kariyernet.marketim.model.OrdersModel;
import com.kariyernet.marketim.model.OrdersBase;

import java.util.List;

public class MainPresenter implements MainContract.Presenter,MainContract.Model.OnFinishedListener{

    private MainContract.View mView;
    OrdersModel ordersModel;

    @Override
    public void setView(MainContract.View view) {
        mView = view;
        ordersModel = new OrdersModel();

    }

    @Override
    public void created() {
        this.mView.bindView();
        this.mView.initOnClicks();
    }

    @Override
    public void checkLogout() {

        App.prefsSet.putBoolean("isKeepLogin",false);
        App.prefsSet.commit();

    }

    @Override
    public void requestDataFromServer() {

        if (mView != null) {
           // mView.showProgress();
        }
        ordersModel.getOrderList(this);
    }

    @Override
    public void onFinished(List<OrdersBase> ordersList) {

        mView.setDataToRecyclerView(ordersList);
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
