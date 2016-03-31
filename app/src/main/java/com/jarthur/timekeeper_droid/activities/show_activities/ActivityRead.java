package com.jarthur.timekeeper_droid.activities.show_activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;

public class ActivityRead extends TimekeeperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_read);

        TextView titleView = (TextView)findViewById(R.id.activityTitle);
        titleView.setText("Greenwood\t61");
        TextView actStart = (TextView)findViewById(R.id.activityStart);
        actStart.setText("Start:\t10:00am");
        TextView actEnd = (TextView)findViewById(R.id.activityEnd);
        actEnd.setText("End:\t10:45am");

    }

}
