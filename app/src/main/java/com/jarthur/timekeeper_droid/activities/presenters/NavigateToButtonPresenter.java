package com.jarthur.timekeeper_droid.activities.presenters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.jarthur.timekeeper_droid.R;

/**
 * Created by arthur on 4/2/16.
 */
public class NavigateToButtonPresenter extends ButtonPresenter {

    private Class<? extends AppCompatActivity> navigateActivity;

    public NavigateToButtonPresenter(AppCompatActivity startingActivity,
                                     Class<? extends AppCompatActivity> navigateActivity) {
        this(startingActivity, navigateActivity, R.id.fab);
    }

    public NavigateToButtonPresenter(AppCompatActivity startingAct,
                                     Class<? extends AppCompatActivity> navAct,
                                     int buttonId){
        super(startingAct, buttonId);
        this.navigateActivity = navAct;
    }

    @Override
    public void onButtonClicked() {
        Intent navigationIntent = new Intent(this.activity, navigateActivity);
        activity.startActivity(navigationIntent);
    }
}
