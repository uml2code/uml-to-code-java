package com.uml2code.backend.parsers.classdiagram;

import com.uml2code.backend.model.classdiagram.Visibility;

public class Helpers {

    // Class Helpers
    protected static boolean isClassDefinition(String line){
        return line.startsWith("class ");
    }

    protected static String getClassName(String line){
        String[] parts = line.split(" ");
        return parts[parts.length - 1];
    }

    protected static boolean isAbstract(String line){
        return line.contains("abstract");
    }

    protected static boolean isClassEnd(String line){
        return line.contains("}";
    }

    // Method Helpers
    protected static boolean isMethod(String line){
        return line.contains("(");
    }

    protected static String getMethodName(String line){
        String[] parts = line.split(" ");
        String name = "";
        for(String part: parts){
            if(part.contains(":")){
                name = part.substring(0, part.indexOf(":");
            }        
        }
        return name;
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
