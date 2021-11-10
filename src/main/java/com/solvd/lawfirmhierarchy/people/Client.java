package com.solvd.lawfirmhierarchy.people;

import com.solvd.lawfirmhierarchy.parsing.adapters.LawyerAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Client {

    @XmlElement(name = "lastname")
    private String lastName;
    @XmlElement(name = "casetype")
    private String caseType;
    @XmlJavaTypeAdapter(LawyerAdapter.class)
    private Lawyer lawyer;

    @Override
    public String toString() {
        return "\nClient{" +
                "lastName='" + lastName + '\'' +
                ", caseType='" + caseType + '\'' +
                ", lawyer=" + lawyer +
                '}';
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
