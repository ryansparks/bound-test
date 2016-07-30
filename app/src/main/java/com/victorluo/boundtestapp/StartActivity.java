package com.victorluo.boundtestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    Button createAccount, signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // ASSIGN LAYOUT VALUES TO BUTTONS AND TEXT VIEWS
        createAccount = (Button) findViewById(R.id.createaccount);
        signin = (Button) findViewById(R.id.signin);

        // ASSIGN ONCLICKLISTENERS
        createAccount.setOnClickListener(this);
        signin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.createaccount:
                Intent i1 = new Intent(StartActivity.this, CreateaccountActivity.class);
                startActivity(i1);
                break;
            case R.id.signin:
                Intent i = new Intent(StartActivity.this, SigninActivity.class);
                startActivity(i);
                break;
        }
    }
}