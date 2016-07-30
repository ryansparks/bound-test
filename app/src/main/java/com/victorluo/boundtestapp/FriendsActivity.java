package com.victorluo.boundtestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.victorluo.boundtestapp.DateTimeLocationPriceActivity;

public class FriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        final Button Meeting = (Button) findViewById(R.id.button6);
        Meeting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(FriendsActivity.this, DateTimeLocationPriceActivity.class);
                FriendsActivity.this.startActivity(i);


            }

        });
    }
}
