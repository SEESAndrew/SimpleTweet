package com.codepath.apps.restclienttemplate.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Tweet {
    public String body;
    public String createdAt;
    public User user;

    //Empty constructor for Parceler
    public Tweet(){}

    public static Tweet fromJSON(JSONObject json) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = json.getString("text");
        tweet.createdAt = json.getString("created_at");
        tweet.user = User.fromJSON(json.getJSONObject("user"));
        return tweet;

    }

    public static List<Tweet> fromJSONArray(JSONArray array) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for(int i = 0; i < array.length(); i++){
            Log.i("TAG", "Added Tweet" + array.getJSONObject(i));
            tweets.add(fromJSON(array.getJSONObject(i)));
        }
        return tweets;
    }

}
