package c02_oop;

/**
 * Explanation
 * Composition:
 *
 * Car contains an Engine object. The Engine is created when the Car is
 * constructed,
 * and it can't exist outside of it.
 *
 * Aggregation:
 *
 * Car has a Driver object. This allows the Driver to exist independently and
 * be shared with other instances of Car.
 */
public class Association {

    static class Engine {
        private String model;

        public Engine(String model) {
            this.model = model;
        }

        public void start() {
            System.out.println("Engine " + model + " started.");
        }

        public String getModel() {
            return model;
        }
    }

    static class Driver {
        private String name;

        public Driver(String name) {
            this.name = name;
        }

        public void drive() {
            System.out.println("Driver " + name + " is driving.");
        }

        public String getName() {
            return name;
        }
    }

    static class Car {
        private String brand;
        private Engine engine; // Composition: Car *owns* the engine
        private Driver driver; // Aggregation: Car *uses* the driver

        public Car(String brand, String engineModel) {
            this.brand = brand;
            this.engine = new Engine(engineModel);
        }

        public void setDriver(Driver driver) {
            this.driver = driver;
        }

        public void start() {
            System.out.println("Car " + brand + " is starting.");
            engine.start();
            if (driver != null) {
                driver.drive();
            } else {
                System.out.println("No driver assigned.");
            }
        }
    }

    public static void main(String[] args) {
        // Composition: Car contains an Engine
        Car myCar = new Car("Toyota", "V8");

        // Aggregation: Driver is shared and can be assigned to different cars
        Driver driver = new Driver("Alice");
        myCar.setDriver(driver);

        myCar.start(); // Start the car with the assigned driver
    }
}
