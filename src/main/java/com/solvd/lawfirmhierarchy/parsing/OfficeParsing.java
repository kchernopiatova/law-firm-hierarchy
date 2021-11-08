package com.solvd.lawfirmhierarchy.parsing;

import com.solvd.lawfirmhierarchy.people.Lawyer;
import com.solvd.lawfirmhierarchy.structure.Equipment;
import com.solvd.lawfirmhierarchy.structure.Office;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OfficeParsing {

    public void officeParse(Office firstOffice, Document doc) {
        NodeList office = doc.getElementsByTagName("office");
        Node rootNode = office.item(0);
        NodeList rootChilds = rootNode.getChildNodes();

        String city = null;
        Node lawyerNode = null;
        Node equipmentNode = null;

        for (int i = 0; i < rootChilds.getLength(); i++) {
            if (rootChilds.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String nodeName = rootChilds.item(i).getNodeName();
                switch (nodeName) {
                    case "city": {
                        city = rootChilds.item(i).getTextContent();
                        break;
                    }
                    case "lawyers": {
                        lawyerNode = rootChilds.item(i);
                        break;
                    }
                    case "equipments": {
                        equipmentNode = rootChilds.item(i);
                        break;
                    }
                }
            }
        }
        firstOffice.setCity(city);

        NodeList lawyersNode = lawyerNode.getChildNodes();
        List<Lawyer> lawyers = new ArrayList<>();

        for (int i = 0; i < lawyersNode.getLength(); i++) {
            String firstName = null;
            String lastName = null;
            LocalDate dob = null;
            Integer experience = null;

            if (lawyersNode.item(i).getNodeType() != Node.ELEMENT_NODE) continue;
            if (lawyersNode.item(i).getNodeName().equals("lawyer")) {
                NodeList lawyerChilds = lawyersNode.item(i).getChildNodes();
                for (int j = 0; j < lawyerChilds.getLength(); j++) {
                    if (lawyersNode.item(i).getNodeType() != Node.ELEMENT_NODE) continue;
                    switch (lawyerChilds.item(j).getNodeName()) {
                        case "firstname": {
                            firstName = lawyerChilds.item(j).getTextContent();
                            break;
                        }
                        case "lastname": {
                            lastName = lawyerChilds.item(j).getTextContent();
                            break;
                        }
                        case "dob": {
                            dob = LocalDate.parse(lawyerChilds.item(j).getTextContent());
                            break;
                        }
                        case "experience": {
                            experience = Integer.valueOf(lawyerChilds.item(j).getTextContent());
                            break;
                        }
                    }
                }
                Lawyer lawyer = new Lawyer(firstName, lastName, dob, experience);
                lawyers.add(lawyer);
            }
        }
        firstOffice.setLawyers(lawyers);

        NodeList equipmentsNode = equipmentNode.getChildNodes();
        List<Equipment> equipments = new ArrayList<>();

        for (int i = 0; i < equipmentsNode.getLength(); i++) {
            String id = null;
            String type = null;
            Integer number = null;
            if (equipmentsNode.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (equipmentsNode.item(i).getNodeName().equals("equipment")) {
                NamedNodeMap attributes = equipmentsNode.item(i).getAttributes();
                id = attributes.getNamedItem("id").getNodeValue();
                NodeList equipmentChilds = equipmentsNode.item(i).getChildNodes();
                for (int j = 0; j < equipmentChilds.getLength(); j++) {
                    if (equipmentsNode.item(i).getNodeType() != Node.ELEMENT_NODE) {
                        continue;
                    }
                    switch (equipmentChilds.item(j).getNodeName()) {
                        case "type": {
                            type = equipmentChilds.item(j).getTextContent();
                            break;
                        }
                        case "number": {
                            number = Integer.valueOf(equipmentChilds.item(j).getTextContent());
                            break;
                        }
                    }
                }
                Equipment equipment = new Equipment(id, type, number);
                equipments.add(equipment);
            }
        }
        firstOffice.setEquipment(equipments);
    }
}
