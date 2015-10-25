package com.example.andrewpirondini.improvedloginsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Button;


public class DisplayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        displayLoginInfo(getIntent().getBundleExtra("loginBundle"));
        setUpCancelOfficeHour();
    }

    private void displayLoginInfo(Bundle loginBundle) {
        TextView usernameDisplay = (TextView) findViewById(R.id.usernameDisplay);
        usernameDisplay.setText(loginBundle.getString("username"));
    }

    private void setUpCancelOfficeHour(){
        final Button cancelOfficeHour = (Button) findViewById(R.id.cancelOfficeHour);
        cancelOfficeHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Teacher.cancelOfficeHour(getApplicationContext());
            }
        });


    }

}
