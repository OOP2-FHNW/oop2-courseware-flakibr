package oop2.module01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testPersonInitialisation() {
        int age = 26;
        double weight = 60;
        double height = 1.69;

        Person p = new Person(age, weight, height);

        assertEquals(age, p.getAge());
        assertEquals(weight, p.getWeight());
        assertEquals(height, p.getHeight());
    }

    @Test
    void testBMI() {
        int age = 26;
        double weight = 60;
        double height = 1.69;

        Person p = new Person(age, weight, height);

        assertEquals(21.01, p.getBMI(), 0.01);
    }
}