package com.example.andrewpirondini.improvedloginsample;

import com.parse.ParseClassName;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by andrewpirondini on 10/18/15.
 */
@ParseClassName("Student")
public class Student extends ParseUser {

    public Student () {
        super();
    }

    public Student (String username, String password) {
        super();
        this.setUsername(username);
        this.setEmail(username);
        this.setPassword(password);
        this.put("type", "student");
    }

    public void setUniversity(String university) {
        this.put("university", university);
    }

    public String getUniversity() {
        return this.getString("university");
    }
}
