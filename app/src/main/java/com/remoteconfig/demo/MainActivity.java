package com.remoteconfig.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.remoteconfig.library.Remote;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Remote remote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        remote = new Remote();

        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                textView.setText(remote.getText());
            }
        });



    }
}
