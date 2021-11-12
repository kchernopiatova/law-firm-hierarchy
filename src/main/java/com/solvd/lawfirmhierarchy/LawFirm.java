package com.solvd.lawfirmhierarchy;

import com.solvd.lawfirmhierarchy.cases.Case;
import com.solvd.lawfirmhierarchy.structure.Office;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "lawfirm")
@XmlAccessorType(XmlAccessType.FIELD)
public class LawFirm {

    @XmlElement(name = "firmname")
    private String firmName;
    @XmlElementWrapper(name = "offices")
    @XmlElement(name = "office")
    private List<Office> offices;
    @XmlElementWrapper(name = "cases")
    @XmlElement(name = "case")
    private List<Case> cases;

    @Override
    public String toString() {
        return "LawFirm: " +
                "firmName = " + firmName +
                ", \noffices = " + offices +
                ", \ncases = " + cases;
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