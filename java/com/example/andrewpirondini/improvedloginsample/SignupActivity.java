package com.example.andrewpirondini.improvedloginsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewpirondini on 10/20/15.
 */
public class SignupActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            ParseUser.logOut();
        }
        partialFillForm(getIntent().getBundleExtra("loginBundle"));
        setupSignupFormSubmit();
    }

    private void partialFillForm(Bundle loginBundle) {
        EditText usernameInput = (EditText) findViewById(R.id.usernameInput);
        EditText passwordInput = (EditText) findViewById(R.id.passwordInput);

        usernameInput.setText(loginBundle.getString("username"));
        passwordInput.setText(loginBundle.getString("password"));
    }

    private void setupSignupFormSubmit() {
        Button signupButton = (Button) findViewById(R.id.signupButton);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((EditText) findViewById(R.id.usernameInput)).getText().toString();
                String password = ((EditText) findViewById(R.id.passwordInput)).getText().toString();
                String university = ((EditText) findViewById(R.id.universityInput)).getText().toString();
                String[] strClassCodes = ((EditText) findViewById(R.id.classesInput)).getText().toString().split(" ");

                List<Integer> classCodes = new ArrayList<Integer>();
                for (String code : strClassCodes) {
                    classCodes.add(Integer.parseInt(code));
                }

                Teacher teacher = new Teacher(username, password, university, classCodes);

                teacher.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Bundle loginBundle = new Bundle();
                            loginBundle.putString("username", ParseUser.getCurrentUser().getUsername());

                            Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
                            intent.putExtra("loginBundle", loginBundle);
                            startActivity(intent);
                        } else {
                            TextView errorDisplay = (TextView) (findViewById(R.id.errorDisplay));
                            errorDisplay.setText(e.getMessage());
                        }
                    }
                });
            }
        });
    }
}
