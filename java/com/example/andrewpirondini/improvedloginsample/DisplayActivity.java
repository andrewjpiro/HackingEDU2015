package com.example.andrewpirondini.improvedloginsample;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayActivity extends Activity {


    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

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
