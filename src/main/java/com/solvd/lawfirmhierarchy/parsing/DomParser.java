package com.solvd.lawfirmhierarchy.parsing;

import com.solvd.lawfirmhierarchy.LawFirm;
import com.solvd.lawfirmhierarchy.MainClass;
import com.solvd.lawfirmhierarchy.cases.Case;
import com.solvd.lawfirmhierarchy.people.Client;
import com.solvd.lawfirmhierarchy.people.Lawyer;
import com.solvd.lawfirmhierarchy.structure.Equipment;
import com.solvd.lawfirmhierarchy.structure.Office;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parsable {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    @Override
    public LawFirm parse(File file) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try {
            doc = dbf.newDocumentBuilder().parse(file);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            LOGGER.info(e.getMessage());
        }

        LawFirm lawFirm = new LawFirm();

        //firm parsing
        Node firm = doc.getFirstChild();
        NodeList firmChildNodes = firm.getChildNodes();

        final String[] firmName = {null};
        final Node[] officeNode = {null};
        List<Office> offices = new ArrayList<>();
        final Node[] caseNode = {null};
        List<Case> cases = new ArrayList<>();

        List<Node> firmChildList;
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
                        case "case": {
                            caseNode[0] = node;
                            break;
                        }
                    }
                });

        lawFirm.setFirmName(firmName[0]);

        //office parsing
        NodeList officeChildNodes = officeNode[0].getChildNodes();
        Office office = new Office();
        final String[] city = {null};
        final Node[] lawyerNode = {null};
        List<Lawyer> lawyers = new ArrayList<>();

        final Node[] equipmentNode = {null};
        List<Equipment> equipments = new ArrayList<>();

        List<Node> officeChildList;
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

        //lawyer parsing
        NodeList lawyersNode = lawyerNode[0].getChildNodes();
        Lawyer lawyer = lawyerParse(lawyersNode);
        lawyers.add(lawyer);
        office.setLawyers(lawyers);

        //equipment parsing
        NodeList equipmentsNode = equipmentNode[0].getChildNodes();
        Equipment equipment = equipmentParse(equipmentsNode);
        equipments.add(equipment);
        office.setEquipment(equipments);
        offices.add(office);

        //case parsing
        NodeList caseChildNodes = caseNode[0].getChildNodes();
        Case firstCase = new Case();

        final String[] contractNumber = {null};
        final LocalDate[] dateOfConclusion = {null};
        final Node[] clientNode = {null};

        NamedNodeMap attributes = caseNode[0].getAttributes();
        contractNumber[0] = attributes.getNamedItem("contractnumber").getNodeValue();
        firstCase.setContractNumber(contractNumber[0]);

        List<Node> caseChildList;
        caseChildList = nodeListToList(caseChildNodes);

        caseChildList
                .forEach(node ->

                {
                    switch (node.getNodeName()) {
                        case "dateofconclusion": {
                            dateOfConclusion[0] = LocalDate.parse(node.getTextContent());
                            break;
                        }
                        case "client": {
                            clientNode[0] = node;
                            break;
                        }
                    }
                });
        firstCase.setDateOfConclusion(dateOfConclusion[0]);

        //client parsing
        NodeList clientsNode = clientNode[0].getChildNodes();
        Client client = clientParse(clientsNode);
        firstCase.setClient(client);
        cases.add(firstCase);
        lawFirm.setOffices(offices);
        lawFirm.setCases(cases);
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

    private Lawyer lawyerParse(NodeList lawyersNode) {
        List<Node> lawyersChildList;
        Lawyer lawyer = new Lawyer();

        final String[] firstName = {null};
        final String[] lastName = {null};
        final LocalDate[] dob = {null};
        final Integer[] experience = {null};
        List<Node> lawyersNodeList = nodeListToList(lawyersNode);

        for (Node item : lawyersNodeList) {
            if (item.getNodeType() != Node.ELEMENT_NODE) continue;
            if (item.getNodeName().equals("lawyer")) {
                NodeList lawyerChildNode = item.getChildNodes();
                lawyersChildList = nodeListToList(lawyerChildNode);
                lawyersChildList
                        .forEach(node -> {
                            switch (node.getNodeName()) {
                                case "firstname": {
                                    firstName[0] = node.getTextContent();
                                    lawyer.setFirstName(firstName[0]);
                                    break;
                                }
                                case "lastname": {
                                    lastName[0] = node.getTextContent();
                                    lawyer.setLastName(lastName[0]);
                                    break;
                                }
                                case "dob": {
                                    dob[0] = LocalDate.parse(node.getTextContent());
                                    lawyer.setDob(dob[0]);
                                    break;
                                }
                                case "experience": {
                                    experience[0] = Integer.valueOf(node.getTextContent());
                                    lawyer.setExperience(experience[0]);
                                    break;
                                }
                            }
                        });
            }
        }
        return lawyer;
    }

    private Equipment equipmentParse(NodeList equipmentsNode) {
        List<Node> equipmentsList = nodeListToList(equipmentsNode);
        List<Node> equipmentsChildList;
        Equipment equipment = new Equipment();
        String id;
        final String[] type = {null};
        final Integer[] number = {null};

        for (
                Node item : equipmentsList) {
            if (item.getNodeType() != Node.ELEMENT_NODE) continue;
            if (item.getNodeName().equals("equipment")) {
                NamedNodeMap attributes = item.getAttributes();
                id = attributes.getNamedItem("id").getNodeValue();
                equipment.setId(id);
                NodeList equipmentChildNode = item.getChildNodes();
                equipmentsChildList = nodeListToList(equipmentChildNode);
                equipmentsChildList.forEach(node -> {
                    switch (node.getNodeName()) {
                        case "type": {
                            type[0] = node.getTextContent();
                            equipment.setType(type[0]);
                            break;
                        }
                        case "number": {
                            number[0] = Integer.valueOf(node.getTextContent());
                            equipment.setNumber(number[0]);
                            break;
                        }
                    }
                });
            }
        }
        return equipment;
    }

    private Client clientParse(NodeList clientsNode) {
        Client client = new Client();
        List<Node> clientChildList;
        clientChildList = nodeListToList(clientsNode);

        final String[] clientName = {null};
        final String[] caseType = {null};
        final Node[] clientLawyerNode = {null};

        clientChildList.forEach(node ->
        {
            switch (node.getNodeName()) {
                case "lastname": {
                    clientName[0] = node.getTextContent();
                    client.setLastName(clientName[0]);
                    break;
                }
                case "casetype": {
                    caseType[0] = node.getTextContent();
                    client.setCaseType(caseType[0]);
                    break;
                }
                case "lawyer": {
                    clientLawyerNode[0] = node;
                    break;
                }
            }
        });
        NodeList clientLawyerChildNode = clientLawyerNode[0].getChildNodes();
        Lawyer clientLawyer = lawyerParse(clientLawyerChildNode);
        client.setLawyer(clientLawyer);
        return client;
    }
}
