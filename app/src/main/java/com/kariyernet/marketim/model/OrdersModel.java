package com.kariyernet.marketim.model;

import com.kariyernet.marketim.App;
import com.kariyernet.marketim.ui.main.MainContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrdersModel implements MainContract.Model {

    /*
    * Sipariş listesi, daha önce APIService interface'i içerisinde tanımlanan getOrderList() metodundan alınacak gelen data,
    * OrderBase modeline ve alt model olan OrderDetails modeline aktarılır.
    * */
    @Override
    public void getOrderList(final OnFinishedListener onFinishedListener) {
        Call<List<OrdersBase>> callLogout =  App.getApiService().getOrderList();
        callLogout.enqueue(new Callback<List<OrdersBase>>() {
            @Override
            public void onResponse(Call<List<OrdersBase>> callLogout, Response<List<OrdersBase>> response) {
                onFinishedListener.onFinished(response.body());
            }
            @Override
            public void onFailure(Call<List<OrdersBase>> callLogout, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
