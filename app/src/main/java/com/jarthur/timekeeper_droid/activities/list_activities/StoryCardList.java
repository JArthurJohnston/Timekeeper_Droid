package com.jarthur.timekeeper_droid.activities.list_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.show_activities.StoryCardShow;
import com.jarthur.timekeeper_droid.activities.show_activities.TimesheetShow;

public class StoryCardList extends AbstractListActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] projects =  {
                "Drake      : Do it Best : SOW005",
                "Wilmut     : BD/Accuri  : SOW019",
                "Shovis     : BD/Accuri  : SOW019",
                "Greenwood  : BD         : SOW005",
                "Proulx     : Menlo      : SOW005",
        };

        setupProjectSpiner(projects);
    }

    @Override
    protected AdapterView.OnItemClickListener getListClickListener() {
        final Intent showCardIntent = new Intent(this, StoryCardShow.class);
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(showCardIntent);
            }
        };
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_story_card_list;
    }

    private void setupProjectSpiner(String[] projects) {
        ArrayAdapter<String> projectSpinnerAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                projects);
        Spinner projectSpinner = (Spinner)findViewById(R.id.storyCardListProjectSpinner);
        projectSpinner.setAdapter(projectSpinnerAdapter);
    }

    @Override
    protected int getListViewId() {
        return R.id.storyCardListView;
    }

    @Override
    protected String[] listItems() {
        return new String [] {
                "Drake : 172 : 16 : Fix the thing",
                "Drake : 181 : 8  : Fix the other thing",
                "Drake : 200 : 32 : Make it work",
                "Drake : 211 : 16 : Make it email stuff",
                "Drake : 234 : 8  : Make it pay for stuff",
                "Drake : 444 : 64 : Make it flexible"
        };
    }

}
