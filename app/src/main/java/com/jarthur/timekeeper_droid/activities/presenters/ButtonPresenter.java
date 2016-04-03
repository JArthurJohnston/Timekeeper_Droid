package com.jarthur.timekeeper_droid.activities.presenters;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jarthur.timekeeper_droid.R;

/**
 * Created by arthur on 4/2/16.
 */
public abstract class ButtonPresenter {

    protected final AppCompatActivity activity;
    private int buttonId;

    public ButtonPresenter(AppCompatActivity activity){
        this(activity, R.id.fab);
    }

    public ButtonPresenter(AppCompatActivity activity, int buttonId){
        this.activity = activity;
        this.buttonId = buttonId;
        setupButtonClickListener();
    }

    public AppCompatActivity getActivity() {
        return activity;
    }

    private void setupButtonClickListener(){
        activity.findViewById(buttonId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonPresenter.this.onButtonClicked();
            }
        });
    }

    public abstract void onButtonClicked();
}
