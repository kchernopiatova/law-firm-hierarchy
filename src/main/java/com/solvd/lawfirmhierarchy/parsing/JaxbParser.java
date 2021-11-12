package com.solvd.lawfirmhierarchy.parsing;

import com.solvd.lawfirmhierarchy.LawFirm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbParser implements Parsable {

    private static final Logger LOGGER = LogManager.getLogger(JaxbParser.class);

    @Override
    public LawFirm parse(File file) {

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
