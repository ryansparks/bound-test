package com.victorluo.boundtestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.victorluo.boundtestapp.MeetingInfoActivity;

public class CurrentMeetupsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_meetups);

        final Button sendRequest = (Button) findViewById(R.id.button14);
        sendRequest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(CurrentMeetupsActivity.this, MeetingInfoActivity.class);
                CurrentMeetupsActivity.this.startActivity(i);


            }

        });
    }
}
