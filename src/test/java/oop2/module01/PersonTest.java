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
    void testNumberOfFriends() {
        Person a = new Person(20, 60, 1.80);
        Person b = new Person(22, 67, 1.89);
        Person c = new Person(24, 80, 1.90);

        assertEquals(0, a.getNumberOfFriends());
        assertEquals(0, b.getNumberOfFriends());
        assertEquals(0, c.getNumberOfFriends());

        a.addFriend(b);

        assertEquals(1, a.getNumberOfFriends());
        assertEquals(1, b.getNumberOfFriends());
        assertEquals(0, c.getNumberOfFriends());

        a.addFriend(c);

        assertEquals(2, a.getNumberOfFriends());
        assertEquals(1, b.getNumberOfFriends());
        assertEquals(1, c.getNumberOfFriends());

        b.addFriend(c);

        assertEquals(2, a.getNumberOfFriends());
        assertEquals(2, b.getNumberOfFriends());
        assertEquals(2, c.getNumberOfFriends());

        a.removeFriend(b);
        a.removeFriend(c);

        assertEquals(0, a.getNumberOfFriends());
        assertEquals(1, b.getNumberOfFriends());
        assertEquals(1, c.getNumberOfFriends());
    }

    @Test
    void testAddFriend() {
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
    void testRemoveFriend() {
        Person a = new Person(20, 60, 1.80);
        Person b = new Person(22, 67, 1.89);

        a.addFriend(b);

        assertTrue(a.isFriendsWith(b));
        assertTrue(b.isFriendsWith(a));

        b.removeFriend(a);

        assertFalse(a.isFriendsWith(b));
        assertFalse(b.isFriendsWith(a));
        assertEquals(0, a.getNumberOfFriends());
    }

    @Test
    void cantAddYourself() {
        Person a = new Person(20, 60, 1.80);

        a.addFriend(a);

        assertEquals(0, a.getNumberOfFriends());
    }

    @Test
    void cantAddSomeoneTwice() {
        Person a = new Person(20, 60, 1.80);
        Person b = new Person(22, 67, 1.89);

        a.addFriend(b);
        a.addFriend(b);
        b.addFriend(a);

        assertEquals(1, a.getNumberOfFriends());
        assertEquals(1, b.getNumberOfFriends());
    }
}