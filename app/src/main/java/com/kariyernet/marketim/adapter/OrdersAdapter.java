package com.kariyernet.marketim.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kariyernet.marketim.R;
import com.kariyernet.marketim.model.OrdersBase;
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
        TextView txtMonth;
        TextView txtMarketName;
        TextView txtOrderName;
        TextView txtProductPrice;
        TextView txtProductState;
        TextView txtOrderDetailsDesc;
        TextView txtOrderDetailsSummaryPrice;
        ImageView imgProductState;
        ImageView imgDetailsArrow;
        LinearLayout linProductDetails;


        String date;
        String month;
        String marketName;
        String orderName;
        String orderState;
        String productPrice;
        String summaryPrice;
        String productState;
        String orderDetail;


        boolean isDetailsVisible=false;

        public OrderViewHolder(View v) {
            super(v);

            ctx = v.getContext();
            v.setOnClickListener(this);

            txtDate=v.findViewById(R.id.txtDate);
            txtMonth=v.findViewById(R.id.txtMonth);
            txtMarketName=v.findViewById(R.id.txtMarketName);
            txtOrderName=v.findViewById(R.id.txtOrderName);
            txtProductPrice=v.findViewById(R.id.txtProductPrice);
            txtProductState=v.findViewById(R.id.txtProductState);
            txtOrderDetailsDesc=v.findViewById(R.id.txtOrderDetailsDesc);
            txtOrderDetailsSummaryPrice=v.findViewById(R.id.txtOrderDetailsSummaryPrice);
            linProductDetails=v.findViewById(R.id.linProductDetails);
            imgProductState=v.findViewById(R.id.imgProductState);
            imgDetailsArrow=v.findViewById(R.id.imgDetailsArrow);


        }


        @Override
        public void onClick(View v) {

            if(isDetailsVisible)
            {
                isDetailsVisible=false;
                linProductDetails.setVisibility(View.GONE);
                imgDetailsArrow.setImageDrawable(ctx.getResources().getDrawable(R.drawable.ic_right_arrow));
            }
            else
            {
                isDetailsVisible=true;
                linProductDetails.setVisibility(View.VISIBLE);
                imgDetailsArrow.setImageDrawable(ctx.getResources().getDrawable(R.drawable.ic_down_arrow));
            }
        }

        public void bindData(OrdersBase item) {

            date = item.getDate();
            month = item.getMonth();
            marketName = item.getMarketName();
            orderName =item.getOrderName();
            productPrice = String.valueOf(item.getProductPrice());
            summaryPrice = String.valueOf(item.getProductDetail().getSummaryPrice());
            productState = item.getProductState();
            orderDetail = item.getProductDetail().getOrderDetail();

            txtDate.setText(date);
            txtMonth.setText(month);
            txtMarketName.setText(marketName);
            txtOrderName.setText(orderName);


            if(productPrice!=null)
            {
                txtProductPrice.setText(productPrice+" TL");
            }


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
            else
            {
                txtProductState.setTextColor(ctx.getResources().getColor(R.color.colorBlack));
                imgProductState.setImageDrawable(ctx.getResources().getDrawable(R.drawable.ic_order_state_unknown));
            }

            txtProductState.setText(productState);
            txtOrderDetailsDesc.setText(orderDetail);


            if(summaryPrice!=null)
            {
                txtOrderDetailsSummaryPrice.setText(summaryPrice+" TL");
            }


        }
    }
}
