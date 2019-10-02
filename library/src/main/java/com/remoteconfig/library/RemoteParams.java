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
        String jsonPref = prefs.getString(param, defaultValue);

        try {
            JSONObject json_response = new JSONObject(jsonPref);
            return json_response.getString(param);
        } catch (JSONException e) {
            return e.toString();
        }






    }




}
