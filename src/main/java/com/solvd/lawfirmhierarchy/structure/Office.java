package com.solvd.lawfirmhierarchy.structure;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.lawfirmhierarchy.people.Lawyer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Office {

    private String city;

    @XmlElementWrapper(name = "lawyers")
    @XmlElement(name = "lawyer")
    private List<Lawyer> lawyers;

    @XmlElementWrapper(name = "equipments")
    @XmlElement(name = "equipment")
    @JsonProperty("equipments")
    private List<Equipment> equipments;

    @Override
    public String toString() {
        return "\nOffice: " +
                "city = " + city +
                ", lawyers = " + lawyers +
                ", equipment = " + equipments;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Lawyer> getLawyers() {
        return lawyers;
    }

    public void setLawyers(List<Lawyer> lawyers) {
        this.lawyers = lawyers;
    }

    public List<Equipment> getEquipment() {
        return equipments;
    }

    public void setEquipment(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}