package com.jarthur.timekeeper_droid.activities.show_activities;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;

/**
 * Created by arthur on 4/2/16.
 */
public abstract class AbstractShow extends TimekeeperActivity {


    protected void setupEditButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
