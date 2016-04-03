package com.jarthur.timekeeper_droid.activities.show_activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;
import com.jarthur.timekeeper_droid.activities.presenters.NavigateToButtonPresenter;

/**
 * Created by arthur on 4/2/16.
 */
public abstract class AbstractShow extends TimekeeperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_show);
        wireUpEditButton();
        insertContentLayout();
    }

    private void insertContentLayout() {
        RelativeLayout currentContent = getViewWithId(R.id.basicShowContent);
        ViewGroup mainParent = (ViewGroup)currentContent.getParent();
        mainParent.removeView(currentContent);

        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View content =  inflater.inflate(getContentLayout(), currentContent);
        mainParent.addView(content);

        populateFields();
    }

    private void wireUpEditButton() {
        new NavigateToButtonPresenter(this, getEditActivityClass(), R.id.fab);
    }

    protected abstract void populateFields();

    @NonNull
    protected abstract Class<? extends TimekeeperActivity> getEditActivityClass();

    protected abstract int getContentLayout();

}
