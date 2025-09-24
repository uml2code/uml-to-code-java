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

/**
 * Represents an attribute of a UML class.
 */
class UmlAttribute {

    /** Name of the attribute */
    private String name;

    /** Data type of the attribute */
    private String type;

    /** Visibility of the attribute (public, private, protected, package-private) */
    private Visibility visibility;

    /** Indicates if the attribute is static */
    private boolean isStatic;

    /** Default value of the attribute, if any */
    private String defaultValue;

    /**
     * No-argument constructor
     */
    public UmlAttribute() {
    }

    /**
     * Full-argument constructor
     * @param name name of the attribute
     * @param type data type of the attribute
     * @param visibility visibility of the attribute
     * @param isStatic whether the attribute is static
     * @param defaultValue default value of the attribute
     */
    public UmlAttribute(String name, String type, Visibility visibility, boolean isStatic, String defaultValue) {
        this.name = name;
        this.type = type;
        this.visibility = visibility;
        this.isStatic = isStatic;
        this.defaultValue = defaultValue;
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

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean isStatic) {
        this.isStatic = isStatic;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}