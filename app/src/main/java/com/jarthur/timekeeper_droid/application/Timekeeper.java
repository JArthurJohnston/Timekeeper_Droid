package com.jarthur.timekeeper_droid.application;

import android.app.Application;
import android.os.AsyncTask;

/**
 * Created by arthur on 4/4/16.
 */
public class Timekeeper extends Application {
    private String authToken;


    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
