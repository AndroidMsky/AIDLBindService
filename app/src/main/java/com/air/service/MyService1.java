package com.air.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by wuduogen838 on 17/6/27.
 *
 * stopSelf(int startId)：
 在其参数startId跟最后启动该service时生成的ID相等时才会执行停止服务。

 stopSelf()：直接停止服务。
 */

public class MyService1 extends Service {

    public static final String TAG = "MyService123";
    private MyBinder mBinder = new MyBinder();

    class MyBinder extends IMyAidlService.Stub {


        @Override
        public void play(int i) throws RemoteException {

        }

        @Override
        public int add(int i) throws RemoteException {

            return ++i;
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() executed flag:"+flags+"startid:"+startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate() executed");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() executed");
    }
}
