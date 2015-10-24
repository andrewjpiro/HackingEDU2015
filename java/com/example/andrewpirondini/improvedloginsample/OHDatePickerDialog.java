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
import android.app.Dialog;
import android.widget.DatePicker;
import android.app.DatePickerDialog;
import android.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by Bradpat28 on 10/24/15.
 */
public class OHDatePickerDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private int year;
    private int month;
    private int day;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),this,year,month,day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day){
        //Do something with the info chosen by the user
    }
    public int getYear(){return year;}

    public int getMonth(){return month;}

    public int getDay(){return day;}


}
