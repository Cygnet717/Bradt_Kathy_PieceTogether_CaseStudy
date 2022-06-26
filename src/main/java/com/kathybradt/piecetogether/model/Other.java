package com.kathybradt.piecetogether.model;

import java.io.Serializable;
import java.sql.Date;


import javax.persistence.*;

@Entity
@Table
public class Other extends Event implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private Long eventId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private String title;
    private String notes;
    private Date date;
    private String eventType;

    public Other() {
    }

    //Constructor
    public Other(String title, String notes, Date date, String eventType, User user) {
        super(title, notes, date, eventType);
        this.user = user;
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
    public String getEventType() { return eventType; }

    @Override
    public void setEventType(String eventType) { this.eventType = eventType; }

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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date startDate) {
        this.date = startDate;
    }
}
