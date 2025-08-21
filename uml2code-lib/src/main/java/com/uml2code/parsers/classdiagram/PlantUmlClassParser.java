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

import com.uml2code.model.classdiagram.UmlClass;
import com.uml2code.parsers.UmlParser;

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