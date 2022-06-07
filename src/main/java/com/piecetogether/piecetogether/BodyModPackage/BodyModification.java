package com.piecetogether.piecetogether.BodyModPackage;
import com.piecetogether.piecetogether.model.Event;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table
public class BodyModification extends Event implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private Long eventId;

    private String title;
    private String notes;
    private LocalDate startDate;
    private LocalDate endDate;
    private String company;
    private double cost;


    public BodyModification() {
        //super(title, notes, startDate);
        company = "";
        cost = 0.0;
        super.title = "";
        super.notes = "";
        super.startDate = null;
        super.endDate = null;
    }

    public BodyModification(String title, String notes , LocalDate startDate, double cost, String company) {
        super();
        this.title = title;
        this.notes = notes;
        this.startDate = startDate;
        this.company = company;
        this.cost = cost;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
