package com.solvd.lawfirmhierarchy.parsing;

import com.solvd.lawfirmhierarchy.LawFirm;

import java.io.File;

public interface Parsable {
    LawFirm parse(File file);
}
