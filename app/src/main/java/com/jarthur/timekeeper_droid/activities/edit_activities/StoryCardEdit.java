package com.jarthur.timekeeper_droid.activities.edit_activities;

import android.support.annotation.NonNull;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;
import com.jarthur.timekeeper_droid.activities.show_activities.ProjectShow;
import com.jarthur.timekeeper_droid.activities.show_activities.StoryCardShow;

public class StoryCardEdit extends AbstractEditActivity {

    @Override
    protected int getContentLayout() {
        return R.layout.content_edit_story_card;
    }

    @NonNull
    @Override
    protected Class<? extends TimekeeperActivity> showActivityClass() {
        return StoryCardShow.class;
    }
}
