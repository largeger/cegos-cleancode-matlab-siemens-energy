package c12_exercise_crappy_code.brewing_monks.hints;

import java.util.ArrayList;
import java.util.List;

// Data Class: Holds data but lacks behavior
class Monk {
    String name;
    int age;
    String role;

    Monk(String name, int age, String role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }
}

// Lazy Class: Barely used in the code
class Library {
    void catalog() {
        System.out.println("Cataloging ancient scrolls...");
    }
}

// God Class: Handles too many responsibilities
class MonasteryManager {
    List<Monk> monks = new ArrayList<>(); // Potentially large list, consider memory management
    Library library = new Library();

    // Feature Envy: Accesses Monk data directly instead of delegating behavior
    void printMonkInfo(Monk monk) {
        System.out.println(monk.name + " is " + monk.age + " years old and works as a " + monk.role + ".");
    }

    // Duplicated Code: Both functions print similar lists
    void printAllMonks() {
        System.out.println("Monks in the monastery:");
        for (Monk monk : monks) {
            System.out.println(monk.name);
        }
    }

    void printElderMonks() {
        System.out.println("Elder monks:");
        for (Monk monk : monks) {
            if (monk.age > 70) { // Magic number, consider making it a constant
                System.out.println(monk.name);
            }
        }
    }

    // Long Method: Too many conditionals in one function
    void manageBrewery(int monksAvailable, int beerBottles) {
        if (monksAvailable < 1) {
            System.out.println("Not enough monks to brew beer.");
            return;
        }
        if (beerBottles > 500) { // Magic number, consider defining a constant
            System.out.println("Too much beer! The brewery is overflowing!");
            return;
        }
        if (monksAvailable >= 3) {
            System.out.println("Three monks are brewing beer...");
        } else if (monksAvailable == 2) {
            System.out.println("Two monks are brewing beer.");
        } else {
            System.out.println("One monk is brewing beer.");
        }
        System.out.println("Beer brewing process completed.");
    }

    // Primitive Obsession: Uses basic types instead of objects
    void manageInventory(String item, int quantity) {
        if (quantity > 0) {
            System.out.println("Storing " + quantity + " " + item + "(s).");
        } else {
            System.out.println("Invalid item or quantity.");
        }
    }

    // Speculative Generality: Unused function with unnecessary complexity
    void monitorAirQuality(int days) {
        if (days > 100) { // Magic number, consider making it configurable
            System.out.println("Monitoring air quality over " + days + " days is too excessive.");
        }
    }

    // Inappropriate Intimacy: Directly modifies Monk's data
    void giveMonkRaise(Monk monk) {
        if ("Brewmaster".equals(monk.role)) { // Hardcoded role check, consider using an Enum
            monk.age += 1; // Modifying age directly, consider encapsulation
            System.out.println(monk.name + " received a raise for his brewmaster skills!");
        }
    }

    // Switch Statements: Uses conditionals instead of polymorphism
    void performDuties(Monk monk) {
        switch (monk.role) {
            case "Brewmaster":
                System.out.println(monk.name + " is brewing beer.");
                break;
            case "Cheesemaker":
                System.out.println(monk.name + " is making cheese.");
                break;
            case "Herbalist":
                System.out.println(monk.name + " is gathering herbs.");
                break;
            default:
                System.out.println(monk.name + " has an unknown role.");
                break;
        }
    }
}

public class MonasteryCrappyWithHints {
    public static void main(String[] args) {
        MonasteryManager manager = new MonasteryManager();
        manager.monks.add(new Monk("Franz", 80, "Brewmaster"));
        manager.monks.add(new Monk("Hans", 60, "Cheesemaker"));
        manager.monks.add(new Monk("Karl", 40, "Herbalist"));

        manager.printAllMonks();
        manager.printElderMonks();
        manager.manageBrewery(3, 400);
        manager.manageInventory("beer", 300);
        manager.monitorAirQuality(150);
        manager.giveMonkRaise(manager.monks.get(0));
        manager.performDuties(manager.monks.get(1));
    }
}

