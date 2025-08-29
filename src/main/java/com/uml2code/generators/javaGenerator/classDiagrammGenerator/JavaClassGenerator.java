package com.uml2code.generators.javaGenerator.classDiagrammGenerator;

import com.uml2code.generators.CodeGenerator;
import com.uml2code.generators.javaGenerator.utils.JavaGeneratorHelper;
import com.uml2code.model.classdiagram.UmlClass;


public class JavaClassGenerator implements CodeGenerator {
    @Override
    public String generate(UmlClass umlClass){
        StringBuilder sb = new StringBuilder();
        sb.append(JavaGeneratorHelper.generateClassHeader(umlClass));
        sb.append(JavaGeneratorHelper.generateAttributes(umlClass));
        sb.append(JavaGeneratorHelper.generateMethods(umlClass));
        sb.append("\n}");

        return sb.toString();
    }
    /// TODO : generate java file
    @Override
    public void generateToFile(UmlClass umlClass, String outputDir) {
        return;
    }
}
