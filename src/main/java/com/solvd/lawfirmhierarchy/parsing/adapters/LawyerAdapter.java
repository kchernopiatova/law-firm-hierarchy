package com.solvd.lawfirmhierarchy.parsing.adapters;

import com.solvd.lawfirmhierarchy.people.Lawyer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

public class LawyerAdapter extends XmlAdapter<LawyerAdapter.AdaptedLawyer, Lawyer> {

    @Override
    public AdaptedLawyer marshal(Lawyer lawyer)
            throws Exception {
        if (lawyer == null) {
            return null;
        }
        AdaptedLawyer adaptedLawyer = new AdaptedLawyer();
        adaptedLawyer.firstName = lawyer.getFirstName();
        adaptedLawyer.lastName = lawyer.getLastName();
        adaptedLawyer.dob = lawyer.getDob();
        adaptedLawyer.experience = lawyer.getExperience();
        return adaptedLawyer;
    }

    @Override
    public Lawyer unmarshal(AdaptedLawyer adaptedLawyer)
            throws Exception {
        if (null == adaptedLawyer) {
            return null;
        }
        Lawyer lawyer = new Lawyer();
        lawyer.setFirstName(adaptedLawyer.firstName);
        lawyer.setLastName(adaptedLawyer.lastName);
        lawyer.setDob(adaptedLawyer.dob);
        lawyer.setExperience(adaptedLawyer.experience);
        return lawyer;
    }

    public static class AdaptedLawyer {
        @XmlElement
        public String firstName;
        @XmlElement
        public String lastName;
        @XmlElement
        public LocalDate dob;
        @XmlElement
        public Integer experience;
    }
}
