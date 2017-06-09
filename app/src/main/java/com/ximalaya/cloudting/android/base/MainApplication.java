package com.ximalaya.cloudting.android.base;

import android.app.Application;
import android.content.Context;

/**
 * Custom application.
 * <p>
 * Created by Chang.Xiao on 2017/6/6.
 *
 * @version 1.0
 */

public class MainApplication extends Application {

    public static Context mApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = this;
    }
}
