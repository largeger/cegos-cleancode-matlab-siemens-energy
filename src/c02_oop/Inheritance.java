package c02_oop;

/*
Explanation
Base Class (Vehicle):

Contains common attributes and methods (like start() and honk()) that all vehicles share.
honk() is declared virtual, allowing derived classes to override it.
Derived Class Car:

Inherits from Vehicle and adds a specific attribute, doors.
Overrides honk() to provide a car-specific honking sound and includes an additional method, openDoors().
Derived Class Bike:

Inherits from Vehicle and adds a specific attribute, hasCarrier.
Overrides honk() to provide a bike-specific honking sound and includes an additional method, showCarrierStatus().
*/
public class Inheritance {

    static class Vehicle {
        protected String brand;
        protected int year;

        public Vehicle(String brand, int year) {
            this.brand = brand;
            this.year = year;
        }

        public void start() {
            System.out.println("Starting the vehicle: " + brand + " (" + year + ")");
        }

        public void honk() {
            System.out.println("Vehicle honking!");
        }
    }

    static class Car extends Vehicle {
        private int doors;

        public Car(String brand, int year, int doors) {
            super(brand, year);
            this.doors = doors;
        }

        @Override
        public void honk() {
            System.out.println("Car honking: Beep Beep!");
        }

        public void openDoors() {
            System.out.println("Opening " + doors + " doors of the car.");
        }
    }

    static class Bike extends Vehicle {
        private boolean hasCarrier;

        public Bike(String brand, int year, boolean hasCarrier) {
            super(brand, year);
            this.hasCarrier = hasCarrier;
        }

        @Override
        public void honk() {
            System.out.println("Bike honking: Ring Ring!");
        }

        public void showCarrierStatus() {
            System.out.println("Bike has a carrier: " + (hasCarrier ? "Yes" : "No"));
        }
    }

    public static void main(String[] args) {
        Car myCar = new Car("Toyota", 2022, 4);
        Bike myBike = new Bike("Yamaha", 2021, true);

        myCar.start();
        myCar.honk();
        myCar.openDoors();

        System.out.println();

        myBike.start();
        myBike.honk();
        myBike.showCarrierStatus();
    }

}
