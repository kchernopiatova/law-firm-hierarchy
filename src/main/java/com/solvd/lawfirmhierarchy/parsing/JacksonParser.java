package com.solvd.lawfirmhierarchy.parsing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.lawfirmhierarchy.LawFirm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class JacksonParser implements Parsable{

    private static final Logger LOGGER = LogManager.getLogger(JacksonParser.class);

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
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            lawFirm = objectMapper.readValue(file, LawFirm.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lawFirm;
    }
}
