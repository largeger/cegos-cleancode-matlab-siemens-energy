package c12_exercise_crappy_code.brewing_monks.refactored;

import java.util.ArrayList;
import java.util.List;

// Encapsulates behavior in the class itself
class Monk {
    private String name;
    private int age;
    private String role;

    Monk(String name, int age, String role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    void printInfo() { // Encapsulates behavior
        System.out.println(name + " is " + age + " years old and works as a " + role + ".");
    }

    boolean isElder() { // Meaningful behavior in the class
        return age > 70;
    }
}

// Avoids God Class by separating functionalities
class Monastery {
    private List<Monk> monks = new ArrayList<>();

    void addMonk(Monk monk) {
        monks.add(monk);
    }

    void printAllMonks() {
        System.out.println("Monks in the monastery:");
        for (Monk monk : monks) {
            monk.printInfo(); // Avoids Feature Envy
        }
    }

    void printElderMonks() {
        System.out.println("Elder monks:");
        for (Monk monk : monks) {
            if (monk.isElder()) {
                System.out.println(monk); // Uses Monk's method
            }
        }
    }
}

// Separates Brewery logic
class Brewery {
    void brewBeer(int monksAvailable) {
        System.out.println(monksAvailable + " monk(s) brewing beer...");
        System.out.println("Beer brewing process completed.");
    }
}

// Encapsulates inventory items to avoid Primitive Obsession
class InventoryItem {
    private String itemName;
    private int quantity;

    InventoryItem(String name, int qty) {
        this.itemName = name;
        this.quantity = qty;
    }

    void storeItem() {
        System.out.println("Storing " + quantity + " units of " + itemName + ".");
    }
}

class Inventory {
    void storeItem(InventoryItem item) {
        if (item != null) {
            item.storeItem();
        } else {
            System.out.println("Invalid item quantity.");
        }
    }
}

// Uses polymorphism instead of switch statements
interface Duty {
    void performDuty();
}

class BrewDuty implements Duty {
    private String name;

    BrewDuty(String monkName) {
        this.name = monkName;
    }

    @Override
    public void performDuty() {
        System.out.println(name + " is brewing beer.");
    }
}

class CheeseDuty implements Duty {
    private String name;

    CheeseDuty(String monkName) {
        this.name = monkName;
    }

    @Override
    public void performDuty() {
        System.out.println(name + " is making cheese.");
    }
}

public class MonasteryRefactored {
    public static void main(String[] args) {
        Monastery monastery = new Monastery();
        monastery.addMonk(new Monk("Franz", 80, "Brewmaster"));
        monastery.addMonk(new Monk("Hans", 60, "Cheesemaker"));
        monastery.addMonk(new Monk("Karl", 40, "Herbalist"));

        monastery.printAllMonks();
        monastery.printElderMonks();

        Brewery brewery = new Brewery();
        brewery.brewBeer(3);

        Inventory inventory = new Inventory();
        inventory.storeItem(new InventoryItem("beer", 300));

        Duty brewDuty = new BrewDuty("Franz");
        Duty cheeseDuty = new CheeseDuty("Hans");

        brewDuty.performDuty();
        cheeseDuty.performDuty();
    }
}
