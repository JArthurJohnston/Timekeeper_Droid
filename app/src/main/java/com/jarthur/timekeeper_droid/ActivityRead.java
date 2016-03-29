package com.jarthur.timekeeper_droid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ActivityRead extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_read);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView titleView = (TextView)findViewById(R.id.activityTitle);
        titleView.setText("Greenwood\t61");
        TextView actStart = (TextView)findViewById(R.id.activityStart);
        actStart.setText("Start:\t10:00am");
        TextView actEnd = (TextView)findViewById(R.id.activityEnd);
        actEnd.setText("End:\t10:45am");

    }

}
