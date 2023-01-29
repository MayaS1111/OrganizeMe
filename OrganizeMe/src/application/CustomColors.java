package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomColors {

    private String username;
    private String homeColor, trackerColor, calendarColor, noteColor, reminderColor, settingsColor;


    public void setUsername(String username) {
        this.username = username;
    }
    public void setUsername1() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("UserLog.txt"));
        this.username = String.valueOf(reader.readLine());
        reader.close();
        System.out.println("User from Reader: " + this.username);
    }
    public void setHomeColor(String homeColor) {
        this.homeColor = homeColor;
    }
    public void setTrackerColor(String trackerColor) {
        this.trackerColor = trackerColor;
    }
    public void setCalendarColor(String calendarColor) {
        this.calendarColor = calendarColor;
    }
    public void setNoteColor(String noteColor) {
        this.noteColor = noteColor;
    }
    public void setReminderColor(String reminderColor) {
        this.reminderColor = reminderColor;
    }
    public void setSettingsColor(String settingsColor) {
        this.settingsColor = settingsColor;
    }

    public String getUsername() {
        return username;
    }
    public String getHomeColor() {
        return homeColor;
    }
    public String getTrackerColor() {
        return trackerColor;
    }
    public String getCalendarColor() {
        return calendarColor;
    }
    public String getNoteColor() {
        return noteColor;
    }
    public String getReminderColor() {
        return reminderColor;
    }
    public String getSettingsColor() {
        return settingsColor;
    }
}
