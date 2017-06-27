package com.air.service;

import android.app.Application;
import android.util.Log;

/**
 * Created by wuduogen838 on 17/6/27.
 */

public class A extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService123","create");
    }
}
