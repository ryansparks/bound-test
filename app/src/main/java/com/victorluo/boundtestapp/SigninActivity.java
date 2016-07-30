package com.victorluo.boundtestapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SigninActivity extends AppCompatActivity {

    // FIREBASE VARIABLES
    final static String DB_URL = "https://realbound-63260.firebaseio.com/";
    Firebase fb;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;


    // USER INTERFACE VARIABLES
    EditText emailfield, passwordfield;
    Button loginButton;

    // FACEBOOK LOGIN VARIABLES
    private CallbackManager callbackManager;

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        // INITIALIZE FIREBASE
        Firebase.setAndroidContext(this);
        fb = new Firebase(DB_URL);
        mAuth = FirebaseAuth.getInstance();
        FirebaseAuth.getInstance().signOut();

        // INITIALIZE UI COMPONENTS
        emailfield = (EditText) findViewById(R.id.emailfield);
        passwordfield = (EditText) findViewById(R.id.passwordfield);
        loginButton = (Button) findViewById(R.id.signinbutton);

        //SET ON CLICK LISTENER FOR BUTTON
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SigninActivity.this, "tst", Toast.LENGTH_SHORT).show();
                mAuth.signInWithEmailAndPassword(emailfield.getText().toString(), passwordfield.getText().toString())
                        .addOnCompleteListener(SigninActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d("FIREBASE", "signInWithEmail:onComplete:" + task.isSuccessful());

                                if(!task.isSuccessful()) {
                                    Log.w("FIREBASE", "signInWithEmail:failed", task.getException());
                                    Toast.makeText(SigninActivity.this, "Authentication Error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        //INITIALIZE AUTH STATE CHANGE LISTENER
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(SigninActivity.this, "Signed in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SigninActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(SigninActivity.this, "Signed out", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mAuthListener != null)
            mAuth.removeAuthStateListener(mAuthListener);
    }
}
