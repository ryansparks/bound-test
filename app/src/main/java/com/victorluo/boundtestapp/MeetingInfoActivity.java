package com.victorluo.boundtestapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Comment;

public class MeetingInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_info);

        final Button editEvent = (Button) findViewById(R.id.button9);
        editEvent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MeetingInfoActivity.this, FriendsActivity.class);
                MeetingInfoActivity.this.startActivity(i);


            }

        });

        final Button mainMenu = (Button) findViewById(R.id.button10);
        mainMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MeetingInfoActivity.this, MainActivity.class);
                MeetingInfoActivity.this.startActivity(i);


            }

        });

        final Button pay = (Button) findViewById(R.id.button4);
        pay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MeetingInfoActivity.this,PayPalActivity.class);
                MeetingInfoActivity.this.startActivity(i);


            }

        });
    }



    //mPostReference.addValueEventListener(postListener);
    ValueEventListener postListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            // Get Post object and use the values to update the UI
            Comment post = dataSnapshot.getValue(Comment.class);
            // ...
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            // Getting Post failed, log a message
            Log.d("loadPost:onCancelled", String.valueOf(databaseError.toException()));
            // ...
        }
    };
}