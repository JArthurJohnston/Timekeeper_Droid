package com.jarthur.timekeeper_droid.activities.list_activities;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;

public class ListActivity extends TimekeeperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        setupListAdapter();
    }

    protected int getLayout(){
        return R.layout.activity_list;
    }

    protected String[] listItems(){
        return new String[]{};
    }


    private void setupListAdapter() {
        ListAdapter listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                this.listItems());

        ListView projectsListview = (ListView)findViewById(getListViewId());
        projectsListview.setAdapter(listAdapter);
    }

    protected int getListViewId() {
        return R.id.timekeeperListView;
    }
}
