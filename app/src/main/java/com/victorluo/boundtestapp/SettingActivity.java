package com.victorluo.boundtestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        final Button changeCard = (Button) findViewById(R.id.button11);
        changeCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(SettingActivity.this, ChangeCardActivity.class);
                SettingActivity.this.startActivity(i);
            }
        });

        final Button aboutBound = (Button) findViewById(R.id.button12);
        aboutBound.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(SettingActivity.this, AboutBoundActivity.class);
                SettingActivity.this.startActivity(i);
            }
        });


    }
}
