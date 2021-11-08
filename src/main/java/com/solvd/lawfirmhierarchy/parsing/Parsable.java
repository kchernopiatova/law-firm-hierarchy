package com.solvd.lawfirmhierarchy.parsing;

import com.solvd.lawfirmhierarchy.LawFirm;
import org.w3c.dom.Document;

public interface Parsable {
    LawFirm parse(Document doc);
}
