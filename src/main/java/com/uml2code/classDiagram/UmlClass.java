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

import java.util.List;

/**
 * Represents a UML class in a class diagram.
 */
class UmlClass {

    /** Name of the UML class */
    private String name;

    /** List of attributes of the class */
    private List<UmlAttribute> attributes;

    /** List of methods of the class */
    private List<UmlMethod> methods;

    /** Visibility of the class (public, private, protected, package-private) */
    private Visibility visibility;

    /** Indicates whether the class is abstract */
    private boolean isAbstract;

    /** Superclass of this class, if any */
    private UmlClass superClass;

    /** Indicates whether this class is an interface */
    private boolean isInterface;

    /** List of interfaces implemented by this class */
    private List<UmlClass> interfaces;

    /**
     * No-argument constructor
     */
    public UmlClass() {
    }

    /**
     * Full-argument constructor
     */
    public UmlClass(String name, List<UmlAttribute> attributes, List<UmlMethod> methods,
                    Visibility visibility, boolean isAbstract, UmlClass superClass,
                    boolean isInterface, List<UmlClass> interfaces) {
        this.name = name;
        this.attributes = attributes;
        this.methods = methods;
        this.visibility = visibility;
        this.isAbstract = isAbstract;
        this.superClass = superClass;
        this.isInterface = isInterface;
        this.interfaces = interfaces;
    }

    // ----------------- Getters and Setters -----------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UmlAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<UmlAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<UmlMethod> getMethods() {
        return methods;
    }

    public void setMethods(List<UmlMethod> methods) {
        this.methods = methods;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public void setAbstract(boolean isAbstract) {
        this.isAbstract = isAbstract;
    }

    public UmlClass getSuperClass() {
        return superClass;
    }

    public void setSuperClass(UmlClass superClass) {
        this.superClass = superClass;
    }

    public boolean isInterface() {
        return isInterface;
    }

    public void setInterface(boolean isInterface) {
        this.isInterface = isInterface;
    }

    public List<UmlClass> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(List<UmlClass> interfaces) {
        this.interfaces = interfaces;
    }
}
