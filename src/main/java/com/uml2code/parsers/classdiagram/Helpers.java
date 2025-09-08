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
        return line.trim().equals("}") || (!line.contains("{") && (isClassDefinition(line) || isInterface(line)));
    }

    protected static boolean isMethod(String line){
        return line.contains("(");
    }

    protected static String getMethodName(String line){
        if("+-#~".indexOf(line.charAt(0)) != -1){
            line = line.substring(1).trim();
        }

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
        if(insideParentheses.isEmpty()){
            return parameters;
        }
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
        if(line.contains(":")){
            return parts[1];
        }
        return parts[0];
    }

    protected static boolean isStatic(String line){
        return line.contains("static");
    }

    protected static boolean isAttribute(String line){
        return !isClassDefinition(line)
                && !isInterface(line)
                && !isDocumentation(line)
                && !isMethod(line)
                && !isImplements(line)
                && !isInheritance(line)
                && line.split("\\s+").length >= 2;
    }

    protected static String getAttributeType(String line){
        if("+-#~".indexOf(line.charAt(0)) != -1){
            line = line.substring(1).trim();
        }
        if (line.contains(":")) {
            String afterColon = line.substring(line.indexOf(":") + 1).trim();

            if (afterColon.contains("=")) {
                afterColon = afterColon.substring(0, afterColon.indexOf("=")).trim();
            }
            return afterColon;
        }

        String[] parts = line.trim().split("\\s+");
        if (parts.length >= 2) {
            return parts[0];
        }

        return "";
    }

    protected static String getAttributeName(String line){
        if("+-#~".indexOf(line.charAt(0)) != -1){
            line = line.substring(1).trim();
        }
        if(!line.contains(":")){
            String[] parts = line.trim().split("\\s+");
            return parts[parts.length - 1];
        }
        return line.substring(0, line.indexOf(":")).trim();
    }

    protected static String getAttributeDefaultValue(String line){
        if(!line.contains("=")) return null;
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
        return (line.trim().contains("<|--") || line.trim().contains("extends") || line.trim().contains("--|>"));
    }

    protected static boolean isImplements(String line){
        return line.trim().contains("<|..") || line.trim().contains("implements") || line.trim().contains("..|>");
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

    protected static boolean isDocumentation(String line){
        return ("'".indexOf(line.charAt(0)) != -1);
    }

    protected static String getChildClassName(String line){
        String[] parts = line.split(" ");
        int nameIndex = 0;
        for(String part: parts){
            if(part.equals("<|--")){
                return parts[nameIndex + 1];
            }else if(part.equals("extends") || part.equals("--|>")){
                return parts[nameIndex - 1];
            }
            nameIndex++;
        }
        return null;
    }
    protected static String getParentClassName(String line){
        String[] parts = line.split(" ");
        int nameIndex = 0;
        for(String part: parts){
            if(part.equals("<|--")){
                return parts[nameIndex - 1];
            }
            else if(part.equals("extends") || part.equals("--|>")){
                return parts[nameIndex + 1];
            }
            nameIndex++;
        }
        return null;
    }

    protected static String getInterfaceImplementName(String line){
        String[] parts = line.split(" ");
        int nameIndex = 0;
        for(String part: parts){
            if(part.equals("..|>") || part.equals("implements")){
                return parts[nameIndex + 1];
            }else if(part.equals("<|..")){
                return parts[nameIndex - 1];
            }
            nameIndex++;
        }
        return null;
    }

    protected static String getClassImplementName(String line){
        String[] parts = line.split(" ");
        int nameIndex = 0;
        for(String part: parts){
            if(part.equals("..|>") || part.equals("implements")){
                return parts[nameIndex - 1];
            }else if(part.equals("<|..")){
                return parts[nameIndex + 1];
            }
            nameIndex++;
        }
        return null;
    }

}
