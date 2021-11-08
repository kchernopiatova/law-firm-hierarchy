package com.solvd.lawfirmhierarchy;

import com.solvd.lawfirmhierarchy.cases.Case;
import com.solvd.lawfirmhierarchy.structure.Office;

import java.util.List;

public class LawFirm {

    private String firmName;
    private List<Office> offices;
    private List<Case> cases;

    @Override
    public String toString() {
        return "LawFirm{" +
                "firmName='" + firmName + '\'' +
                ", offices=" + offices +
                ", cases=" + cases +
                '}';
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }
}
