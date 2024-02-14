package com.example.internetcheck;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btnclick;
    TextView tvresult;


    long backpress;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvresult=findViewById(R.id.tvresult);
        btnclick=findViewById(R.id.btnclick);

       ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
       NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

       if (networkInfo!=null && networkInfo.isConnected()){
           Toast.makeText(this, "Internet is connected", Toast.LENGTH_SHORT).show();
       }else {
           Toast.makeText(this, "please check internet connection", Toast.LENGTH_SHORT).show();
       }





    }

    @Override
    public void onBackPressed() {

        if (backpress+2000>System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }else {
            Toast.makeText(this, "press again to exit app", Toast.LENGTH_SHORT).show();
        }

        backpress =System.currentTimeMillis();
    }
}