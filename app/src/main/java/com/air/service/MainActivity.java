package com.air.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    IMyAidlService mMyBinder;
    MyServiceConnection myServiceConnection = new MyServiceConnection();
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         //
        setContentView(R.layout.activity_main);

    }

    class MyServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName arg0, IBinder service) {
            Log.d("MyService123", "Service Connection Success");


            mMyBinder = IMyAidlService.Stub.asInterface(service);


            try {
                Log.d("MyService123", "" + mMyBinder.add(10));
            } catch (RemoteException e) {
                e.printStackTrace();
            }


            //mMyBinder = (MyService1.MyBinder) service;
            // mMyBinder.getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
// TODO Auto-generated method stub
            Log.d("MyService123", "Service Connection Filed");
//连接失败执行
        }

    }


    public void stop(View v) {

        Intent stopIntent = new Intent(this, MyService1.class);
        stopService(stopIntent);

    }


    public void stop2(View v) {
        unbindService(myServiceConnection);


    }


    public void start(View v) {
         Intent startIntent = new Intent(this, MyService1.class);
        startService(startIntent);


       //Intent intent = new Intent(this, MyService1.class);
       // bindService(intent, myServiceConnection, Context.BIND_AUTO_CREATE);


    }

    public void bind(View v) {
        Intent intent = new Intent(this, MyService1.class);
        bindService(intent, myServiceConnection, Context.BIND_AUTO_CREATE);
    }
}
