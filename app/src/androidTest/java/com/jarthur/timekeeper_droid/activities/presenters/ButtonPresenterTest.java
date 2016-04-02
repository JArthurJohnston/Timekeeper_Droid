package com.jarthur.timekeeper_droid.activities.presenters;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import junit.framework.TestCase;

/**
 * Created by arthur on 4/2/16.
 */
public class ButtonPresenterTest extends TestCase {

    public void testConstructedProperly(){
//        AppCompatActivity expectedActivity = new AppCompatActivity();
//
//        ButtonPresenter presenter = getEditButtonPresenter(expectedActivity);
//
//        assertSame(expectedActivity, presenter.getActivity());
    }

    @NonNull
    private ButtonPresenter getEditButtonPresenter(final AppCompatActivity expectedActivity) {
        return new ButtonPresenter(expectedActivity) {
            @Override
            public void onButtonClicked() {}
        };
    }

}