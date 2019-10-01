package com.remoteconfig.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.remoteconfig.library.*;


public class MainActivity extends AppCompatActivity {


    TextView textView, textStatus;
    String StringGetAppURL;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textStatus = findViewById(R.id.textStatus);



        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {




            }
        });



    }
}
