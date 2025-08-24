package com.uml2code.generators;

import com.uml2code.model.classdiagram.UmlClass;

public interface CodeGenerator {
    String generate(UmlClass umlClass);
    void generateToFile(UmlClass umlClass, String outputDir);
}
