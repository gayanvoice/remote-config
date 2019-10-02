package com.remoteconfig.library;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RemoteParams {

    private Context context;
    String PREF = "remote_params";
    String DEFAULT_VALUE = "defaultValue";

    public RemoteParams(Context context){
        this.context = context;
    }

    public void setResponse(String response){

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PREF, response);
        editor.apply();
    }

    public String getString(String param, String defaultValue){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonPref = prefs.getString(PREF, DEFAULT_VALUE);
        try {
            JSONObject jsonResponse = new JSONObject(jsonPref);
            return jsonResponse.getString(param);
        } catch (JSONException e) {
            return defaultValue;
        }
    }

    public int getInt(String param, int defaultValue){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonPref = prefs.getString(PREF, DEFAULT_VALUE);
        try {
            JSONObject jsonResponse = new JSONObject(jsonPref);
            return jsonResponse.getInt(param);
        } catch (JSONException e) {
            return defaultValue;
        }
    }

    public JSONObject getJSONObject(String param){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonPref = prefs.getString(PREF, DEFAULT_VALUE);
        try {
            JSONObject jsonResponse = new JSONObject(jsonPref);
            return jsonResponse.getJSONObject(param);
        } catch (JSONException e) {
            return "{\"name\":\"John\"}";
        }
    }



}
