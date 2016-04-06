package com.jarthur.timekeeper_droid.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.jarthur.timekeeper_droid.R;

public class SettingsActivity extends TimekeeperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView authView = getViewWithId(R.id.authTokenField);

        String authToken = getTimekeeper().getAuthToken();
        if(authToken == null){
            authView.setText("Login Required");
        } else {
            authView.setText(authToken);
        }
    }


}
