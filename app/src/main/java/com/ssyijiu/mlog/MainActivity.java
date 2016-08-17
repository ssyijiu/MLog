package com.ssyijiu.mlog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ssyijiu.library.MLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MLog.setLogLev(MLog.LogLev.D);
        MLog.v("---------------");
        MLog.d("---------------");
        MLog.TAG = "ssyijiu";
        MLog.i("I","---------------");
        MLog.w("W","---------------");
        MLog.e("E","---------------");
        MLog.e("ssyijiu");

    }
}
