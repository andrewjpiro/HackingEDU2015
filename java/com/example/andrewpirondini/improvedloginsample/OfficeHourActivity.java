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

/**
 * Created by Bradpat28 on 10/24/15.
 */
public class OfficeHourActivity extends Activity {

    private int hour;
    private int minute;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_create);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            ParseUser.logOut();
        }
        setUpOfficeHour();
    }


    private void setUpOfficeHour(/*OHDatePickerDialog dp, OfficeHourFragment td*/){
        Button officeHourTime = (Button) findViewById(R.id.officeHourTime);
        Button officeHourDate = (Button) findViewById(R.id.officeHourDate);

        /* officeHourTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void OnClick(View v){
                final int year = dp.getYear();
                final int month = dp.getMonth();
                final int day = dp.getDay();
                final int hour = td.getHour();
                final int minute = td.getMinute();

            }


        }*/


    }






}
