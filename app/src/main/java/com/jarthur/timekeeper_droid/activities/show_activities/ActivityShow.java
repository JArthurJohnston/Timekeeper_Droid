package com.jarthur.timekeeper_droid.activities.show_activities;

import android.support.annotation.NonNull;
import android.widget.TextView;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;
import com.jarthur.timekeeper_droid.activities.edit_activities.ActivityEdit;

public class ActivityShow extends AbstractShow {


    @Override
    protected void populateFields() {
        TextView titleView = getViewWithId(R.id.activityTitle);
        titleView.setText("Greenwood\t61");
    }

    @NonNull
    @Override
    protected Class<? extends TimekeeperActivity> getEditActivityClass() {
        return ActivityEdit.class;
    }

    @Override
    protected int getContentLayout() {
        return R.layout.content_edit_activity;
    }

}
