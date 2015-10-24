package com.example.andrewpirondini.improvedloginsample;
import android.text.format.Time;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
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

    private void showTimePickerDialog(View v){
        DialogFragment newFragment = new OfficeHourFragment();
        newFragment.show(getFragmentManager(), "timePicker");

    }

    private void showDatePickerDialog(View v){
        DialogFragment newFragment = new OHDatePickerDialog();
        newFragment.show(getFragmentManager(), "datePicker");
    }

}
