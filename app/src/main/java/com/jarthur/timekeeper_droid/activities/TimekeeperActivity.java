package com.jarthur.timekeeper_droid.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.show_activities.TimesheetShow;
import com.jarthur.timekeeper_droid.activities.list_activities.ProjectsList;
import com.jarthur.timekeeper_droid.activities.list_activities.StoryCardList;
import com.jarthur.timekeeper_droid.activities.list_activities.TimesheetList;
import com.jarthur.timekeeper_droid.application.Timekeeper;

/**
 * Created by arthur on 3/30/16.
 */
public class TimekeeperActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public Timekeeper getTimekeeper(){
        return (Timekeeper)getApplicationContext();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        navigateToItem(item);
        return super.onOptionsItemSelected(item);
    }

    protected void navigateToItem(MenuItem item){
        final Intent navigationIntent = new Intent(this, activityForItem(item.getItemId()));
        startActivity(navigationIntent);
    }

    protected <T extends TimekeeperActivity> Class activityForItem(int itemId){
        switch (itemId){
            case(R.id.storyCardsMenuItem):
                return StoryCardList.class;
            case(R.id.projectsMenuItem):
                return ProjectsList.class;
            case(R.id.timesheetsMenuItem):
                return TimesheetList.class;
            case(R.id.settingsMenuItem):
                return SettingsActivity.class;
            default:
                return TimesheetShow.class;
        }
    }

    public <T extends View> T getViewWithId(int id){
        return (T)findViewById(id);
    }
}
