package com.jarthur.timekeeper_droid.activities.edit_activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;
import com.jarthur.timekeeper_droid.activities.presenters.NavigateToButtonPresenter;
import com.jarthur.timekeeper_droid.activities.show_activities.ProjectShow;

/**
 * Created by arthur on 4/2/16.
 */
public abstract class AbstractEditActivity extends TimekeeperActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_edit);
        insertContentLayout();
        wireUpSaveAndCancelButtons();
    }

    private void insertContentLayout() {

        RelativeLayout contentParent = (RelativeLayout)findViewById(R.id.basicEditContent);
        ViewGroup mainParent = (ViewGroup)contentParent.getParent();
        mainParent.removeView(contentParent);
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View content =  inflater.inflate(getContentLayout(), contentParent);
        mainParent.addView(content);
    }

    private void wireUpSaveAndCancelButtons() {
        new NavigateToButtonPresenter(this, showActivityClass(), R.id.cancelEditButton);
        new NavigateToButtonPresenter(this, showActivityClass(), R.id.saveEditButton);
    }

    protected abstract int getContentLayout();

    @NonNull
    protected abstract Class<? extends TimekeeperActivity> showActivityClass();
}
