package com.kariyernet.marketim.interfaces;

import com.kariyernet.marketim.model.OrdersBase;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface APIService {

    @GET("/")
    Call<List<OrdersBase>> getOrderList();
}
