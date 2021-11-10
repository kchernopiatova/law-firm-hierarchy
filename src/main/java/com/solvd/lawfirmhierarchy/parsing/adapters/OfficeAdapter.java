package com.solvd.lawfirmhierarchy.parsing.adapters;

import com.solvd.lawfirmhierarchy.people.Lawyer;
import com.solvd.lawfirmhierarchy.structure.Equipment;
import com.solvd.lawfirmhierarchy.structure.Office;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.List;

public class OfficeAdapter extends XmlAdapter <OfficeAdapter.AdaptedOffice, Office> {

    @Override
    public OfficeAdapter.AdaptedOffice marshal(Office office)
            throws Exception {
        if (office == null) {
            return null;
        }
        AdaptedOffice adaptedOffice = new AdaptedOffice();
        adaptedOffice.city = office.getCity();
        adaptedOffice.lawyers = office.getLawyers();
        adaptedOffice.equipment = office.getEquipment();
        return adaptedOffice;
    }

    @Override
    public Office unmarshal(AdaptedOffice adaptedOffice)
            throws Exception {
        if (null == adaptedOffice) {
            return null;
        }
        Office office = new Office();
        office.setCity(adaptedOffice.city);
        office.setEquipment(adaptedOffice.equipment);
        office.setLawyers(adaptedOffice.lawyers);
        return office;
    }

    public static class AdaptedOffice {
        @XmlElement
        public String city;
        @XmlElement
        public List<Lawyer> lawyers;
        @XmlElement
        public List<Equipment> equipment;
    }
}
