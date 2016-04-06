package com.jarthur.timekeeper_droid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.list_activities.TimesheetList;
import com.jarthur.timekeeper_droid.activities.presenters.ButtonPresenter;
import com.jarthur.timekeeper_droid.activities.presenters.NavigateToButtonPresenter;
import com.jarthur.timekeeper_droid.application.api.UserLoginTask;

public class UserLoginActivity extends TimekeeperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        new ButtonPresenter(this, R.id.userLoginButton){

            @Override
            public void onButtonClicked() {
//                Intent navIntent = new Intent(UserLoginActivity.this ,TimesheetList.class);
                new UserLoginTask(UserLoginActivity.this).execute();
//                startActivity(navIntent);
            }
        };
    }

}
