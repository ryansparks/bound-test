package com.victorluo.boundtestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChangeCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_card);

        final Button sendRequest = (Button) findViewById(R.id.button17);
        sendRequest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ChangeCardActivity.this, SettingActivity.class);
                ChangeCardActivity.this.startActivity(i);


            }

        });
    }
}
