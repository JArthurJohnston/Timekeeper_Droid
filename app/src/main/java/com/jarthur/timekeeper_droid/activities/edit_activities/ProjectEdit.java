package com.jarthur.timekeeper_droid.activities.edit_activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;
import com.jarthur.timekeeper_droid.activities.list_activities.ProjectsList;
import com.jarthur.timekeeper_droid.activities.presenters.NavigateToButtonPresenter;
import com.jarthur.timekeeper_droid.activities.show_activities.ProjectShow;

public class ProjectEdit extends TimekeeperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_project);
        wireUpSaveAndCancelButtons();
    }

    private void wireUpSaveAndCancelButtons() {
        new NavigateToButtonPresenter(this, ProjectShow.class, R.id.cancelEditButton);
        new NavigateToButtonPresenter(this, ProjectShow.class, R.id.saveEditButton);
    }


}
