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
        MLog.v("V","---------------");
        MLog.d("---------------");
        MLog.TAG = "lxm";
        MLog.i("I","---------------");
        MLog.w("W","---------------");
        MLog.e("E","---------------");
        MLog.e("ssyijiu");

    }
}
