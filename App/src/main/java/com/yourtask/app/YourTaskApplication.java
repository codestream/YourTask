package com.yourtask.app;

import android.app.Application;

public class YourTaskApplication extends Application {

    private volatile static YourTaskApplication mApplication;
    private static final Object LOCK = new Object();
    private Object[] modules;

    public YourTaskApplication(){

    }

    public static YourTaskApplication instance(){
        if(mApplication == null){
            synchronized (LOCK){
                if(mApplication == null){
                    mApplication = new YourTaskApplication();
                }
            }
        }

        return mApplication;
    }

    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects (excluding content providers) have been created.
     * Implementations should be as quick as possible (for example using
     * lazy initialization of state) since the time spent in this function
     * directly impacts the performance of starting the first activity,
     * service, or receiver in a process.
     * If you override this method, be sure to call super.onCreate().
     */
    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        modules = new Object[]{

        };
    }
}
