package com.jarthur.timekeeper_droid.activities.presenters;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;

import java.util.Objects;

/**
 * Created by arthur on 4/3/16.
 */
public abstract class ListPresenter {

    private TimekeeperActivity activity;
    private Object[] listItems;
    private int listViewId;

    public ListPresenter(TimekeeperActivity activity, Object[] listItems, int ListViewId){
        this.activity = activity;
        this.listItems = listItems;
        listViewId = ListViewId;

        setupListAdapter();
        getListView().setOnItemClickListener(getListClickListener());
    }

    private ListView getListView(){
        return activity.getViewWithId(this.listViewId);
    }


    private void setupListAdapter() {
        ListAdapter listAdapter = new ArrayAdapter<>(
                this.activity,
                android.R.layout.simple_expandable_list_item_1,
                listItems);
        getListView().setAdapter(listAdapter);
    }

    protected AdapterView.OnItemClickListener getListClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onListItemClicked();
            }
        };
    }

    public abstract void onListItemClicked();
}
