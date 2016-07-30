package com.victorluo.boundtestapp;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View.OnClickListener;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;


import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

// get all of the text values

// save them into firebase-- write operation

// retrive them in meeting info-- read operation


public class DateTimeLocationPriceActivity extends AppCompatActivity {
    final static String DB_URL = "https://realbound-63260.firebaseio.com/";


    Button saveBtn;

    AutoCompleteTextView dateTxt, timeTxt, locationTxt, priceTxt;
    String date = "", time = "", location = "", price = "";

    Firebase fb;


    //Firebase fire;
    // Create a storage reference from our app

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_location_price);
        Firebase.setAndroidContext(this);
        fb = new Firebase(DB_URL);

        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        dateTxt = (AutoCompleteTextView) findViewById(R.id.date1);
        timeTxt = (AutoCompleteTextView) findViewById(R.id.time1);
        locationTxt = (AutoCompleteTextView) findViewById(R.id.location1);
        priceTxt = (AutoCompleteTextView) findViewById(R.id.price1);


        saveBtn = (Button) findViewById(R.id.button13);

        dateTxt.setText("");
        timeTxt.setText("");
        locationTxt.setText("");
        priceTxt.setText("");

        saveBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                fb.child("date").child(date).setValue(dateTxt.getText().toString());
                fb.child("time").child(time).setValue(timeTxt.getText().toString());
                fb.child("location").child(location).setValue(locationTxt.getText().toString());
                fb.child("price").child(price).setValue(priceTxt.getText().toString());

                Intent i = new Intent(DateTimeLocationPriceActivity.this, MeetingInfoActivity.class);
                DateTimeLocationPriceActivity.this.startActivity(i);
            }
        });
/*
        // This is how you set a value.
        mDatabase.child("omg").setValue("lol");

        // This is how you read a value.
        mDatabase.child("omg").addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                String value = (String)dataSnapshot.getValue();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });
*/





    }

    // saveBtn.setOnClickListener(new View.OnClickListener()
/*

    public void onClick(View v) {

        setDate(dateTxt.getText().toString());
        setTime(timeTxt.getText().toString());
        setLocation(locationTxt.getText().toString());
        setPrice(priceTxt.getText().toString());
        //Persist
        fire.child("DateTimeLocationPrice").setValue(d);

        dateTxt.setText("");
        timeTxt.setText("");
        locationTxt.setText("");
        priceTxt.setText("");

    }



    //Initialize our firebase
    private void initializeFirebase() {
        FirebaseDatabase.setAndroidContext(this);
    }



//Display Input Dialog
    private void showDialog() {
        Dialog d = new Dialog(this);
        d.setTitle("save Online");
        d.setContentView(R.layout.dialogLayout);

        dateTxt = (EditText) findViewById(R.id.date1);
        timeTxt = (EditText) findViewById(R.id.time1);
        locationTxt = (EditText) findViewById(R.id.location1);
        priceTxt = (EditText) findViewById(R.id.price1);

        saveBtn = (Button) findViewById(R.id.button13);

        saveBtn.setOnClickListener(new View.OnClickListener() {

        });
    }

    @Override
    public void onCLick(View v) {
        addData(dateView.getText().toString(), timeView.getText().toString(), locationView.getText().toString(), priceView.getText().toString());

        dateTxt.setText("");
        timeTxt.setText("");
        locationTxt.setText("");
        priceTxt.setText("");


    }


    private void addData(String Date, String Time, String Location, String Price) {
        DateTimeLocationPrice d = new DateTimeLocationPrice();
        d.setDate(date);

        d.setTime(time);
        d.setLocation(location);
        d.setPrice(price);


        fire.child("DateTimeLocationPrice").push().setValue(d);
    }

    //retrieve

    private void retrieveData() {
        fire.addChildEventListener(new ChildEventListener() {

        });
    }



            sendRequest = (Button) findViewById(R.id.button13);
            sendRequest.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent i = new Intent(DateTimeLocationPrice.this, MeetingInfo.class);
                    DateTimeLocationPrice.this.startActivity(i);

                    date = dateView.getText().toString();
                    time = timeView.getText().toString();
                    location = locationView.getText().toString();
                    price = priceView.getText().toString();

                }
            });
            // ATTENTION: This was auto-generated to implement the App Indexing API.
            // See https://g.co/AppIndexing/AndroidStudio for more information.
            client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "DateTimeLocationPrice Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.victorluo00gmail.boundapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "DateTimeLocationPrice Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.victorluo00gmail.boundapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    //private DatabaseReference mDatabase;
// ...
    // mDatabase = FirebaseDatabase.getInstance().getReference();


    createAccount.setOnClickListener(new

    OnClickListener() {
        @Override
        public void onClick;(View) view){
            fbdb.createUser(dateView.getText().toString(), timeView.getText().toString(), locationView.getText().toString(), priceView.getText().toString());
            new FirebaseDatabase.ValueResultHandler<Map<String, Object>>() {
                @Override
                public void onSuccess(Map<String, Object> stringObjectMap) {
                    System.out.println("Successfully created user");
                    LoginActivity.this.finish();

                }

                @Override
                public void onError(FirebaseError firebaseError) {
                    Log.d("LoginActivity", firebaseError.getMessage());
                }

            };
        }
    }

    )



    public class Main3Activity extends AppCompatActivity {
        String date = "";
        String time = "";
        String location = "";
        String price = "";

        private AutoCompleteTextView DateView;
        private AutoCompleteTextView TimeView;
        private AutoCompleteTextView LocationView;
        private AutoCompleteTextView PriceView;

        DateView=(AutoCompleteTextView)

        findViewById(R.id.date1);

        TimeView=(AutoCompleteTextView)

        findViewById(R.id.time1);

        LocationView=(AutoCompleteTextView)

        findViewById(R.id.location1);

        PriceView=(AutoCompleteTextView)

        findViewById(R.id.price1);

        date=DateView.getText().

        toString();

        time=TimeView.getText().

        toString();

        location=LocationView.getText().

        toString();

        price=PriceView.getText().

        toString();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main3);

            final Button Meeting = (Button) findViewById(R.id.button6);
            Meeting.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent i = new Intent(Main3Activity.this, DateTimeLocationPrice.class);
                    Main3Activity.this.startActivity(i);

                    class User {
                        private int birthYear;
                        private String fullName;

                        public User() {
                        }

                        public User(String fullName, int birthYear) {
                            this.fullName = fullName;
                            this.birthYear = birthYear;
                        }

                        public long getBirthYear() {
                            return birthYear;
                        }

                        public String getFullName() {
                            return fullName;
                        }
                    }
                    Firebase ref;
                    Firebase alanRef = ref.child("users").child("alanisawesome");
                    User alan = new User("Alan Turing", 1912);
                    alanRef.setValue(alan);

                }
            });


        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "DateTimeLocationPrice Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.victorluo00gmail.boundapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "DateTimeLocationPrice Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.victorluo00gmail.boundapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    */
}


