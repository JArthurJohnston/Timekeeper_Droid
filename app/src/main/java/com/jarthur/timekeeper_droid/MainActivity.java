package com.jarthur.timekeeper_droid;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.jarthur.timekeeper_droid.core.DataProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListAdapter activitiesAdaptor = getStringArrayAdapter();
        setupListView(activitiesAdaptor);
    }

    private ListView setupListView(ListAdapter activitiesAdaptor) {
        ListView activityList = (ListView) findViewById(R.id.timesheetActivityList);
        activityList.setAdapter(activitiesAdaptor);
        activityList.setOnItemClickListener(getListClickListener());
        return activityList;
    }

    @NonNull
    private ArrayAdapter<String> getStringArrayAdapter() {
        return new ArrayAdapter<String>(
                this,
                R.layout.timesheet_activity_list_item,
                R.id.activityItem,
                this.activitiesList());
    }

    @NonNull
    private AdapterView.OnItemClickListener getListClickListener() {
        final Intent showActivityIntent = new Intent(this, ActivityRead.class);
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(MainActivity.this, selected, Toast.LENGTH_LONG).show();
                startActivity(showActivityIntent);
            }
        };
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
