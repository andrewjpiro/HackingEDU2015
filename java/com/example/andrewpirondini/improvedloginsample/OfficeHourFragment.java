package com.example.andrewpirondini.improvedloginsample;

import android.text.format.DateFormat;
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
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.app.Dialog;
import android.widget.TimePicker;

import java.util.Calendar;


/**
 * Created by Bradpat28 on 10/24/15.
 */
public class OfficeHourFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
//TimePickerFragment
    private int hour;
    private int minute;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),this,hour,minute, DateFormat.is24HourFormat(getActivity()));

    }

    public void onTimeSet(TimePicker View, int hourOfDay, int minute){
        //do something with the time set by the user

    }

    public int getHour(){return hour;}
    public int getMinute(){return minute;}



}
