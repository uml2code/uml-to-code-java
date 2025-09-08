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
package com.uml2code.generators.javaGenerator;
/**
 * A utility class containing constants for Java keywords,
 * data types, access modifiers, symbols, and other commonly
 * used elements for generating Java code programmatically.
 * <p>
 * This class is intended for use in UML-to-Java code generation
 * tools to ensure consistency and readability when producing code.
 * </p>
 */
class JavaKeywords {
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
    // Scope / Access Modifiers
    // ==============================
    protected static final String PUBLIC = "public";
    protected static final String PRIVATE = "private";
    protected static final String PROTECTED = "protected";

    // ==============================
    // Punctuation / Symbols
    // ==============================
    protected static final char DOT = '.';
    protected static final char COMMA = ',';
    protected static final char SEMICOLON = ';';
    protected static final char COLON = ':';
    protected static final char SPACE = ' ';
    protected static final String NEWLINE = "\n";
    protected static final String TAB = "\t";
    protected static final char EQUALS = '=';
    protected static final char PLUS = '+';
    protected static final char MINUS = '-';
    protected static final char ASTERISK = '*';
    protected static final char SLASH = '/';
    protected static final char PERCENT = '%';

    // ==============================
    // Brackets / Braces
    // ==============================
    protected static final char LEFT_BRACE = '{';
    protected static final char RIGHT_BRACE = '}';
    protected static final char LEFT_PAREN = '(';
    protected static final char RIGHT_PAREN = ')';
    protected static final char LEFT_BRACKET = '[';
    protected static final char RIGHT_BRACKET = ']';
}
