package c04_professional_classes;

public class CapabilityInterfaceDemo {
    interface Flyable {
        void fly();
    }

    interface Swimmable {
        void swim();
    }

    static class Bird implements Flyable {
        @Override
        public void fly() {
            System.out.println("Bird is flying...");
        }
    }

    static class Fish implements Swimmable {
        @Override
        public void swim() {
            System.out.println("Fish is swimming...");
        }
    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        Fish fish = new Fish();

        bird.fly();
        fish.swim();
    }

}
