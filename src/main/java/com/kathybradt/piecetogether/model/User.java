package com.kathybradt.piecetogether.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private Long Id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @Column(name = "active")
    private Boolean active;

    private String role;

    @OneToMany(targetEntity= Jobs.class, cascade = {CascadeType.ALL}, mappedBy = "user")
//    @JoinColumn(name = "user_fk", referencedColumnName = "eventId")
    private List<Jobs> JobsList;

    @OneToMany(targetEntity= Pets.class, cascade = {CascadeType.ALL}, mappedBy = "user")
    private List<Pets> PetsList;

    @OneToMany(targetEntity= Other.class, cascade = {CascadeType.ALL}, mappedBy = "user")
    private List<Other> OtherList;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public List<Jobs> getJobsList() {
        return JobsList;
    }

    public void setJobsList(List<Jobs> JobsList) {
        this.JobsList = JobsList;
    }

    public List<Pets> getPetsList() {
        return PetsList;
    }

    public void setPetsList(List<Pets> PetsList) {
        this.PetsList = PetsList;
    }

    public List<Other> getOtherList() {
        return OtherList;
    }

    public void setOtherList(List<Other> OtherList) {
        this.OtherList = OtherList;
    }

    public Long getId() {
        return Id;
    }
    //no set Id
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
