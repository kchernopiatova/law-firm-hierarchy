package com.solvd.lawfirmhierarchy.parsing;

import com.solvd.lawfirmhierarchy.LawFirm;
import com.solvd.lawfirmhierarchy.cases.Case;
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

public class DomParsingImpl implements Parsable {

    @Override
    public LawFirm parse(Document doc) {

        LawFirm lawFirm = new LawFirm();

        Node firm = doc.getFirstChild();
        NodeList firmChildNodes = firm.getChildNodes();

        final String[] firmName = {null};
        final Node[] officeNode = {null};
        List<Office> offices = new ArrayList<>();
        final Node[] caseNode = {null};
        List<Case> cases = new ArrayList<>();

        List<Node> firmChildList = new ArrayList<>();
        firmChildList = nodeListToList(firmChildNodes);

        firmChildList
                .forEach(node -> {
                    switch (node.getNodeName()) {
                        case "firmname": {
                            firmName[0] = node.getTextContent();
                            break;
                        }
                        case "office": {
                            officeNode[0] = node;
                            break;
                        }
                        case "cases": {
                            caseNode[0] = node;
                            break;
                        }
                    }
                });

        lawFirm.setFirmName(firmName[0]);
        NodeList officeChildNodes = officeNode[0].getChildNodes();

        Office office = new Office();
        final String[] city = {null};
        final Node[] lawyerNode = {null};
        List<Lawyer> lawyers = new ArrayList<>();

        final Node[] equipmentNode = {null};
        List<Equipment> equipments = new ArrayList<>();

        List<Node> officeChildList = new ArrayList<>();
        officeChildList = nodeListToList(officeChildNodes);

        officeChildList
                .forEach(node -> {
                    switch (node.getNodeName()) {
                        case "city": {
                            city[0] = node.getTextContent();
                            break;
                        }
                        case "lawyers": {
                            lawyerNode[0] = node;
                            break;
                        }
                        case "equipments": {
                            equipmentNode[0] = node;
                            break;
                        }
                    }
                });
        office.setCity(city[0]);

        NodeList lawyersNode = lawyerNode[0].getChildNodes();
        List<Node> lawyersChildList = new ArrayList<>();

        final String[] firstName = {null};
        final String[] lastName = {null};
        final LocalDate[] dob = {null};
        final Integer[] experience = {null};

        for (int i = 0; i < lawyersNode.getLength(); i++) {
            if (lawyersNode.item(i).getNodeType() != Node.ELEMENT_NODE) continue;
            if (lawyersNode.item(i).getNodeName().equals("lawyer")) {
                NodeList lawyerChildNode = lawyersNode.item(i).getChildNodes();
                lawyersChildList = nodeListToList(lawyerChildNode);
                lawyersChildList
                        .forEach(node -> {
                            switch (node.getNodeName()) {
                                case "firstname": {
                                    firstName[0] = node.getTextContent();
                                    break;
                                }
                                case "lastname": {
                                    lastName[0] = node.getTextContent();
                                    break;
                                }
                                case "dob": {
                                    dob[0] = LocalDate.parse(node.getTextContent());
                                    break;
                                }
                                case "experience": {
                                    experience[0] = Integer.valueOf(node.getTextContent());
                                    break;
                                }
                            }
                        });
                Lawyer lawyer = new Lawyer(firstName[0], lastName[0], dob[0], experience[0]);
                lawyers.add(lawyer);
            }
        }
        office.setLawyers(lawyers);

        NodeList equipmentsNode = equipmentNode[0].getChildNodes();
        List<Node> equipmentsChildList = new ArrayList<>();

        String id = null;
        final String[] type = {null};
        final Integer[] number = {null};

        for (int i = 0; i < equipmentsNode.getLength(); i++) {
            if (equipmentsNode.item(i).getNodeType() != Node.ELEMENT_NODE) continue;
            if (equipmentsNode.item(i).getNodeName().equals("equipment")) {
                NamedNodeMap attributes = equipmentsNode.item(i).getAttributes();
                id = attributes.getNamedItem("id").getNodeValue();
                NodeList equipmentChildNode = equipmentsNode.item(i).getChildNodes();
                equipmentsChildList = nodeListToList(equipmentChildNode);
                equipmentsChildList.forEach(node -> {
                    switch (node.getNodeName()) {
                        case "type": {
                            type[0] = node.getTextContent();
                            break;
                        }
                        case "number": {
                            number[0] = Integer.valueOf(node.getTextContent());
                            break;
                        }
                    }
                });
                Equipment equipment = new Equipment(id, type[0], number[0]);
                equipments.add(equipment);
            }
        }
        office.setEquipment(equipments);
        offices.add(office);
        lawFirm.setOffices(offices);
        return lawFirm;
    }

    public static List<Node> nodeListToList(NodeList nodeList) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                nodes.add(nodeList.item(i));
            }
        }
        return nodes;
    }
}
