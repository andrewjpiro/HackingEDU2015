package com.example.andrewpirondini.improvedloginsample;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by andrewpirondini on 10/20/15.
 */
public class ParseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "AT0IVCOmAOb4uRKlz8c4u55sbIxMnom17uN0rUR0",
                "AyQebnN2QLQzKWDgLXnKLZ2MChyPyUwoltoH5Pl9");
    }
}
