package com.solvd.lawfirmhierarchy;

import com.solvd.lawfirmhierarchy.parsing.DocumentBuilding;
import com.solvd.lawfirmhierarchy.parsing.DomParsingImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;

public class MainClass {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) {

        Document doc = DocumentBuilding.buildDocument();

        DomParsingImpl domParsing = new DomParsingImpl();

        LawFirm lawFirm = domParsing.parse(doc);

        LOGGER.info(lawFirm);
    }
}
