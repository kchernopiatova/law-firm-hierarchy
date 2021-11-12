package com.solvd.lawfirmhierarchy.parsing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.lawfirmhierarchy.LawFirm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;

public class JacksonParser implements Parsable{

    private static final Logger LOGGER = LogManager.getLogger(JacksonParser.class);

    @Override
    public LawFirm parse(File file) {

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
