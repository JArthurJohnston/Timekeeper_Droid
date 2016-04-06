package com.jarthur.timekeeper_droid.application.api;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.widget.TextView;
import android.widget.Toast;

import com.jarthur.timekeeper_droid.R;
import com.jarthur.timekeeper_droid.activities.TimekeeperActivity;
import com.jarthur.timekeeper_droid.activities.list_activities.TimesheetList;
import com.jarthur.timekeeper_droid.application.Timekeeper;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

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
            HttpsURLConnection connection = openConnectionTo(urlString);

            sendPostRequestWith(connection, authenticationJson());

            authToken = readInResponse(new BufferedInputStream(connection.getInputStream()));

            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
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

    private void sendPostRequestWith(HttpsURLConnection connection, String requestContent) throws IOException {
        byte[] payload = requestContent.getBytes(Charset.forName("UTF-8"));
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Content-Length", String.valueOf(payload.length));

        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(payload);
    }

    @NonNull
    private HttpsURLConnection openConnectionTo(String urlString) throws IOException {
        URL loginUrl = new URL(urlString);
        HttpsURLConnection connection = (HttpsURLConnection)loginUrl.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        return connection;
    }

    private String readInResponse(InputStream inputStream) throws IOException {
        int currentCharacterValue;
        StringBuffer sb = new StringBuffer();
        while ((currentCharacterValue = inputStream.read()) != -1) {
            sb.append((char) currentCharacterValue);
        }
        return sb.toString();
    }

    private String authenticationJson(){
        return "{\"credentials\":{\"username\":\"" +
                username +
                "\", \"password\":\"" +
                password + "\"}}";
    }
}
