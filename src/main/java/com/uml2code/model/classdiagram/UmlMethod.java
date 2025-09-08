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

import java.util.List;

/**
 * Represents a method in a UML class.
 */
public class UmlMethod {

    /** Name of the method */
    private String name;

    /** Return type of the method */
    private String returnType;

    /** Visibility of the method (public, private, protected, package-private) */
    private Visibility visibility;

    /** List of parameters of the method */
    private List<UmlParameter> parameters;

    /** Indicates whether the method is abstract */
    private boolean isAbstract;

    /** Indicates whether the method is static */
    private boolean isStatic;

    /**
     * No-argument constructor
     */
    public UmlMethod() {
    }

    /**
     * Full-argument constructor
     */
    public UmlMethod(String name, String returnType, Visibility visibility,
                     List<UmlParameter> parameters, boolean isAbstract, boolean isStatic) {
        this.name = name;
        this.returnType = returnType;
        this.visibility = visibility;
        this.parameters = parameters;
        this.isAbstract = isAbstract;
        this.isStatic = isStatic;
    }

    // ----------------- Getters and Setters -----------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public List<UmlParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<UmlParameter> parameters) {
        this.parameters = parameters;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public void setAbstract(boolean isAbstract) {
        this.isAbstract = isAbstract;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean isStatic) {
        this.isStatic = isStatic;
    }
}
