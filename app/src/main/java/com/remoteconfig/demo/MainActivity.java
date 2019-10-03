package com.remoteconfig.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.remoteconfig.library.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    TextView textViewSimpleText, textViewNumber, textViewJSONObject,textViewJSONArray, textViewBoolean;
    Button buttonRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSimpleText = findViewById(R.id.textViewSimpleText);
        textViewNumber = findViewById(R.id.textViewNumber);
        textViewJSONObject = findViewById(R.id.textViewJSONObject);
        textViewJSONArray = findViewById(R.id.textViewJSONArray);
        textViewBoolean = findViewById(R.id.textViewBoolean);

        buttonRequest = findViewById(R.id.buttonRequest);


        buttonRequest.setOnClickListener(new View.OnClickListener() {
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
                                textViewSimpleText.setText(remoteParams.getString("short_text", "default_text"));

                                int intValue = remoteParams.getInt("number", 200);
                                textViewNumber.setText(String.valueOf(intValue));

                                JSONObject jsonObject = remoteParams.getJSONObject("json_object");
                                textViewJSONObject.setText(String.valueOf(jsonObject));

                                JSONArray jsonArray = remoteParams.getJSONArray("json_array");
                                textViewJSONArray.setText(String.valueOf(jsonArray));

                                boolean booleanValue = remoteParams.getBoolean("boolean", false);
                                textViewBoolean.setText(String.valueOf(booleanValue));

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onError(RemoteError error) {
                                // json file retrieve error

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
