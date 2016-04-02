package com.jarthur.timekeeper_droid.activities.show_activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;
import com.jarthur.timekeeper_droid.activities.edit_activities.ProjectEdit;
import com.jarthur.timekeeper_droid.activities.presenters.NavigateToButtonPresenter;

public class ProjectShow extends AbstractShow {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_show);
        new NavigateToButtonPresenter(this, ProjectEdit.class);
    }


}
