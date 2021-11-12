package com.solvd.lawfirmhierarchy.cases;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.solvd.lawfirmhierarchy.parsing.DateAdapter;
import com.solvd.lawfirmhierarchy.parsing.DateDeserialize;
import com.solvd.lawfirmhierarchy.people.Client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class Case {

    @XmlAttribute(name = "contractnumber")
    @JsonProperty("contractnumber")
    private String contractNumber;
    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name = "dateofconclusion")
    @JsonDeserialize(using = DateDeserialize.class)
    @JsonProperty("dateofconclusion")
    private LocalDate dateOfConclusion;
    private Client client;

    @Override
    public String toString() {
        return "\nCase: " +
                "contractNumber = " + contractNumber +
                ", dateOfConclusion = " + dateOfConclusion +
                ", client = " + client;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public LocalDate getDateOfConclusion() {
        return dateOfConclusion;
    }

    public void setDateOfConclusion(LocalDate dateOfConclusion) {
        this.dateOfConclusion = dateOfConclusion;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
