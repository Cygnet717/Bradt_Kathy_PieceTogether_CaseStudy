package com.piecetogether.piecetogether.UserPackage;

import com.piecetogether.piecetogether.BodyModPackage.BodyModification;
import com.piecetogether.piecetogether.FamilyPackage.Family;
import com.piecetogether.piecetogether.JobsPackage.Jobs;
import com.piecetogether.piecetogether.OtherPackage.Other;
import com.piecetogether.piecetogether.PetsPackage.Pets;
import com.piecetogether.piecetogether.SchoolPackage.School;
import com.piecetogether.piecetogether.VacationPackage.Vacation;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
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

    @OneToMany(targetEntity= BodyModification.class, cascade = {CascadeType.ALL})
    private List<BodyModification> BodyModList;

    @OneToMany(targetEntity= Family.class, cascade = {CascadeType.ALL})
    private List<Family> FamilyList;

    @OneToMany(targetEntity= Vacation.class, cascade = {CascadeType.ALL})
    private List<Vacation> VacationList;

    @OneToMany(targetEntity= School.class, cascade = {CascadeType.ALL})
    private List<School> SchoolList;

    @OneToMany(targetEntity= Jobs.class, cascade = {CascadeType.ALL})
    private List<Jobs> JobsList;

    @OneToMany(targetEntity= Pets.class, cascade = {CascadeType.ALL})
    private List<Pets> PetsList;

    @OneToMany(targetEntity= Other.class, cascade = {CascadeType.ALL})
    private List<Other> OtherList;

    public User() {
        firstName = "Jane";
        lastName = "Doe";
        email = "Jane@email.com";
        password = "12345";

    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public List<BodyModification> getBodyModList() {
        return BodyModList;
    }

    public void setBodyModList(List<BodyModification> BodyModList) {
        this.BodyModList = BodyModList;
    }

    public List<Family> getFamilyList() {
        return FamilyList;
    }

    public void setFamilyList(List<Family> FamilyList) {
        this.FamilyList = FamilyList;
    }

    public List<Vacation> getVacationList() {
        return VacationList;
    }

    public void setVacationList(List<Vacation> VacationList) {
        this.VacationList = VacationList;
    }

    public List<School> getSchoolList() {
        return SchoolList;
    }

    public void setSchoolList(List<School> SchoolList) {
        this.SchoolList = SchoolList;
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
}
