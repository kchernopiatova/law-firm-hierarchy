package com.solvd.lawfirmhierarchy.structure;

import com.solvd.lawfirmhierarchy.parsing.adapters.EquipmentAdapter;
import com.solvd.lawfirmhierarchy.parsing.adapters.LawyerAdapter;
import com.solvd.lawfirmhierarchy.people.Lawyer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Office {

    private String city;
    @XmlElementWrapper(name = "lawyers")
    @XmlJavaTypeAdapter(LawyerAdapter.class)
    private List<Lawyer> lawyers;
    @XmlElementWrapper(name = "equipments")
    @XmlJavaTypeAdapter(EquipmentAdapter.class)
    private List<Equipment> equipment;

    @Override
    public String toString() {
        return "\nOffice{" +
                "city='" + city + '\'' +
                ", lawyers=" + lawyers +
                ", equipment=" + equipment +
                '}';
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
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }
}
