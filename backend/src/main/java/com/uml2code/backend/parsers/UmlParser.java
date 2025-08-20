package com.uml2code.backend.parsers;

import com.uml2code.backend.model.class.UmlClass;
import java.util.List;
import java.io.File;

public interafce UmlParser{
    List<UmlClass> parse(File file) throws Exception;
}