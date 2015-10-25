package com.example.andrewpirondini.improvedloginsample;

import com.parse.ParseClassName;
import com.parse.ParseUser;

import java.util.List;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat.Builder;
import android.content.Context;
import android.support.v7.app.NotificationCompat;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import android.support.v4.app.TaskStackBuilder;



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

    public static void cancelOfficeHour(Context context){
        //Creates the notification that OH have been canceled
        int id = 1;
        NotificationCompat.Builder cancel = new NotificationCompat.Builder(context);
        cancel.setSmallIcon(R.drawable.notification_template_icon_bg);
        cancel.setContentTitle("OFFICE HOURS CANCELLED");
        cancel.setContentText("Office hours canceled today.");

        Intent resultIntent = new Intent(context, DisplayActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(DisplayActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        cancel.setContentIntent(resultPendingIntent);

        NotificationManager cancelNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        cancelNotificationManager.notify(id, cancel.build());

    }
}
