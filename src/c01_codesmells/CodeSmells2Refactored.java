package c01_codesmells;

public class CodeSmells2Refactored {
    // Data Clumps: Refactored
    class Address {
        private String street, city, state, zip;

        public Address(String street, String city, String state, String zip) {
            this.street = street;
            this.city = city;
            this.state = state;
            this.zip = zip;
        }

        public String getFullAddress() {
            return street + ", " + city + ", " + state + ", " + zip;
        }
    }

    class Person {
        private String name;
        private Address address;

        public Person(String name, Address address) {
            this.name = name;
            this.address = address;
        }

        public void printPersonDetails() {
            System.out.println("Name: " + name);
            System.out.println("Address: " + address.getFullAddress());
        }
    }

    // Primitive Obsession: Refactored
    class Money {
        private double amount;
        private String currency;

        public Money(double amount, String currency) {
            this.amount = amount;
            this.currency = currency;
        }

        public String formatted() {
            return currency + amount;
        }
    }

    class ProductOrder {
        private Money price;
        private int quantity;

        public ProductOrder(Money price, int quantity) {
            this.price = price;
            this.quantity = quantity;
        }

        public void printOrder() {
            System.out.println("Order: " + quantity + " items at " + price.formatted());
        }
    }

    // Case Statements: Refactored using Polymorphism
    interface Shape {
        void draw();
    }

    class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Circle");
        }
    }

    class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Square");
        }
    }

    class Triangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Triangle");
        }
    }

    // Parallel Inheritance: Refactored
    abstract class Animal {
        abstract void makeSound();
    }

    interface Toy {
        void playSound();
    }

    class Dog extends Animal implements Toy {
        @Override
        void makeSound() {
            System.out.println("Bark!");
        }

        @Override
        public void playSound() {
            System.out.println("Squeak Bark!");
        }
    }

}
