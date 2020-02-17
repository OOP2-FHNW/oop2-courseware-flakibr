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
        assertEquals(0, p.getFriends().size());
    }

    @Test
    void testBMI() {
        int age = 26;
        double weight = 60;
        double height = 1.69;

        Person p = new Person(age, weight, height);

        assertEquals(21.01, p.getBMI(), 0.01);
    }

    @Test
    void testAddingFriends() {
        Person a = new Person(20, 60, 1.80);
        Person b = new Person(22, 67, 1.89);

        a.addFriend(b);

        assertTrue(a.getFriends().contains(b));
        assertTrue(b.getFriends().contains(a));
    }

    @Test
    void testCheckingFriends() {
        Person a = new Person(20, 60, 1.80);
        Person b = new Person(22, 67, 1.89);

        a.addFriend(b);

        assertTrue(a.isFriendsWith(b));
        assertTrue(b.isFriendsWith(a));
    }

    @Test
    void testRemovingFriends() {
        Person a = new Person(20, 60, 1.80);
        Person b = new Person(22, 67, 1.89);

        a.addFriend(b);

        assertTrue(a.isFriendsWith(b));
        assertTrue(b.isFriendsWith(a));

        b.removeFriend(a);

        assertFalse(a.isFriendsWith(b));
        assertFalse(b.isFriendsWith(a));
    }
}