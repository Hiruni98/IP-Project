package com.example.adminpanel;

public class Dataevents {
    String Venue;
    String Name;
    String Description;
    String Date;
    String Time;

    public Dataevents() {
    }

    public Dataevents(String venue, String name, String description, String date, String time) {
        Venue = venue;
        Name = name;
        Description = description;
        Date = date;
        Time = time;
    }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
