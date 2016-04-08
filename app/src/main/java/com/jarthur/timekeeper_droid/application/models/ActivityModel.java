package com.jarthur.timekeeper_droid.application.models;

import android.support.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by arthur on 4/6/16.
 */
public class ActivityModel extends AbstractModel {

    public ActivityModel(JSONObject activityJson){
        super(activityJson);

    }

    public int getTimesheetId(){
        return getIntUsing("timesheet_id");
    }

    public int getStoryCardId(){
        return getIntUsing("story_card_id");
    }

    public Date getStartTime() throws ParseException {
        String startTimeKey = "start_time";
        return getDateUsing(startTimeKey);
    }

    public Date getEndTime() throws ParseException {
        return getDateUsing("end_time");
    }

}
