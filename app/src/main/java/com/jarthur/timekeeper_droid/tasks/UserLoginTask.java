package com.jarthur.timekeeper_droid.tasks;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;
import com.jarthur.timekeeper_droid.activities.list_activities.TimesheetList;
import com.jarthur.timekeeper_droid.tasks.communication.ApiResponse;
import com.jarthur.timekeeper_droid.tasks.communication.Connection;

import java.io.IOException;

/**
 * Created by arthur on 4/5/16.
 */
public class UserLoginTask extends AsyncTask<String, Integer, String> {

    private String authToken = "something went horribly wrong";
    private TimekeeperActivity activity;
    private String username;
    private String password;

    public UserLoginTask(TimekeeperActivity activity){
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String[] params) {
        try {
            String urlString = "https://paratus-timekeeper.herokuapp.com/api/user/login";
            ApiResponse apiResponse = Connection.sendPostRequestToUrlWithContent(urlString, authenticationJson());
            authToken = apiResponse.getBody();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authToken;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        TextView nameView = activity.getViewWithId(R.id.userNameField);
        TextView passView = activity.getViewWithId(R.id.userPasswordField);

        username = nameView.getText().toString();
        password = passView.getText().toString();
    }

    @Override
    protected void onPostExecute(String authorizationToken) {
        super.onPostExecute(authorizationToken);
        activity.getTimekeeper().setAuthToken(authorizationToken);
        Intent navIntent = new Intent(activity, TimesheetList.class);
        activity.startActivity(navIntent);
    }


    private String authenticationJson(){
        return "{\"credentials\":{\"username\":\"" +
                username +
                "\", \"password\":\"" +
                password + "\"}}";
    }

}
