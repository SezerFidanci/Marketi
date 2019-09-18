package com.kariyernet.marketim.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public interface OnSetProgress {

        void itemChanged();
    }

    public OrdersAdapter(List<OrdersBase> list) {
        this.viewerList = list;

    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        Context ctx;
        public OrderViewHolder(View v) {
            super(v);

            ctx = v.getContext();
            v.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {

        }

        public void bindData(OrdersBase item) {


        }
    }
}
