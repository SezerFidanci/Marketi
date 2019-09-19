package com.kariyernet.marketim.ui.main;

import android.content.Context;

import com.kariyernet.marketim.model.OrdersBase;

import java.util.List;

public class MainContract {


    public interface Model {
        interface OnFinishedListener {
            void onFinished(List<OrdersBase> ordersList);
            void onFailure(Throwable t);
        }
        void getOrderList(OnFinishedListener onFinishedListener);
    }

    interface View
    {
        void bindView();
        void initOnClicks();
        void setDataToRecyclerView(List<OrdersBase> orderList);
        void showLoadingDialog();
        void hideLoadingDialog();
        void showWrongData();
        Context getContext();
        void showNoInternetConnection();

    }

    interface Presenter
    {
        void setView(View view);
        void created();
        void checkLogout();
        void requestDataFromServer();

    }
}
