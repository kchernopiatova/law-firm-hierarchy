package com.solvd.lawfirmhierarchy.people;

public class Client {

    private String lastName;
    private String caseType;
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
