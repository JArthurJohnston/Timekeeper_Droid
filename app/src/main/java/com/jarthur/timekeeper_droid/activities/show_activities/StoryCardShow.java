package com.jarthur.timekeeper_droid.activities.show_activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;
import com.jarthur.timekeeper_droid.activities.edit_activities.StoryCardEdit;

public class StoryCardShow extends AbstractShow {


    @Override
    protected void populateFields() {
        TextView numberView = getViewWithId(R.id.showStoryCardNumber);
        numberView.setText("4123");

        TextView titleView = getViewWithId(R.id.showStoryCardTitle);
        titleView.setText("Get the email thing working!!!");

        TextView estimateView = getViewWithId(R.id.showStoryCardTitle);
        estimateView.setText("32");

        TextView descriptionView = getViewWithId(R.id.showStoryCardTitle);
        descriptionView.setText("It gets the email working again or it gets the hose again");
    }

    @NonNull
    @Override
    protected Class<? extends TimekeeperActivity> getEditActivityClass() {
        return StoryCardEdit.class;
    }

    @Override
    protected int getContentLayout() {
        return R.layout.content_show_story_card;
    }
}
