package com.kathybradt.piecetogether.model;

import java.time.LocalDate;


public class Event {
    public String title;
    public String notes;
    public LocalDate startDate;
    public LocalDate endDate;

    public Event() {
        title = "";
        notes = "";
        startDate = null;
        endDate = null;
    }

    public Event(String title, String notes, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.notes = notes;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Event(String title, String notes, LocalDate startDate) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

}
