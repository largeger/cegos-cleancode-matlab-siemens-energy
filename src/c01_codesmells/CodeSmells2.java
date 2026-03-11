package c01_codesmells;

public class CodeSmells2 {
    // Data Clumps: Original
    class Person {
        static void printPersonDetails(String name, String street, String city, String state, String zip) {
            System.out.println("Name: " + name);
            System.out.println("Address: " + street + ", " + city + ", " + state + ", " + zip);
        }
    }

    // Primitive Obsession: Original
    class ProductOrder {
        private double price;
        private int quantity;
        private String currency;

        public ProductOrder(double price, int quantity, String currency) {
            this.price = price;
            this.quantity = quantity;
            this.currency = currency;
        }

        public void printOrder() {
            System.out.println("Order: " + quantity + " items at " + currency + price);
        }
    }

    // Case Statements in Object-Oriented Code: Original
    enum ShapeType {
        CIRCLE, SQUARE, TRIANGLE;
    }

    class Shape {
        private ShapeType type;

        public Shape(ShapeType type) {
            this.type = type;
        }

        public void draw() {
            switch (type) {
                case CIRCLE:
                    System.out.println("Drawing a Circle");
                    break;
                case SQUARE:
                    System.out.println("Drawing a Square");
                    break;
                case TRIANGLE:
                    System.out.println("Drawing a Triangle");
                    break;
            }
        }
    }

    // Parallel Inheritance: Original
    abstract class Animal {
        abstract void makeSound();
    }

    class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Bark!");
        }
    }

    abstract class AnimalToy {
        abstract void playSound();
    }

    class DogToy extends AnimalToy {
        @Override
        void playSound() {
            System.out.println("Squeak Bark!");
        }
    }

}
