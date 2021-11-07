package com.solvd.lawfirmhierarchy;

import java.time.LocalDate;

public class Case {

    private String contractNumber;
    private LocalDate dateOfConclusion;
    private Client client;

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
