package com.solvd.lawfirmhierarchy.people;

import java.time.LocalDate;

public class Lawyer {

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Integer experience;

    public Lawyer(String firstName, String lastName, LocalDate dob, Integer experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Lawyer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", experience=" + experience +
                '}';
    }

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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }
}
