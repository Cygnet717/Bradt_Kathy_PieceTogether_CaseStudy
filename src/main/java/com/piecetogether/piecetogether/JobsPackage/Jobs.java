package com.piecetogether.piecetogether.JobsPackage;

import com.piecetogether.piecetogether.model.Event;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table
public class Jobs extends Event implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private Long eventId;

    private String company;
    private String title;
    private Double hourlyPay;
    private Integer salary;
    private LocalDate startDate;
    private LocalDate endDate;
    private String notes;

    public Jobs() {
        super();
        company = "";
        hourlyPay = 0.0;
        salary = 0;
    }

    public Jobs(String title, String notes, LocalDate startDate, String company, Double hourlyPay) {
        super();
        this.title = title;
        this.notes = notes;
        this.startDate = startDate;
        this.company = company;
        this.hourlyPay = hourlyPay;

    }

    public Jobs(String title, String notes, LocalDate startDate, String company, Integer salary) {
        super(title, notes, startDate);
        this.company = company;
        this.salary = salary;
        this.title = title;
        this.notes = notes;
        this.startDate = startDate;
    }

    public Jobs(String title, String notes, LocalDate startDate, LocalDate endDate, String company, Double hourlyPay) {
        super(title, notes, startDate, endDate);
        this.company = company;
        this.hourlyPay = hourlyPay;
        this.title = title;
        this.notes = notes;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Jobs(String title, String notes, LocalDate startDate, LocalDate endDate, String company, Integer salary) {
        super(title, notes, startDate, endDate);
        this.company = company;
        this.salary = salary;
        this.title = title;
        this.notes = notes;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
