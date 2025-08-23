package com.uml2code.parsers.classdiagram;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClassTest {
    @Test
    void simpleClassTest(){
        String line = "class Person {";
        assertTrue(Helpers.isClassDefinition(line));
        assertEquals("Person", Helpers.getClassName(line));
    }

    @Test
    void abstractClassTest(){
        String line = "abstract class Student {";
        assertTrue(Helpers.isClassDefinition(line));
        assertTrue(Helpers.isAbstract(line));
        assertEquals("Student", Helpers.getClassName(line));
    }

    @Test
    void genericClassTest(){
        String line = "class Box<T>";
        assertTrue(Helpers.isClassDefinition(line));
        assertFalse(Helpers.isAbstract(line));
        assertEquals("Box<T>", Helpers.getClassName(line));
    }

    @Test
    void classWithStereotypes(){
        String line = "class Person <<entity>>";
        assertTrue(Helpers.isClassDefinition(line));
        assertFalse(Helpers.isAbstract(line));
        assertEquals("Person", Helpers.getClassName(line));
    }

    @Test
    void testIsClassDefinition() {
        assertTrue(Helpers.isClassDefinition("class Person {"));
        assertFalse(Helpers.isClassDefinition("interface Person {"));
        assertTrue(Helpers.isClassDefinition("abstract class Person {"));
    }

}
