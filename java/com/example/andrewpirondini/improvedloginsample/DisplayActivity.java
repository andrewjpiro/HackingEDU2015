package com.example.andrewpirondini.improvedloginsample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        displayLoginInfo(getIntent().getBundleExtra("loginBundle"));
    }

    private void displayLoginInfo(Bundle loginBundle) {
        TextView usernameDisplay = (TextView) findViewById(R.id.usernameDisplay);

        usernameDisplay.setText(loginBundle.getString("username"));
    }
}
