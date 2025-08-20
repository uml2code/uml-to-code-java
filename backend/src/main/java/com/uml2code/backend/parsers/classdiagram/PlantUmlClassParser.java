package com.uml2code.backend.parsers.classdiagram;

import com.uml2code.backend.model.classdiagram.UmlClass;
import com.uml2code.backend.model.classdiagram.Visibility;
import com.uml2code.backend.parsers.UmlParser;

import java.io.File;
import java.util.List;

public class PlantUmlClassParser implements UmlParser{
    /// TODO: Implement a PlantUML parser for class diagrams
    public List<UmlClass> parse(File file) throws Exception {
        return null;
    }

    /** TODO: implement Visibility parser
     * + -> public
     * - -> private
     * # -> protected
     */ 
    private Visibility parseVisibility(char visibility){
        return null;
    }
}