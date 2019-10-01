package com.remoteconfig.library;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class RemoteConfig {
    private Context context;
    private String strURL;
    public String strResponse;

    public RemoteConfig(Context context) {
        this.context = context;
    }

    public void setURL(String strURL) {
        this.strURL = strURL;
    }

    public void getString() {

        RequestQueue queue = Volley.newRequestQueue(this.context);
        queue.getCache().clear();


        StringRequest stringRequest = new StringRequest(Request.Method.GET, strURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String Response) {
                        //this.strResponse = Response;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // on error

            }
        });

        queue.add(stringRequest);
        queue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<String>() {
            @Override
            public void onRequestFinished(Request<String> request) {
                // finished
            }
        });
    }
    
}
