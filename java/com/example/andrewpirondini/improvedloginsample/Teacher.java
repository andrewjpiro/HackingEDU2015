package com.example.andrewpirondini.improvedloginsample;

import com.parse.ParseClassName;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by andrewpirondini on 10/18/15.
 */
@ParseClassName("Teacher")
public class Teacher extends ParseUser {

    public Teacher () {
        super();
    }

    public Teacher (String username, String password) {
        super();
        this.setUsername(username);
        this.setEmail(username);
        this.setPassword(password);
        this.put("type", "teacher");
    }

    public void setUniversity(String university) {
        this.put("university", university);
    }

    public String getUniversity() {
        return this.getString("university");
    }
}
