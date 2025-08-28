/*
 * Copyright 2025 Walid Madad and uml2code Organization
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uml2code.generators.javaGenerator.utils;

import com.uml2code.model.classdiagram.UmlAttribute;
import com.uml2code.model.classdiagram.UmlClass;
import com.uml2code.model.classdiagram.UmlMethod;
import com.uml2code.model.classdiagram.UmlParameter;

public class JavaGeneratorHelper {
    /**
     * Generates the class or interface header.
     * @param umlClass The UML class to convert
     * @return The header code as a String
     */
    public static String generateClassHeader(UmlClass umlClass) {
        StringBuilder sb = new StringBuilder();
        sb.append("public ");
        if (umlClass.isAbstract()) sb.append("abstract ");  // Add 'abstract' if class is abstract
        if (umlClass.isInterface()) {
            sb.append("interface ");                         // Define as interface if applicable
        } else {
            sb.append("class ");                             // Otherwise, define as class
        }
        sb.append(umlClass.getName());   // Add class/interface name
        if(umlClass.getSuperClass() != null){
            sb.append(" extends ").append(umlClass.getSuperClass().getName());
        }
        if(umlClass.getInterfaces() != null){
            sb.append(" implements ");
            int counter = 0;
            for(UmlClass in: umlClass.getInterfaces()){
                if(counter != 0){
                    sb.append(", ").append(in.getName());
                }
                sb.append(in.getName());
                counter++;
            }
        }
        sb.append(" {\n\n");
        return sb.toString();
    }
    /**
     * Generates the class attributes.
     * @param umlClass The UML class containing attributes
     * @return The attributes code as a String
     */
    public static String generateAttributes(UmlClass umlClass) {
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
    public static String generateMethods(UmlClass umlClass) {
        StringBuilder sb = new StringBuilder();
        for (UmlMethod method : umlClass.getMethods()) {
            sb.append("\t")
                    .append(method.getVisibility())             // Visibility (public/private/protected)
                    .append(" ")
                    .append(method.getReturnType())             // Return type
                    .append(" ")
                    .append(method.getName());                  // Method name
            if(method.getParameters() == null){
                sb.append("() {}\n");      // Empty method body
            }else{
                sb.append("(");
                int counter = 0;
                for(UmlParameter parameter: method.getParameters()){
                    if(counter != 0){
                        sb.append(", ").append(parameter.getType()).append(" ").append(parameter.getName());
                    }
                    sb.append(parameter.getType()).append(" ").append(parameter.getName());
                    counter++;
                }
                sb.append("){\n\n\t}");
            }

        }
        return sb.toString();
    }

}
