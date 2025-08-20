package com.uml2code.backend.parsers;

import com.uml2code.backend.model.classdiagram.UmlClass;
import java.util.List;
import java.io.File;

public interface UmlParser{
    List<UmlClass> parse(File file) throws Exception;
}