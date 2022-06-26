package com.kathybradt.piecetogether.model;

import java.io.Serializable;
import java.sql.Date;


import javax.persistence.*;

@Entity
@Table
public class Pets extends Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private Long eventId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "Id", nullable = false)
    private User user;
    private String title;
    private String petType;
    private Date date;
    private String notes;
    private String eventType = "Pet";

    public Pets() {
    }

    //Constructor for pet event
    public Pets(String title, String notes, Date date, String eventType, User user, String petType) {
        super(title, notes, date, eventType);
        this.user = user;
        this.petType = petType;
    }

    @Override
    public String toString(){
        return eventType + ' ' + eventId;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date startDate) {
        this.date = startDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
