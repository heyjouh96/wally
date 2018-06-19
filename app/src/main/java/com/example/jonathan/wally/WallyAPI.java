package com.example.jonathan.wally;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by lab4 on 18/06/2018.
 */

public class WallyAPI {

    public static String getWallyRequest() throws  IOException  {
        OkHttpClient client = new OkHttpClient();
        String url = "https://testwally-wickedjhow.c9users.io/rest/index.php/wallyAPI/wally/";

        Request.Builder builder = new Request.Builder();
        builder.url(url);

        MediaType mediaType =
                MediaType.parse("application/json; charset=utf-8");
        //RequestBody body = RequestBody.create(mediaType, json);
        builder.get();

        Request request = builder.build();

        Response response = client.newCall(request).execute();

        String wallyResponse = response.body().string();

        return wallyResponse;
    }
//
//    public static String getWallyRequest() throws  JSONException {
//        String responseBody = request("https://testwally-wickedjhow.c9users.io/rest/index.php/wallyAPI/wally/");
//        //JSONObject obj = new JSONObject(responseBody);
//        String wally = responseBody.toString();
//        return wally;
//    }
}
