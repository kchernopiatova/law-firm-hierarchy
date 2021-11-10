package com.solvd.lawfirmhierarchy;

import com.solvd.lawfirmhierarchy.cases.Case;
import com.solvd.lawfirmhierarchy.parsing.adapters.CaseAdapter;
import com.solvd.lawfirmhierarchy.parsing.adapters.OfficeAdapter;
import com.solvd.lawfirmhierarchy.structure.Office;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "lawfirm")
public class LawFirm {

    @XmlElement(name = "firmname")
    private String firmName;
    @XmlJavaTypeAdapter(OfficeAdapter.class)
    @XmlElement(name = "office")
    private List<Office> offices;
    @XmlJavaTypeAdapter(CaseAdapter.class)
    private List<Case> cases;

    @Override
    public String toString() {
        return "\nLawFirm{" +
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
