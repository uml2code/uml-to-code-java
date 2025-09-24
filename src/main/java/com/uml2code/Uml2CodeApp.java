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

package com.uml2code;


import com.uml2code.classDiagram.JavaGenerator;

import java.io.File;
import java.net.URL;

public class Uml2CodeApp {
    public static void main(String[] args) throws Exception {
        URL resource = Uml2CodeApp.class.getClassLoader().getResource("umlTest.puml");
        File file = new File(resource.toURI());
        JavaGenerator.classDiagramToMultipleFiles(file);
    }
}
    