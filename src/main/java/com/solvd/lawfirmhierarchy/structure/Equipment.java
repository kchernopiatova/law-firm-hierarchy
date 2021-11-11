package com.solvd.lawfirmhierarchy.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Equipment {

    @XmlAttribute(name = "id")
    private String id;
    private String type;
    private Integer number;

    public Equipment(String id, String type, Integer number) {
        this.id = id;
        this.type = type;
        this.number = number;
    }

    public Equipment() {

    }

    @Override
    public String toString() {
        return "\nEquipment: " +
                "id = " + id +
                ", type = " + type +
                ", number = " + number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}