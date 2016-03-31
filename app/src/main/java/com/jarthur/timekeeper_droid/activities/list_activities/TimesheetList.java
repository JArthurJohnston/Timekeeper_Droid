package com.jarthur.timekeeper_droid.activities.list_activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.jarthur.timekeeper_droid.R;

public class TimesheetList extends ListActivity {



    @Override
    protected String[] listItems() {
        return new String [] {
                "Monday March 22 to Friday April 1",
                "Monday March 14 to Friday March 18",
                "Monday March 7 to Friday March 11",
                "Monday February 29 to Friday March 4",
        };
    }

}
