package com.jarthur.timekeeper_droid.application.models;

import android.support.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthur on 3/28/16.
 */
public class TimesheetModel extends AbstractModel{

    public TimesheetModel(JSONObject timesheetJSON) {
        super(timesheetJSON);
    }

    public int getUserId(){
        return getIntUsing("user_id");
    }

    public List<ActivityModel> getActivities(){
        try {
            JSONArray activities = modelJson.getJSONArray("activities");
            List<ActivityModel> activitiesList = getActivityModelsFromJSONArray(activities);
            return  activitiesList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

//    @NonNull
//    private <T extends AbstractModel> List getModelsFromJSONArray(JSONArray activities) throws JSONException {
//        ArrayList<T> activityModels = new ArrayList<>();
//        for (int i = 0; i < activities.length(); i++) {
//            activityModels.add((T)new AbstractModel(activities.getJSONObject(i)));
//        }
//        return activityModels;
//    }

    @NonNull
    private List<ActivityModel> getActivityModelsFromJSONArray(JSONArray activities) throws JSONException {
        ArrayList<ActivityModel> activityModels = new ArrayList<>();
        for (int i = 0; i < activities.length(); i++) {
            activityModels.add(new ActivityModel(activities.getJSONObject(i)));
        }
        return activityModels;
    }


}
