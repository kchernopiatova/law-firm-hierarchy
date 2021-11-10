package com.solvd.lawfirmhierarchy.parsing.adapters;

import com.solvd.lawfirmhierarchy.cases.Case;
import com.solvd.lawfirmhierarchy.people.Client;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

public class CaseAdapter extends XmlAdapter<CaseAdapter.AdaptedCase, Case> {

    @Override
    public AdaptedCase marshal(Case firstCase)
            throws Exception {
        if (firstCase == null) {
            return null;
        }
        AdaptedCase adaptedCase = new AdaptedCase();
        adaptedCase.contactNumber = firstCase.getContractNumber();
        adaptedCase.dateOfConclusion = firstCase.getDateOfConclusion();
        adaptedCase.client = firstCase.getClient();
        return adaptedCase;
    }

    @Override
    public Case unmarshal(AdaptedCase adaptedCase)
            throws Exception {
        if (null == adaptedCase) {
            return null;
        }
        Case firstCase = new Case();
        firstCase.setContractNumber(adaptedCase.contactNumber);
        firstCase.setDateOfConclusion(adaptedCase.dateOfConclusion);
        firstCase.setClient(adaptedCase.client);
        return firstCase;
    }

    public static class AdaptedCase {
        @XmlAttribute
        public String contactNumber;
        @XmlElement
        public LocalDate dateOfConclusion;
        @XmlElement
        public Client client;
    }
}
