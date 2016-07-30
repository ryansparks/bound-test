package com.victorluo.boundtestapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Button Meeting = (Button) findViewById(R.id.button3);
        Meeting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FriendsActivity.class);
                MainActivity.this.startActivity(i);
            }

        });


        final Button CurrentMeeting = (Button) findViewById(R.id.button5);
        CurrentMeeting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CurrentMeetupsActivity.class);
                MainActivity.this.startActivity(i);


            }

        });

        final Button settings = (Button) findViewById(R.id.button16);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SettingActivity.class);
                MainActivity.this.startActivity(i);
            }
        });
    }

}

