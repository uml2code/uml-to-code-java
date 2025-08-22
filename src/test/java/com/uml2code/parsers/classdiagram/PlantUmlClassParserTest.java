package com.uml2code.parsers.classdiagram;

import com.uml2code.model.classdiagram.Visibility;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


public class PlantUmlClassParserTest {
    @Test
    void testIsClassDefinition() {
        assertTrue(Helpers.isClassDefinition("class Person {"));
        assertFalse(Helpers.isClassDefinition("interface Person {"));
    }

    @Test
    void testGetClassName() {
        assertEquals("Person", Helpers.getClassName("class Person {"));
        assertEquals("Student", Helpers.getClassName("abstract class Student {"));
    }

    @Test
    void testIsAbstract() {
        assertTrue(Helpers.isAbstract("abstract class Student {"));
        assertFalse(Helpers.isAbstract("class Person {"));
    }

    @Test
    void testIsClassEnd() {
        assertTrue(Helpers.isClassEnd("}"));
        assertFalse(Helpers.isClassEnd("class Person {"));
    }

    @Test
    void testIsMethod() {
        assertTrue(Helpers.isMethod("+ void greet(String name)"));
        assertFalse(Helpers.isMethod("+ int age"));
    }

    @Test
    void testGetMethodName() {
        assertEquals("greet", Helpers.getMethodName("+ void greet(String name)"));
        assertEquals("calculateAverage", Helpers.getMethodName("+ double calculateAverage(List<int> grades)"));
    }

    @Test
    void testGetParameters() {
        HashMap<String, String> params = Helpers.getParameters("+ void greet(String name, int times)");
        assertEquals(2, params.size());
        assertEquals("name", params.get("String"));
        assertEquals("times", params.get("int"));
    }

    @Test
    void testGetReturnType() {
        assertEquals("void", Helpers.getReturnType("+ void greet(String name)"));
        assertEquals("double", Helpers.getReturnType("+ double calculateAverage(List<int> grades)"));
    }

    @Test
    void testIsStatic() {
        assertTrue(Helpers.isStatic("+ static int counter"));
        assertFalse(Helpers.isStatic("+ int age"));
    }

    @Test
    void testIsAttribute() {
        assertTrue(Helpers.isAttribute("+ int age"));
        assertFalse(Helpers.isAttribute("+ void greet(String name)"));
    }

    @Test
    void testGetAttributeType() {
        assertEquals("int", Helpers.getAttributeType("+ int age"));
        assertEquals("String", Helpers.getAttributeType("- String name"));
    }

    @Test
    void testGetAttributeName() {
        assertEquals("age", Helpers.getAttributeName("+ int age"));
        assertEquals("name", Helpers.getAttributeName("- String name"));
    }

    @Test
    void testGetAttributeDefaultValue() {
        assertEquals("18", Helpers.getAttributeDefaultValue("+ int age = 18"));
        assertEquals("\"John\"", Helpers.getAttributeDefaultValue("- String name = \"John\""));
    }

    @Test
    void testParseVisibility() {
        assertEquals(Visibility.PUBLIC, Helpers.parseVisibility('+'));
        assertEquals(Visibility.PRIVATE, Helpers.parseVisibility('-'));
        assertEquals(Visibility.PROTECTED, Helpers.parseVisibility('#'));
        assertEquals(Visibility.PACKAGE_PRIVATE, Helpers.parseVisibility('~'));
    }
}
