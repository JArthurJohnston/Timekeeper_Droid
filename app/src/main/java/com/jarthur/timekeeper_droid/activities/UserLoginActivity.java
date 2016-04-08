package com.jarthur.timekeeper_droid.activities;

import android.os.Bundle;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.presenters.ButtonPresenter;
import com.jarthur.timekeeper_droid.tasks.UserLoginTask;

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
