package com.example.adminpanel;

import android.app.Application;

public class AdminPanel extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
