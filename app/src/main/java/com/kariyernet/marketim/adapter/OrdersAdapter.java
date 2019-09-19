package com.kariyernet.marketim.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kariyernet.marketim.R;
import com.kariyernet.marketim.model.OrdersBase;

import java.util.ArrayList;
import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrderViewHolder> {
    private List<OrdersBase> viewerList;
    Context ctx;

    @Override
    public OrdersAdapter.OrderViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflatedView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_orders, viewGroup, false);


        ctx = viewGroup.getContext();
        return new OrdersAdapter.OrderViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(final OrdersAdapter.OrderViewHolder holder, final int i) {
        OrdersBase item = viewerList.get(i);
        holder.bindData(item);

    }

    @Override
    public int getItemCount() {
        return viewerList.size();
    }



    public OrdersAdapter(List<OrdersBase> list) {
        this.viewerList = list;

    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        Context ctx;
        TextView txtDate;
        TextView txtMounth;
        TextView txtMarketName;
        TextView txtOrderName;
        TextView txtProductPrice;
        TextView txtProductState;
        TextView txtOrderDetailsDesc;
        TextView txtOrderDetailsSummaryPrice;
        ImageView imgProductState;
        LinearLayout linProductDetails;
        String orderState;
        boolean isDetailsVisible=false;

        public OrderViewHolder(View v) {
            super(v);

            ctx = v.getContext();
            v.setOnClickListener(this);

            txtDate=v.findViewById(R.id.txtDate);
            txtMounth=v.findViewById(R.id.txtMounth);
            txtMarketName=v.findViewById(R.id.txtMarketName);
            txtOrderName=v.findViewById(R.id.txtOrderName);
            txtProductPrice=v.findViewById(R.id.txtProductPrice);
            txtProductState=v.findViewById(R.id.txtProductState);
            txtOrderDetailsDesc=v.findViewById(R.id.txtOrderDetailsDesc);
            txtOrderDetailsSummaryPrice=v.findViewById(R.id.txtOrderDetailsSummaryPrice);
            linProductDetails=v.findViewById(R.id.linProductDetails);
            imgProductState=v.findViewById(R.id.imgProductState);


        }


        @Override
        public void onClick(View v) {

            if(isDetailsVisible)
            {
                isDetailsVisible=false;
                linProductDetails.setVisibility(View.GONE);
            }
            else
            {
                isDetailsVisible=true;
                linProductDetails.setVisibility(View.VISIBLE);
            }
        }

        public void bindData(OrdersBase item) {

            txtDate.setText(item.getDate());
            txtMounth.setText(item.getMonth());
            txtMarketName.setText(item.getMarketName());
            txtOrderName.setText(item.getOrderName());
            txtProductPrice.setText(String.valueOf(item.getProductPrice())+" TL");
            

            orderState = item.getProductState();
            if(orderState.equals("Yolda"))
            {
                txtProductState.setTextColor(ctx.getResources().getColor(R.color.colorOrderInShipping));
                imgProductState.setImageDrawable(ctx.getResources().getDrawable(R.drawable.ic_order_state_inshipping));
            }
            else if(orderState.equals("Hazırlanıyor"))
            {
                txtProductState.setTextColor(ctx.getResources().getColor(R.color.colorOrderPrepare));
                imgProductState.setImageDrawable(ctx.getResources().getDrawable(R.drawable.ic_order_state_prepare));
            }
            else if(orderState.equals("Onay Bekliyor"))
            {
                txtProductState.setTextColor(ctx.getResources().getColor(R.color.colorOrderApproval));
                imgProductState.setImageDrawable(ctx.getResources().getDrawable(R.drawable.ic_order_state_approval));
            }

            txtProductState.setText(item.getProductState());

            txtOrderDetailsDesc.setText(item.getProductDetail().getOrderDetail());
            txtOrderDetailsSummaryPrice.setText(String.valueOf(item.getProductDetail().getSummaryPrice())+" TL");

        }
    }
}
