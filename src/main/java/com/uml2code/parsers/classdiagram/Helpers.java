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

package com.uml2code.parsers.classdiagram;

import com.uml2code.model.classdiagram.Visibility;

import java.util.HashMap;
import java.util.List;

public class Helpers {

    protected static boolean isClassDefinition(String line){
        return line.contains("class ");
    }

    protected static String getClassName(String line){
        String[] parts = line.split(" ");
        int nameIndex = 0;
        for(String part: parts){
            if(part.equals("class")){
                return parts[nameIndex + 1];
            }
            nameIndex++;
        }
        return null;
    }

    protected static String getInterfaceName(String line){
        String[] parts = line.split(" ");
        int nameIndex = 0;
        for(String part: parts){
            if(part.equals("interface")){
                return parts[nameIndex + 1];
            }
            nameIndex++;
        }
        return null;
    }

    protected static boolean isAbstract(String line){
        return line.contains("abstract");
    }

    protected static boolean isInterface(String line) {return line.contains("interface");}

    protected static boolean isClassEnd(String line){
        return line.contains("}");
    }

    protected static boolean isMethod(String line){
        return line.contains("(");
    }

    protected static String getMethodName(String line){
        String[] parts = line.split(" ");
        String name = "";
        for(String part: parts){
            if(part.contains("(")){
                name = part.substring(0, part.indexOf("("));
            }        
        }
        return name;
    }

    protected static HashMap<String, String> getParameters(String line){
        HashMap<String, String> parameters = new HashMap<>();
        int start = line.indexOf('(');
        int end = line.indexOf(')');
        String insideParentheses = line.substring(start + 1, end).trim();
        String[] parts = insideParentheses.split(",");
        for(String part : parts){
            String[] p = part.trim().split("\\s+");
            parameters.put(p[0], p[1]);
        }
        return parameters;
    }

    protected static String getReturnType(String line){
        if("+-#~".indexOf(line.charAt(0)) != -1){
            line = line.substring(1).trim();
        }
        String[] parts = line.split("\\s+");
        return parts[0];
    }

    protected static boolean isStatic(String line){
        return line.contains("static");
    }

    protected static boolean isAttribute(String line){
        return !line.contains("(") && line.split("\\s+").length >= 2;
    }

    protected static String getAttributeType(String line){
        if("+-#~".indexOf(line.charAt(0)) != -1){
            line = line.substring(1).trim();
        }
        String[] parts = line.split("\\s+");
        return parts[0];
    }

    protected static String getAttributeName(String line){
        if("+-#~".indexOf(line.charAt(0)) != -1){
            line = line.substring(1).trim();
        }
        String[] parts = line.split("\\s+");
        return parts[1];
    }

    protected static String getAttributeDefaultValue(String line){
        if("+-#~".indexOf(line.charAt(0)) != -1){
            line = line.substring(1).trim();
        }
        int equalsIndex = line.indexOf('=');
        return line.substring(equalsIndex + 1).trim();
    }

    protected static Visibility parseVisibility(char visibility){
        return switch (visibility){
            case '+' -> Visibility.PUBLIC;
            case '-' -> Visibility.PRIVATE;
            case '#' -> Visibility.PROTECTED;
            default -> Visibility.PACKAGE_PRIVATE;
        };
    }

    protected static boolean isInheritance(String line){
        return line.contains("<|--");
    }

    protected static boolean isImplements(String line){
        return line.contains("<|..");
    }

    protected static boolean isAssociation(String line){
        return line.contains("-->");
    }

    protected static boolean isAggregation(String line){
        return line.contains("o--");
    }

    protected static boolean isComposition(String line){
        return line.contains("*--");
    }
    protected static boolean isDependency(String line){
        return line.contains("..>");
    }

}
