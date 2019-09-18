package com.kariyernet.marketim.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrdersBase {
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("month")
    @Expose
    private String month;
    @SerializedName("marketName")
    @Expose
    private String marketName;
    @SerializedName("orderName")
    @Expose
    private String orderName;
    @SerializedName("productPrice")
    @Expose
    private Double productPrice;
    @SerializedName("productState")
    @Expose
    private String productState;
    @SerializedName("productDetail")
    @Expose
    private OrdersDetail productDetail;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public OrdersDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(OrdersDetail productDetail) {
        this.productDetail = productDetail;
    }
}
