package com.solvd.lawfirmhierarchy.parsing.adapters;

import com.solvd.lawfirmhierarchy.structure.Equipment;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class EquipmentAdapter extends XmlAdapter<EquipmentAdapter.AdaptedEquipment, Equipment> {

    @Override
    public AdaptedEquipment marshal(Equipment equipment)
            throws Exception {
        if (equipment == null) {
            return null;
        }
        AdaptedEquipment adaptedEquipment = new AdaptedEquipment();
        adaptedEquipment.id = equipment.getId();
        adaptedEquipment.type = equipment.getType();
        adaptedEquipment.number = equipment.getNumber();
        return adaptedEquipment;
    }

    @Override
    public Equipment unmarshal(AdaptedEquipment adaptedEquipment)
            throws Exception {
        if (null == adaptedEquipment) {
            return null;
        }
        Equipment equipment = new Equipment();
        equipment.setId(adaptedEquipment.id);
        equipment.setNumber(adaptedEquipment.number);
        equipment.setType(adaptedEquipment.type);
        return equipment;
    }

    public static class AdaptedEquipment {
        @XmlAttribute
        public String id;
        @XmlElement
        public String type;
        @XmlElement
        public Integer number;
    }
}
