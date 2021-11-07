package com.solvd.lawfirmhierarchy;

import com.solvd.lawfirmhierarchy.cases.Case;
import com.solvd.lawfirmhierarchy.parsing.DocumentBuilding;
import com.solvd.lawfirmhierarchy.parsing.OfficeParsing;
import com.solvd.lawfirmhierarchy.structure.Office;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;

public class MainClass {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) {

        Document doc = DocumentBuilding.buildDocument();

        Office firstOffice = new Office();
        Case firstCase = new Case();

        OfficeParsing officeParsing = new OfficeParsing();
        officeParsing.officeParse(firstOffice,doc);


        System.out.println(firstOffice);
    }
}
