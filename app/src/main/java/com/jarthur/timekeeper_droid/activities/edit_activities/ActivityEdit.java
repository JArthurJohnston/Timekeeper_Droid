package com.jarthur.timekeeper_droid.activities.edit_activities;

import android.support.annotation.NonNull;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;
import com.jarthur.timekeeper_droid.activities.show_activities.ActivityShow;

/**
 * Created by arthur on 4/2/16.
 */
public class ActivityEdit extends AbstractEditActivity {
    @Override
    protected int getContentLayout() {
        return R.layout.content_edit_activity;
    }

    @NonNull
    @Override
    protected Class<? extends TimekeeperActivity> showActivityClass() {
        return ActivityShow.class;
    }
}
