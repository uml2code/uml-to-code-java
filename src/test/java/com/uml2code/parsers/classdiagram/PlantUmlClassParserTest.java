package com.uml2code.parsers.classdiagram;

import com.uml2code.model.classdiagram.UmlAttribute;
import com.uml2code.model.classdiagram.UmlClass;
import com.uml2code.model.classdiagram.UmlMethod;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlantUmlClassParserTest {
    @Test
    void testParseSamplePuml() throws Exception {
        URL resource = getClass().getClassLoader().getResource("sample.puml");
        assertNotNull(resource, "Le fichier sample.puml doit exister dans resources");
        File file = new File(resource.toURI());

        PlantUmlClassParser parser = new PlantUmlClassParser();

        List<UmlClass> classes = parser.parse(file);
        assertEquals(3, classes.size(), "Should parse 3 UML types (Person, Student, Learner)");

        UmlClass person = classes.stream().filter(c -> c.getName().equals("Person")).findFirst().orElse(null);
        assertNotNull(person);
        assertEquals("Person", person.getName());
        assertEquals(1, person.getAttributes().size());
        assertEquals(1, person.getMethods().size());

        UmlAttribute nameAttr = person.getAttributes().get(0);
        assertEquals("name", nameAttr.getName());
        assertEquals("String", nameAttr.getType());

        UmlMethod setName = person.getMethods().get(0);
        assertEquals("setName", setName.getName());
        assertEquals("void", setName.getReturnType());

        UmlClass student = classes.stream().filter(c -> c.getName().equals("Student")).findFirst().orElse(null);
        UmlClass learner = classes.stream().filter(c -> c.getName().equals("Learner")).findFirst().orElse(null);

        assertNotNull(student);
        assertNotNull(learner);
        assertTrue(learner.isInterface(), "Learner should be an interface");
        assertEquals(person, student.getSuperClass(), "Student should extend Person");
        assertTrue(student.getInterfaces().contains(learner), "Student should implement Learner");
    }

    @Test
    void testParseUmlFile() throws Exception {
        URL resource = getClass().getClassLoader().getResource("umlTest.puml");
        File file = new File(resource.toURI());

        PlantUmlClassParser parser = new PlantUmlClassParser();
        List<UmlClass> classes = parser.parse(file);

        assertEquals(5, classes.size());

        UmlClass vehicle = classes.stream()
                .filter(c -> c.getName().equals("Vehicle"))
                .findFirst()
                .orElse(null);
        assertNotNull(vehicle);
        assertTrue(vehicle.isAbstract());
        assertEquals(1, vehicle.getAttributes().size());
        assertEquals(1, vehicle.getMethods().size());
        assertNull(vehicle.getSuperClass());

        // Vérifier la classe Car
        UmlClass car = classes.stream()
                .filter(c -> c.getName().equals("Car"))
                .findFirst()
                .orElse(null);
        assertNotNull(car);
        assertEquals("Vehicle", car.getSuperClass().getName());
        assertEquals(1, car.getMethods().size());
        assertEquals(1, car.getAttributes().size());

        assertNotNull(car.getInterfaces());
        assertEquals(1, car.getInterfaces().size());
        assertEquals("Electric", car.getInterfaces().get(0).getName());

        UmlClass motorbike = classes.stream()
                .filter(c -> c.getName().equals("Motorbike"))
                .findFirst()
                .orElse(null);
        assertNotNull(motorbike);
        assertEquals("Vehicle", motorbike.getSuperClass().getName());

        UmlClass bicycle = classes.stream()
                .filter(c -> c.getName().equals("Bicycle"))
                .findFirst()
                .orElse(null);
        assertNotNull(bicycle);
        assertNull(bicycle.getSuperClass());
        assertTrue(bicycle.getMethods().stream().anyMatch(m -> m.getName().equals("pedal")));
    }
}
