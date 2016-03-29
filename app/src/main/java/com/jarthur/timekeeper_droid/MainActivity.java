package com.jarthur.timekeeper_droid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.jarthur.timekeeper_droid.core.DataProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListAdapter activitiesAdaptor = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                this.activitiesList());
        ListView activitiesList = (ListView) findViewById(R.id.timesheetActivityList);
        activitiesList.setAdapter(activitiesAdaptor);
    }

    private String[] activitiesList() {
        return new String[]{
                "Greenwood\t61\t09:00am - 10:00am",
                "Greenwood\tSTU\t10:00am - 10:15am",
                "Greenwood\t61\t10:15am - 12:00pm",
                "Greenwood\t61\t01:00pm - 5:30pm",
        };
    }
}
