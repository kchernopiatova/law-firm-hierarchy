package com.solvd.lawfirmhierarchy.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.solvd.lawfirmhierarchy.parsing.DateAdapter;
import com.solvd.lawfirmhierarchy.parsing.DateDeserialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class Lawyer {

    @XmlElement(name = "firstname")
    @JsonProperty("firstname")
    private String firstName;

    @XmlElement(name = "lastname")
    @JsonProperty("lastname")
    private String lastName;

    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonDeserialize(using = DateDeserialize.class)
    private LocalDate dob;
    private Integer experience;

    public Lawyer(String firstName, String lastName, LocalDate dob, Integer experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.experience = experience;
    }

    public Lawyer() {

    }

    @Override
    public String toString() {
        return "\nLawyer: " +
                "firstName = " + firstName +
                ", lastName = " + lastName +
                ", dob = " + dob +
                ", experience = " + experience;
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