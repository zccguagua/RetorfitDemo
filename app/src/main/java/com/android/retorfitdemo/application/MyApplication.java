package com.android.retorfitdemo.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by zcc on 2019/7/16.
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate(); //获取context
        mContext = getApplicationContext();
    } //创建一个静态的方法，以便获取context对象

    public static Context getContext() {
        return mContext;
    }
}
