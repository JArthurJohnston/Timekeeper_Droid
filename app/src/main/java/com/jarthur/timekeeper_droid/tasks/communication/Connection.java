package com.jarthur.timekeeper_droid.tasks.communication;

import android.support.annotation.NonNull;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by arthur on 4/6/16.
 */
public class Connection {
    
    private static HttpsURLConnection connection;

    public static ApiResponse sendPostRequestToUrlWithContent(String url, String content) throws IOException {
        connection = connectTo(url);
        byte[] payload = content.getBytes(Charset.forName("UTF-8"));
        addPostHeaders(payload);
        sendPostContent(payload);
        ApiResponse apiResponse = getResponse();
        connection.disconnect();
        return apiResponse;
    }

    @NonNull
    private static ApiResponse getResponse() throws IOException {
        int responseCode = connection.getResponseCode();
        String response = getResponseFrom();
        return new ApiResponse(responseCode, response);
    }

    private static void sendPostContent(byte[] payload) throws IOException {
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(payload);
    }

    private static void addPostHeaders(byte[] payload) throws ProtocolException {
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Content-Length", String.valueOf(payload.length));
    }

    public static ApiResponse sendGetRequestTo(String url) throws IOException {
        ApiResponse response = null;
        try {
            connection = connectTo(url);
            connection.setRequestMethod("GET");
            response = getResponse();
        } finally {
            connection.disconnect();
        }
        return response;
    }

    @NonNull
    private static String getResponseFrom() throws IOException {
        InputStream inputStream = new BufferedInputStream(connection.getInputStream());
        int currentCharacterValue;
        StringBuffer responseBuffer = new StringBuffer();
        while ((currentCharacterValue = inputStream.read()) != -1) {
            responseBuffer.append((char) currentCharacterValue);
        }
        inputStream.close();
        return responseBuffer.toString();
    }

    private static HttpsURLConnection connectTo(String url) throws IOException {
        URL loginUrl = new URL(url);
        connection = (HttpsURLConnection)loginUrl.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        return connection;
    }


}
