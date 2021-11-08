package com.solvd.lawfirmhierarchy.parsing;

import com.solvd.lawfirmhierarchy.LawFirm;
import com.solvd.lawfirmhierarchy.cases.Case;
import com.solvd.lawfirmhierarchy.structure.Office;
import org.w3c.dom.Document;

public interface Parsable {
    public LawFirm parse(Document doc);
}
