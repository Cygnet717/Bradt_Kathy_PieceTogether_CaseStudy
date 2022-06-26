package com.kathybradt.piecetogether.model;

import java.sql.Date;



public class Event {
    public String title;
    public String notes;
    public Date date;
    public String eventType;

    public Event() {
    }

    //Constructor for event
    public Event(String title, String notes, Date date, String eventType) {
        this.title = title;
        this.notes = notes;
        this.date = date;

        this.eventType = eventType;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
