package com.jarthur.timekeeper_droid.activities.presenters.save;

import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;
import com.jarthur.timekeeper_droid.activities.presenters.ButtonPresenter;
import com.jarthur.timekeeper_droid.R;

/**
 * Created by arthur on 4/3/16.
 */
public abstract class AbstractSaveModelPresenter {

    private TimekeeperActivity activity;

    public AbstractSaveModelPresenter(TimekeeperActivity activity){
        this.activity = activity;
        wireUpSaveButton(activity);
    }

    private void wireUpSaveButton(final TimekeeperActivity activity) {
        new ButtonPresenter(activity, R.id.saveEditButton){

            @Override
            public void onButtonClicked() {
                AbstractSaveModelPresenter.this.onSaveButtonClicked();
            }
        };
    }

    public abstract void onSaveButtonClicked();
}
