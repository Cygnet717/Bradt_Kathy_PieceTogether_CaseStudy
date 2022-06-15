package com.kathybradt.piecetogether.model;

import java.sql.Date;



public class Event {
    public String title;
    public String notes;
    public Date startDate;
    public Date endDate;

    public Event() {
        title = "";
        notes = "";
        startDate = null;
        endDate = null;
    }

    public Event(String title, String notes, Date startDate, Date endDate) {
        this.title = title;
        this.notes = notes;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Event(String title, String notes, Date startDate) {
        this.title = title;
        this.notes = notes;
        this.startDate = startDate;
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

}
