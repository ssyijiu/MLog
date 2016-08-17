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
        MLog.TAG = "ssyijiu";
        MLog.v("V","vvvvvvvvvvvvv");
        MLog.d("D","ddddddddddddd");
        MLog.i("I","iiiiiiiiiiiii");
        MLog.w("W","wwwwwwwwwwwww");
        MLog.e("E","eeeeeeeeeeeee");
        MLog.e("ssyijiu");

    }
}
