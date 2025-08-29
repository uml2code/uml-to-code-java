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

public class JavaKeywords {
    // ==============================
    // Class-related keywords
    // ==============================
    protected static final String CLASS = "class";
    protected static final String ABSTRACT = "abstract";
    protected static final String INTERFACE = "interface";
    protected static final String EXTENDS = "extends";
    protected static final String IMPLEMENTS = "implements";
    protected static final String ENUM = "enum";

    // ==============================
    // Datatype keywords
    // ==============================

    // --- Primitive data types (8 total) ---
    protected static final String BYTE = "byte";
    protected static final String SHORT = "short";
    protected static final String INT = "int";
    protected static final String LONG = "long";
    protected static final String BOOLEAN = "boolean";
    protected static final String FLOAT = "float";
    protected static final String DOUBLE = "double";
    protected static final String CHAR = "char";

    // --- Non-primitive data types ---
    protected static final String STRING = "String";

    // Collections (non-primitive/reference types)
    protected static final String LIST = "List";
    protected static final String ARRAY_LIST = "ArrayList";
    protected static final String LINKED_LIST = "LinkedList";

    // --- Wrapper classes for primitives ---
    protected static final String BYTE_WRAPPER = "Byte";
    protected static final String SHORT_WRAPPER = "Short";
    protected static final String INTEGER_WRAPPER = "Integer";
    protected static final String LONG_WRAPPER = "Long";
    protected static final String FLOAT_WRAPPER = "Float";
    protected static final String DOUBLE_WRAPPER = "Double";
    protected static final String CHARACTER_WRAPPER = "Character";
    protected static final String BOOLEAN_WRAPPER = "Boolean";

    // ==============================
    // Scope
    // ==============================
    protected static final String PUBLIC = "public";
    protected static final String PRIVATE = "private";
    protected static final String PROTECTED = "protected";
}
