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

package com.uml2code.model.classdiagram;

/**
 * Represents a parameter of a UML method.
 */
public class UmlParameter {

    /** Name of the parameter */
    private String name;

    /** Data type of the parameter */
    private String type;

    /**
     * No-argument constructor
     */
    public UmlParameter() {
    }

    /**
     * Full-argument constructor
     * @param name name of the parameter
     * @param type data type of the parameter
     */
    public UmlParameter(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // ----------------- Getters and Setters -----------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
