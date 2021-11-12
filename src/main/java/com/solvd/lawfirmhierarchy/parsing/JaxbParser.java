package com.solvd.lawfirmhierarchy.parsing;

import com.solvd.lawfirmhierarchy.LawFirm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class JaxbParser implements Parsable {

    private static final Logger LOGGER = LogManager.getLogger(JaxbParser.class);

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
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(LawFirm.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();

            lawFirm = (LawFirm) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return lawFirm;
    }
}
