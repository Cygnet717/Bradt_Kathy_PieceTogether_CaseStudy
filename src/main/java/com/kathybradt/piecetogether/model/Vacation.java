package com.kathybradt.piecetogether.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table
public class Vacation extends Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private int eventId;

    private String title;
    private String notes;
    private LocalDate startDate;
    private LocalDate endDate;

    public Vacation() {
        super();
    }

    public Vacation(String title, String notes, LocalDate startDate, LocalDate endDate) {
        super();
        this.title = title;
        this.notes = notes;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
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
