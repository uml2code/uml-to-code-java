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
     * Generates the header declaration for a Java class or interface
     * based on the provided {@link UmlClass}.
     * <p>
     * The generated header includes:
     * <ul>
     *     <li>{@code public} keyword (always present)</li>
     *     <li>{@code abstract} keyword if the UML class is abstract</li>
     *     <li>{@code class} or {@code interface} keyword depending on the type</li>
     *     <li>The class or interface name</li>
     *     <li>{@code extends} clause if a superclass is defined</li>
     *     <li>{@code implements} clause if one or more interfaces are defined</li>
     * </ul>
     * The resulting header always ends with an opening curly brace
     * followed by a newline character.
     * </p>
     *
     * @param umlClass the UML class definition to convert into a Java class or interface header;
     *                 must not be {@code null}
     * @return the generated class or interface header as a non-null {@link String}
     */
    public static String generateClassHeader(UmlClass umlClass) {
        StringBuilder sb = new StringBuilder();
        sb.append(JavaKeywords.PUBLIC).append(JavaKeywords.SPACE);
        if (umlClass.isAbstract()) sb.append(JavaKeywords.ABSTRACT).append(JavaKeywords.SPACE);
        if (umlClass.isInterface()) {
            sb.append(JavaKeywords.INTERFACE).append(JavaKeywords.SPACE);
        } else {
            sb.append(JavaKeywords.CLASS).append(JavaKeywords.SPACE);
        }
        sb.append(umlClass.getName());
        if(umlClass.getSuperClass() != null){
            sb.append(JavaKeywords.SPACE)
                    .append(JavaKeywords.EXTENDS)
                    .append(JavaKeywords.SPACE)
                    .append(umlClass.getSuperClass().getName());
        }
        if(umlClass.getInterfaces() != null){
            sb.append(JavaKeywords.SPACE)
                    .append(JavaKeywords.IMPLEMENTS)
                    .append(JavaKeywords.SPACE);
            int counter = 0;
            for(UmlClass in: umlClass.getInterfaces()){
                if(counter != 0){
                    sb.append(JavaKeywords.COMMA)
                            .append(JavaKeywords.SPACE)
                            .append(in.getName());
                }
                sb.append(in.getName());
                counter++;
            }
        }
        sb.append(JavaKeywords.SPACE)
                .append(JavaKeywords.LEFT_BRACE)
                .append(JavaKeywords.NEWLINE);
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
            sb.append("\t")
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
