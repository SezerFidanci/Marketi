package com.kariyernet.marketim.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kariyernet.marketim.R;
import com.kariyernet.marketim.model.OrdersBase;
import com.kariyernet.marketim.ui.launcher.Launcher;
import com.kariyernet.marketim.ui.login.Login;

import java.util.List;

public class Main extends AppCompatActivity implements MainContract.View {


    RecyclerView rvOrders;
    Button btnOrders;
    Button btnLogout;

    MainPresenter mMainPresenter;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        mContext=this;
        mMainPresenter = new MainPresenter();
        mMainPresenter.setView(this);
        mMainPresenter.created();

    }

    @Override
    public void bindView() {
        rvOrders = findViewById(R.id.rvOrders);
        btnOrders = findViewById(R.id.btnOrders);
        btnLogout = findViewById(R.id.btnLogout);
        mMainPresenter.requestDataFromServer();
    }

    @Override
    public void initOnClicks() {

        btnOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPresenter.checkLogout();
                Intent mIntent = new Intent(Main.this, Login.class);
                Main.this.startActivity(mIntent);
                Main.this.finish();
            }
        });
    }

    @Override
    public void setDataToRecyclerView(List<OrdersBase> orderList) {
        for (int i = 0; i <orderList.size() ; i++) {
            Log.i("setDataToRecyclerView", "setDataToRecyclerView: "+orderList.get(i).getMarketName());
        }
    }


}
