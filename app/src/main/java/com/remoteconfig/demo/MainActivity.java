package com.remoteconfig.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.remoteconfig.library.RemoteParams;
import com.remoteconfig.library.Request;
import com.remoteconfig.library.RequestQueue;
import com.remoteconfig.library.Response;
import com.remoteconfig.library.RemoteError;

import com.remoteconfig.library.toolbox.RemoteConfig;
import com.remoteconfig.library.toolbox.Volley;


public class MainActivity extends AppCompatActivity {


    TextView textView, textStatus;

    RemoteConfig remoteConfig;
    String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textStatus = findViewById(R.id.textStatus);

        mUrl ="https://raw.githubusercontent.com/gayankuruppu/android-remote-config-library/master/remote-config.json";

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.getCache().clear();

                remoteConfig = new RemoteConfig(
                        MainActivity.this,
                        mUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onComplete() {

                                RemoteParams remoteParams = new RemoteParams(MainActivity.this);
                                textView.setText(remoteParams.getString("short_text", "some_text"));

                                textStatus.setText(R.string.app_response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onError(RemoteError error) {
                                textView.setText(error.toString());
                                textStatus.setText(R.string.app_error);
                            }
                        }
                );

            }
        });



    }
}
