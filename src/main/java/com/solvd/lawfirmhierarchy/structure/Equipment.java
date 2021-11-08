package com.solvd.lawfirmhierarchy.structure;

public class Equipment {

    private String id;
    private String type;
    private Integer number;

    public Equipment(String id, String type, Integer number) {
        this.id = id;
        this.type = type;
        this.number = number;
    }

    @Override
    public String toString() {
        return "\nEquipment{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", number=" + number +
                '}';
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
