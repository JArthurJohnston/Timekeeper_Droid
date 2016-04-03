package com.jarthur.timekeeper_droid.activities.show_activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;
import com.jarthur.timekeeper_droid.activities.edit_activities.ProjectEdit;
import com.jarthur.timekeeper_droid.activities.presenters.ListPresenter;

public class ProjectShow extends AbstractShow {

    @Override
    protected void populateFields() {
        TextView nameField = getViewWithId(R.id.projectNameTextView);
        TextView clientField = getViewWithId(R.id.projectClientTextView);

        nameField.setText("Mouse");
        clientField.setText("Mickey");

        String[] storyCards = {
            "001 : Build the house : 32",
            "002 : Put the mouse in the house : 16",
            "003 : Profit : 2",
            "STU : Stand Up: --",
            "KIK : Kick Off : --",
            "PLG : Planning Game : --",
        };

        new ListPresenter(this, storyCards, R.id.projectShowStoryCardListView){

            @Override
            public void onListItemClicked() {
                Intent navToProjectEdit = new Intent(ProjectShow.this, ProjectEdit.class);
                ProjectShow.this.startActivity(navToProjectEdit);
            }
        };
    }

    @NonNull
    protected Class<? extends TimekeeperActivity> getEditActivityClass() {
        return ProjectEdit.class;
    }

    @Override
    protected int getContentLayout() {
        return R.layout.content_project_show;
    }


}
