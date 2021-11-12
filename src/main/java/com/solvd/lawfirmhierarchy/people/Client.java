package com.solvd.lawfirmhierarchy.people;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Client {

    @XmlElement(name = "lastname")
    @JsonProperty("lastname")
    private String lastName;
    @XmlElement(name = "casetype")
    @JsonProperty("casetype")
    private String caseType;
    private Lawyer lawyer;

    @Override
    public String toString() {
        return "\nClient: " +
                "lastName = " + lastName +
                ", caseType = " + caseType +
                ", lawyer = " + lawyer;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }
}