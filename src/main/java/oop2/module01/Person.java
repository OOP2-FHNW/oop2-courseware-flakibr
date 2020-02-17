package oop2.module01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dieter Holz
 */
public class Person {
    private int    age;
    private double weight;
    private double height;
    private List<Person> friends = new ArrayList<>();

    public Person(int age, double weight, double height) {
        this.age    = age;
        this.weight = weight;
        this.height = height;
    }

    public double getBMI() {
        return weight / (height * height);
    }

    //alle Getter und Setter

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public boolean addFriend(Person b) {
        if (b == this) return false;
        if (friends.contains(b)) return false;
        friends.add(b);
        b.friends.add(this);
        return true;
    }

    public boolean isFriendsWith(Person b) {
        return this.friends.contains(b);
    }

    public void removeFriend(Person b) {
        this.friends.remove(b);
        b.friends.remove(this);
    }

    public int getNumberOfFriends() {
        return friends.size();
    }
}
