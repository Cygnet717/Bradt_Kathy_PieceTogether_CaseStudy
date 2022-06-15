package com.kathybradt.piecetogether.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;


import javax.persistence.*;

@Entity
@Table
public class Pets extends Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private Long eventId;

    private String title;
    private String petType;
    private Date startDate;
    private Date endDate;
    private String notes;
    private String eventType = "Pet";


    public Pets() {
        super();
        petType = "";

    }

    public Pets(String title, String petType, Date startDate, Date endDate, String notes) {
        super();
        this.title = title;
        this.notes = notes;
        this.startDate = startDate;
        this.endDate = endDate;
        this.petType = petType;

    }

    @Override
    public String getEventType() {
        return eventType;
    }

    @Override
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
