package com.uml2code.parsers.classdiagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RelationsTest {
    @Test
    void inheritanceTest(){
        assertTrue(Helpers.isInheritance("Parent <|-- Child"));
        assertFalse(Helpers.isInheritance("Parent --> Child"));
    }

    @Test
    void implementsTest(){
        assertTrue(Helpers.isImplements("Interface <|.. Class"));
        assertFalse(Helpers.isImplements("Interface <|-- Class"));
    }

    @Test
    void getChildClassNameTest() {
        String line = "Parent <|-- Child";
        assertEquals("Child", Helpers.getChildClassName(line));

        String wrongLine = "Parent --> Child";
        assertNull(Helpers.getChildClassName(wrongLine));
    }

    @Test
    void getParentClassNameTest() {
        String line = "Parent <|-- Child";
        assertEquals("Parent", Helpers.getParentClassName(line));

        String wrongLine = "Parent --> Child";
        assertNull(Helpers.getParentClassName(wrongLine));
    }

    @Test
    void getInterfaceImplementNameTest() {
        String line = "MyInterface <|.. MyClass";
        assertEquals("MyInterface", Helpers.getInterfaceImplementName(line));

        String wrongLine = "Parent <|-- Child";
        assertNull(Helpers.getInterfaceImplementName(wrongLine));
    }

    @Test
    void getClassImplementNameTest() {
        String line = "MyInterface <|.. MyClass";
        assertEquals("MyClass", Helpers.getClassImplementName(line));

        String wrongLine = "Parent <|-- Child";
        assertNull(Helpers.getClassImplementName(wrongLine));
    }
}
