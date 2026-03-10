package c02_oop;

import java.util.ArrayList;
import java.util.List;
/*
Explanation
Base Class (Animal):

The speak() method is declared abstract, making it polymorphic. This allows derived classes to provide their specific implementation.
The Animal class has a virtual destructor in C++, but in Java, memory management is handled by the garbage collector, so we don't need to explicitly define a destructor.
Derived Classes (Dog and Cat):

Both Dog and Cat override the speak() method to provide specific implementations.
Polymorphism in Action:

We create a List of Animal to hold different Animal types.
Using animal.speak(), the correct overridden method is called based on the actual object type (Dog or Cat), demonstrating polymorphism.
*/

public class Polymorphism {

    // Base Class
    abstract static class Animal {
        // Abstract method to be implemented by derived classes
        public abstract void speak();
    }

    // Derived Class Dog
    static class Dog extends Animal {
        @Override
        public void speak() {
            System.out.println("Woof Woof!");
        }
    }

    // Derived Class Cat
    static class Cat extends Animal {
        @Override
        public void speak() {
            System.out.println("Meow!");
        }
    }

    public static void main(String[] args) {
        // Using polymorphism: a list of Animal objects, holding different derived types
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog()); // Adding a Dog
        animals.add(new Cat()); // Adding a Cat

        // Iterating through the list and calling speak() on each Animal
        for (Animal animal : animals) {
            animal.speak(); // Calls the appropriate speak() method based on the actual object type
        }
    }

}
