package com.solvd.lawfirmhierarchy.structure;

import com.solvd.lawfirmhierarchy.people.Lawyer;

import java.util.List;

public class Office {

    private String city;
    private List<Lawyer> lawyers;
    private List<Equipment> equipment;

    @Override
    public String toString() {
        return "Office{" +
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
