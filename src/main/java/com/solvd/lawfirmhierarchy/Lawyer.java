package com.solvd.lawfirmhierarchy;

import java.time.LocalDate;

public class Lawyer {

    private String lastName;
    private LocalDate dob;
    private Integer experience;

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
