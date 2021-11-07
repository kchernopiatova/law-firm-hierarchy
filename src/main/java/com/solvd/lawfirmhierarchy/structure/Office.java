package com.solvd.lawfirmhierarchy.structure;

import com.solvd.lawfirmhierarchy.people.Lawyer;

import java.util.List;

public class Office {

    private String city;
    private List<Lawyer> lawyers;
    private List<Equipment> equipment;

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
}
