package com.jarthur.timekeeper_droid.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.list_activities.TimesheetList;
import com.jarthur.timekeeper_droid.activities.presenters.NavigateToButtonPresenter;

public class UserLoginActivity extends TimekeeperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        new NavigateToButtonPresenter(this, TimesheetList.class, R.id.userLoginButton);

    }

}
