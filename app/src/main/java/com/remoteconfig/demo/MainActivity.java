package com.remoteconfig.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.remoteconfig.library.*;

public class MainActivity extends AppCompatActivity {


    TextView textView, textStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textStatus = findViewById(R.id.textStatus);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // set request
                RequestQueue queue = FetchRemote.newRequestQueue(MainActivity.this);

                // url of the json file
                String mUrl ="https://raw.githubusercontent.com/gayankuruppu/android-remote-config-library/master/remote-config.json";

                // request the json file
                RemoteConfig remoteConfig = new RemoteConfig(MainActivity.this, mUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onComplete() {
                                // json file retrieved
                                RemoteParams remoteParams = new RemoteParams(MainActivity.this);
                                textView.setText(remoteParams.getString("short_text", "default_text"));

                                textStatus.setText(R.string.app_response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onError(RemoteError error) {
                                // json file retrieve error
                                textView.setText(error.toString());
                                textStatus.setText(R.string.app_error);
                            }
                        }
                );

                // clear cache
                remoteConfig.setShouldCache(false);
                queue.add(remoteConfig);

            }
        });



    }
}
