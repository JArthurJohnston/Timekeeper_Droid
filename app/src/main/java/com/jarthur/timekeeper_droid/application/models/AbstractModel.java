package com.jarthur.timekeeper_droid.application.models;

import android.support.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by arthur on 4/7/16.
 */
public class AbstractModel {
    protected JSONObject modelJson;

    public AbstractModel(JSONObject activityJson) {
        this.modelJson = activityJson;
    }

    protected int getIntUsing(String idString) {
        int id = -1;
        try {
            id = modelJson.getInt(idString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Nullable
    protected Date getDateUsing(String startTimeKey) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        try {
            String timeString = modelJson.getString(startTimeKey);
            return simpleDateFormat.parse(timeString);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getId(){
        String idString = "id";
        return getIntUsing(idString);
    }
}
