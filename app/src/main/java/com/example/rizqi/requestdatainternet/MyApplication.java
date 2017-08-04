package com.example.rizqi.requestdatainternet;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by rizqi on 04/08/17.
 */

public class MyApplication extends Application {

//    private static final String TAG = MyApplication.class.getSimpleName();
//    private static MyApplication appInstance = null;
//
//    public static MyApplication getAppInstance() {
//
//        return appInstance;
    //}

    @Override
    public void onCreate(){
        super.onCreate();
//        appInstance = this;
        AndroidNetworking.initialize(getApplicationContext());
    }

}
