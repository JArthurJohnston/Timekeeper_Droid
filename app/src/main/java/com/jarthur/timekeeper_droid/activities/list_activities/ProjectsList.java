package com.jarthur.timekeeper_droid.activities.list_activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.jarthur.timekeeper_droid.R;

public class ProjectsList extends ListActivity {

    private String[] projects =  {
            "Drake      : Do it Best : SOW005",
            "Wilmut     : BD/Accuri  : SOW019",
            "Shovis     : BD/Accuri  : SOW019",
            "Greenwood  : BD         : SOW005",
            "Proulx     : Menlo      : SOW005",
    };

    @Override
    protected String[] listItems() {
        return this.projects;
    }
}
