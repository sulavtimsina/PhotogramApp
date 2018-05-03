package com.example.sulav.constraintlayouttry.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sulav.constraintlayouttry.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

public class LoginActivity2 extends AppCompatActivity {

    private static final String EMAIL = "email";
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private static final String TAG = "LoginActivity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);



        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Toast.makeText(LoginActivity2.this, "Login Success", Toast.LENGTH_LONG).show();
                Log.e(TAG, "onSuccess: logged in");
            }

            @Override
            public void onCancel() {
                // App code
                Toast.makeText(LoginActivity2.this, "Login Success", Toast.LENGTH_LONG).show();
                Log.e(TAG, "cancel");
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Toast.makeText(LoginActivity2.this, "Login Success", Toast.LENGTH_LONG).show();
                Log.e(TAG, "exception");
            }
        });
    }
}
