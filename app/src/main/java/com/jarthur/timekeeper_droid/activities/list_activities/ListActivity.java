package com.jarthur.timekeeper_droid.activities.list_activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;

public abstract class ListActivity extends TimekeeperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        setupListAdapter();
        setListClickBehavior();
    }

    protected int getContentLayout(){
        return R.layout.activity_basic_list;
    }

    protected abstract String[] listItems();


    private void setupListAdapter() {
        ListAdapter listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                this.listItems());

        getListView().setAdapter(listAdapter);
    }

    private void setListClickBehavior(){
        getListView().setOnItemClickListener(this.getListClickListener());
    }

    protected AdapterView.OnItemClickListener getListClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        };
    }

    protected ListView getListView() {
        return (ListView)findViewById(getListViewId());
    }

    protected int getListViewId() {
        return R.id.basicListView;
    }
}
