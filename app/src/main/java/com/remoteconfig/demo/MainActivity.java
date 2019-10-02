package com.remoteconfig.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.remoteconfig.library.RemoteSettings;
import com.remoteconfig.library.RequestQueue;
import com.remoteconfig.library.Response;
import com.remoteconfig.library.VolleyError;

import com.remoteconfig.library.toolbox.RemoteConfig;
import com.remoteconfig.library.toolbox.Volley;

public class MainActivity extends AppCompatActivity {


    TextView textView, textStatus;

    RemoteConfig remoteConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textStatus = findViewById(R.id.textStatus);



        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.getCache().clear();

                remoteConfig = new RemoteConfig(
                        new RemoteSettings(
                                0,
                                "https://raw.githubusercontent.com/gayankuruppu/android-remote-config-library/master/remote-config.json"
                        ),
                        new Response.Listener<String>() {
                            @Override
                            public void onComplete(String Response) {
                                textView.setText(Response);
                                textStatus.setText(R.string.app_response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onError(VolleyError error) {
                                textView.setText(error.toString());
                                textStatus.setText(R.string.app_error);
                            }
                        }
                );


                queue.add(remoteConfig);

                /*
                queue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<String>() {
                    @Override
                    public void onRequestFinished(Request<String> request) {
                        textStatus.setText(R.string.app_finish);
                    }
                });
*/

            }
        });



    }
}
