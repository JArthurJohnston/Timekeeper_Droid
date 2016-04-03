package com.jarthur.timekeeper_droid.activities.show_activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.jarthur.timekeeper_droid.activities.list_activities.AbstractListActivity;

public class TimesheetShow extends AbstractListActivity {

    @NonNull
    protected AdapterView.OnItemClickListener getListClickListener() {
        final Intent showActivityIntent = new Intent(this, ActivityShow.class);
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(TimesheetShow.this, selected, Toast.LENGTH_SHORT).show();
                startActivity(showActivityIntent);
            }
        };
    }

    @Override
    protected String[] listItems() {
        return new String[]{
                "Greenwood\t61\t09:00am - 10:00am",
                "Greenwood\tSTU\t10:00am - 10:15am",
                "Greenwood\t61\t10:15am - 12:00pm",
                "Greenwood\t61\t01:00pm - 5:30pm",
        };
    }

}
