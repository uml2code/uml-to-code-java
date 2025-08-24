package com.uml2code.generators.javaGenerator.classDiagrammGenerator;

import com.uml2code.model.classdiagram.UmlAttribute;
import com.uml2code.model.classdiagram.UmlClass;
import com.uml2code.model.classdiagram.UmlMethod;

public class JavaUtils {
    /**
     * Generates the class or interface header.
     * @param umlClass The UML class to convert
     * @return The header code as a String
     */
    protected static String generateClassHeader(UmlClass umlClass) {
        StringBuilder sb = new StringBuilder();
        sb.append("public ");
        if (umlClass.isAbstract()) sb.append("abstract ");  // Add 'abstract' if class is abstract
        if (umlClass.isInterface()) {
            sb.append("interface ");                         // Define as interface if applicable
        } else {
            sb.append("class ");                             // Otherwise, define as class
        }
        sb.append(umlClass.getName()).append(" {\n\n");     // Add class/interface name
        return sb.toString();
    }
    /**
     * Generates the class attributes.
     * @param umlClass The UML class containing attributes
     * @return The attributes code as a String
     */
    protected static String generateAttributes(UmlClass umlClass) {
        StringBuilder sb = new StringBuilder();
        for (UmlAttribute attr : umlClass.getAttributes()) {
            sb.append("    ")
                    .append(attr.getVisibility())               // Visibility (public/private/protected)
                    .append(" ")
                    .append(attr.getType())                     // Attribute type
                    .append(" ")
                    .append(attr.getName());                    // Attribute name

            if (attr.getDefaultValue() != null) {
                sb.append(" = ").append(attr.getDefaultValue()); // Add default value if present
            }
            sb.append(";\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    /**
     * Generates the class methods.
     * @param umlClass The UML class containing methods
     * @return The methods code as a String
     */
    protected static String generateMethods(UmlClass umlClass) {
        StringBuilder sb = new StringBuilder();
        for (UmlMethod method : umlClass.getMethods()) {
            sb.append("    ")
                    .append(method.getVisibility())             // Visibility (public/private/protected)
                    .append(" ")
                    .append(method.getReturnType())            // Return type
                    .append(" ")
                    .append(method.getName())                  // Method name
                    .append("() {}\n");                         // Empty method body
        }
        return sb.toString();
    }

}
