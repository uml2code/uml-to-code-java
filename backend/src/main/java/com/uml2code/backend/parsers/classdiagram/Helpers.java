package com.uml2code.backend.parsers.classdiagram;

import com.uml2code.backend.model.classdiagram.Visibility;

public class Helpers {

    protected static boolean isClassDefinition(String line){
        return line.startsWith("class ");
    }

    protected static String getClassName(String line){
        String[] parts = line.split(" ");;
        return parts[parts.length - 1];
    }

    protected static boolean isAbstract(String line){
        return line.contains("abstract");
    }

    protected static boolean isMethod(String line){
        return line.contains("(");
    }

    protected static boolean isClassEnd(String line){
        return line.contains("}";
    }

    protected static Visibility parseVisibility(char visibility){
        return switch (visibility){
            case '+' -> Visibility.PUBLIC;
            case '-' -> Visibility.PRIVATE;
            case '#' -> Visibility.PROTECTED;
            default -> Visibility.PACKAGE_PRIVATE;
        };
    }
}
