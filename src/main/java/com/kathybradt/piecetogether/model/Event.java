package com.kathybradt.piecetogether.model;

import java.sql.Date;



public class Event {
    public String title;
    public String notes;
    public Date startDate;
    public Date endDate;
    public String eventType;

    public Event() {
    }

    //Constructor for event with start and end date
    public Event(String title, String notes, Date startDate, Date endDate, String eventType) {
        this.title = title;
        this.notes = notes;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventType = eventType;
    }

    //Constructor for event with no end date
    public Event(String title, String notes, Date startDate, String eventType) {
        this.title = title;
        this.notes = notes;
        this.startDate = startDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
