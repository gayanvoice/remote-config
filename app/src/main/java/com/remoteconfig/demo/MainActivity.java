package com.remoteconfig.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.remoteconfig.library.Remote;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {


    TextView textView, textStatus;
    Remote remote;
    String StringGetAppURL;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StringGetAppURL = "https://raw.githubusercontent.com/gayankuruppu/android-remote-config-library/master/remote-config.json";

        textView = findViewById(R.id.textView);
        textStatus = findViewById(R.id.textStatus);


        remote = new Remote();


        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.getCache().clear();


                StringRequest stringRequest = new StringRequest(Request.Method.GET, StringGetAppURL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String Response) {
                                textView.setText(Response);
                                textStatus.setText(R.string.app_response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // on error
                        textStatus.setText(R.string.app_error);
                    }
                });

                queue.add(stringRequest);
                queue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<String>() {
                    @Override
                    public void onRequestFinished(Request<String> request) {
                       // finished
                        textStatus.setText(R.string.app_finish);
                    }
                });






            }
        });



    }
}
