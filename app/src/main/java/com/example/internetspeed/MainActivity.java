package com.example.internetspeed;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.btn);
        tv1=findViewById(R.id.textView);
        tv2=findViewById(R.id.textView2);
        bt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
                NetworkCapabilities nc = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                int downSpeed = nc.getLinkDownstreamBandwidthKbps()/1000;
                int upSpeed = nc.getLinkUpstreamBandwidthKbps()/1000;
                tv1.setText("Downspeed"+String.valueOf(downSpeed)+"Mbps");
                tv2.setText("Upspeed"+String.valueOf(upSpeed)+"Mbps");

            }
        });

    }
}