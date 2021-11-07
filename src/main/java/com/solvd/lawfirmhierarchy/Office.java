package com.solvd.lawfirmhierarchy;

import java.util.Set;

public class Office {

    private String city;
    private Set<Lawyer> lawyers;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Lawyer> getLawyers() {
        return lawyers;
    }

    public void setLawyers(Set<Lawyer> lawyers) {
        this.lawyers = lawyers;
    }
}
