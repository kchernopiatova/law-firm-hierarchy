package com.solvd.lawfirmhierarchy.cases;

import com.solvd.lawfirmhierarchy.people.Client;
import java.time.LocalDate;

public class Case {

    private String contractNumber;
    private LocalDate dateOfConclusion;
    private Client client;

    @Override
    public String toString() {
        return "\nCase{" +
                "contractNumber='" + contractNumber + '\'' +
                ", dateOfConclusion=" + dateOfConclusion +
                ", client=" + client +
                '}';
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
