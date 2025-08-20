package com.uml2code.backend.parsers.classdiagram;

import com.uml2code.backend.model.classdiagram.UmlClass;
import com.uml2code.backend.parsers.UmlParser;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PlantUmlClassParser implements UmlParser{
    /// TODO: Implement a PlantUML parser for class diagrams
    @Override
    public List<UmlClass> parse(File file) throws Exception {
        List<String> lines = Files.readAllLines(file.toPath());
        List<UmlClass> classes = new ArrayList<>();

        for(String line : lines){
            line = line.trim();
           if(Helpers.isClassDefinition(line)){
               UmlClass umlClass = new UmlClass();
               umlClass.setAbstract(Helpers.isAbstract(line));
               umlClass.setVisibility(Helpers.parseVisibility(line.charAt(0)));
               umlClass.setName(Helpers.getClassName(line));
               classes.add(umlClass);
           }

        }
        return classes;
    }
}