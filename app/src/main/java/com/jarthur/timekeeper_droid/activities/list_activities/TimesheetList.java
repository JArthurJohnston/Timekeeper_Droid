package com.jarthur.timekeeper_droid.activities.list_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.show_activities.TimesheetShow;

public class TimesheetList extends ListActivity {


    @Override
    protected AdapterView.OnItemClickListener getListClickListener() {
        final Intent showTimesheetIntent = new Intent(this, TimesheetShow.class);
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(showTimesheetIntent);
            }
        };
    }

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
