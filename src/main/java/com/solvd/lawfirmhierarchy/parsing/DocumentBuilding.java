package com.solvd.lawfirmhierarchy.parsing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DocumentBuilding {

    private static final Logger LOGGER = LogManager.getLogger(DocumentBuilding.class);

    public static Document buildDocument() {
        File file = new File("src/main/resources/lawfirmdata.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try {
            doc = dbf.newDocumentBuilder().parse(file);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            LOGGER.info(e.getMessage());
        }
        return doc;
    }
}
