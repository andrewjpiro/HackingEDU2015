package com.example.andrewpirondini.improvedloginsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            ParseUser.logOut();
        }
        setUpLoginButton();
        setUpSignupButton();
    }

    private void setUpLoginButton() {
        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                final String username = ((EditText)findViewById(R.id.usernameInput))
                        .getText().toString();
                final String password = ((EditText)findViewById(R.id.passwordInput))
                        .getText().toString();
                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            Bundle loginBundle = new Bundle();
                            loginBundle.putString("username", user.getUsername());

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

    private void setUpSignupButton() {
        Button signupButton = (Button) findViewById(R.id.signupButton);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((EditText) findViewById(R.id.usernameInput)).getText().toString();
                String password = ((EditText) findViewById(R.id.passwordInput)).getText().toString();
                RadioButton studentSelect = (RadioButton) findViewById(R.id.studentButton);
                RadioButton teacherSelect = (RadioButton) findViewById(R.id.teacherButton);

                ParseUser user = null;
                if (studentSelect.isChecked()) {
                    user = new Student(username, password);
                } else if (teacherSelect.isChecked()) {
                    user = new Teacher(username, password);
                } else {
                    TextView errorDisplay = (TextView) (findViewById(R.id.errorDisplay));
                    errorDisplay.setText("Please indicate whether you are a student or a teacher");
                }

                if (user != null) {
                    user.signUpInBackground(new SignUpCallback() {
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
            }
        });
    }
}
