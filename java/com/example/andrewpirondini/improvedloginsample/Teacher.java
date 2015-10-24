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

    public Teacher (String username, String password, String university, List<Integer> classCodes) {
        super();
        this.setUsername(username);
        this.setEmail(username);
        this.setPassword(password);
        this.put("university", university);
        this.put("classCodes", classCodes);
        this.put("type", "teacher");
    }

    public void setUniversity(String university) {
        this.put("university", university);
    }

    public String getUniversity() {
        return this.getString("university");
    }

    public void setClassCodes(List<Integer> classCodes) {
        this.put("classCodes", classCodes);
    }

    public void addClassCode(int classCode) {
        List<Integer> currentCodes = this.getClassCodes();
        currentCodes.add(classCode);

        this.put("classCodes", currentCodes);
    }

    public List<Integer> getClassCodes() {
        return (List<Integer>)this.get("classCodes");
    }
}
