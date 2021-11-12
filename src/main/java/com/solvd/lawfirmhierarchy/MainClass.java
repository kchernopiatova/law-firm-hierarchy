package com.solvd.lawfirmhierarchy;

import com.solvd.lawfirmhierarchy.parsing.DomParser;
import com.solvd.lawfirmhierarchy.parsing.JacksonParser;
import com.solvd.lawfirmhierarchy.parsing.JaxbParser;
import com.solvd.lawfirmhierarchy.parsing.Parsable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class MainClass {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) {

        File xmlFile = new File("src/main/resources/lawfirmdata.xml");
        File jsonFile = new File("src/main/resources/lawfirmdata.json");

        Parsable domParsing = new DomParser();
        LawFirm lawFirm = domParsing.parse(xmlFile);
        LOGGER.info(lawFirm);
        System.out.println();

        Parsable jaxbParsing = new JaxbParser();
        LawFirm lawFirmNew = jaxbParsing.parse(xmlFile);
        LOGGER.info(lawFirmNew);
        System.out.println();

        Parsable jacksonParser = new JacksonParser();
        LawFirm lawFirmJson = jacksonParser.parse(jsonFile);
        LOGGER.info(lawFirmJson);
    }
}
