package com.jarthur.timekeeper_droid.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.list_activities.MainActivity;
import com.jarthur.timekeeper_droid.activities.list_activities.ProjectsList;
import com.jarthur.timekeeper_droid.activities.list_activities.StoryCardList;
import com.jarthur.timekeeper_droid.activities.list_activities.TimesheetList;

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        navigateToItem(item);
        return super.onOptionsItemSelected(item);
    }

    protected void navigateToItem(MenuItem item){
        final Intent navigationIntent = new Intent(this, activityForItem(item.getItemId()));
        startActivity(navigationIntent);
    }

    protected <T extends AppCompatActivity> Class activityForItem(int itemId){
        switch (itemId){
        case(R.id.storyCardsMenuItem):
            return StoryCardList.class;
            case(R.id.projectsMenuItem):
                return ProjectsList.class;
            case(R.id.timesheetsMenuItem):
                return TimesheetList.class;
        default:
            return MainActivity.class;
        }
    }
}
