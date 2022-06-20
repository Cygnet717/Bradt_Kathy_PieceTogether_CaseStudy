package com.kathybradt.piecetogether.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table
public class Jobs extends Event implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private Long eventId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private String company;
    private String title;
    private Double hourlyPay;
    private Integer salary;
    private Date startDate;
    private Date endDate;
    private String notes;
    private String eventType = "Job";

    public Jobs() {
    }

    public Jobs(String title, String notes, Date startDate, Date endDate, String eventType, User user, String company, Double hourlyPay) {
        super(title, notes, startDate, endDate, eventType);
        this.user = user;
        this.company = company;
        this.hourlyPay = hourlyPay;
    }

    public Jobs(String title, String notes, Date startDate, Date endDate, String eventType, User user, String company, Integer salary) {
        super(title, notes, startDate, endDate, eventType);
        this.user = user;
        this.company = company;
        this.salary = salary;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(Double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
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
