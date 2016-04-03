package com.jarthur.timekeeper_droid.activities.edit_activities;

import android.support.annotation.NonNull;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;
import com.jarthur.timekeeper_droid.activities.show_activities.ProjectShow;

public class ProjectEdit extends AbstractEditActivity {

    @Override
    protected int getContentLayout() {
        return R.layout.content_edit_project;
    }

    @NonNull
    @Override
    protected Class<? extends TimekeeperActivity> showActivityClass() {
        return ProjectShow.class;
    }
}
