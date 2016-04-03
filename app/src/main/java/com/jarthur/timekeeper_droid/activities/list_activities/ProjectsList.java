package com.jarthur.timekeeper_droid.activities.list_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.jarthur.timekeeper_droid.activities.show_activities.ProjectShow;

public class ProjectsList extends AbstractListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected AdapterView.OnItemClickListener getListClickListener() {
        final Intent navToProject = new Intent(this, ProjectShow.class);
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(navToProject);
            }
        };
    }

    @Override
    protected String[] listItems() {
        return  new String[] {
                "Drake      : Do it Best : SOW005",
                "Wilmut     : BD/Accuri  : SOW019",
                "Shovis     : BD/Accuri  : SOW019",
                "Greenwood  : BD         : SOW005",
                "Proulx     : Menlo      : SOW005",
        };
    }
}
