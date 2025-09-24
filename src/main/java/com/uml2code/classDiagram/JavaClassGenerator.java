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

package com.uml2code.classDiagram;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class JavaClassGenerator {
    private static String generate(UmlClass umlClass){
        StringBuilder sb = new StringBuilder();
        sb.append(JavaGeneratorHelper.generateClassHeader(umlClass));
        sb.append(JavaGeneratorHelper.generateAttributes(umlClass));
        sb.append(JavaGeneratorHelper.generateMethods(umlClass));
        sb.append("\n}");

        return sb.toString();
    }

    protected static void generateToJavaFile(UmlClass umlClass, String path) {
        try{
            File dir = new File(path);
            if (!dir.exists() && !dir.mkdirs()) {
                throw new RuntimeException("Impossible de créer le répertoire : " + path);
            }
            File javaFile = new File(dir, umlClass.getName() + ".java");
            FileWriter fileWriter = new FileWriter(javaFile);
            fileWriter.append(generate(umlClass));
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
