package c01_codesmells;

public class CodeSmells4Refactored {
    // Improved UserData class with meaningful behavior
    class UserData {
        private String name;
        private int age;
        private String email;
        private String address;

        public UserData(String name, int age, String email, String address) {
            this.name = name;
            this.age = age;
            this.email = email;
            this.address = address;
        }

        public void printUserSummary() {
            System.out.println("User: " + name + ", Age: " + age);
        }

        public boolean isAdult() {
            return age >= 18;
        }
    }

    // Properly structured Animal hierarchy
    abstract class AnimalBase {
        abstract void makeSound();
    }

    abstract class FlyingAnimal extends AnimalBase {
        public void fly() {
            System.out.println("This animal can fly.");
        }
    }

    class Dog extends AnimalBase {
        @Override
        void makeSound() {
            System.out.println("Bark!");
        }
    }

    class Bird extends FlyingAnimal {
        @Override
        void makeSound() {
            System.out.println("Tweet!");
        }
    }

}
