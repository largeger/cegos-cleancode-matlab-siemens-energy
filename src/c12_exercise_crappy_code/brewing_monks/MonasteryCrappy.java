package c12_exercise_crappy_code.brewing_monks;

import java.util.ArrayList;
import java.util.List;

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

class Library {
    void catalog() {
        System.out.println("Cataloging ancient scrolls...");
    }
}

class MonasteryManager {
    List<Monk> monks = new ArrayList<>();
    Library library = new Library();

    void printMonkInfo(Monk monk) {
        System.out.println(monk.name + " is " + monk.age + " years old and works as a " + monk.role + ".");
    }

    void printAllMonks() {
        System.out.println("Monks in the monastery:");
        for (Monk monk : monks) {
            System.out.println(monk.name);
        }
    }

    void printElderMonks() {
        System.out.println("Elder monks:");
        for (Monk monk : monks) {
            if (monk.age > 70) {
                System.out.println(monk.name);
            }
        }
    }

    void manageBrewery(int monksAvailable, int beerBottles) {
        if (monksAvailable < 1) {
            System.out.println("Not enough monks to brew beer.");
            return;
        }
        if (beerBottles > 500) {
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

    void manageInventory(String item, int quantity) {
        if (quantity > 0) {
            System.out.println("Storing " + quantity + " " + item + "(s).");
        } else {
            System.out.println("Invalid item or quantity.");
        }
    }

    void monitorAirQuality(int days) {
        if (days > 100) {
            System.out.println("Monitoring air quality over " + days + " days is too excessive.");
        }
    }

    void giveMonkRaise(Monk monk) {
        if ("Brewmaster".equals(monk.role)) {
            monk.age += 1;
            System.out.println(monk.name + " received a raise for his brewmaster skills!");
        }
    }

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

public class MonasteryCrappy {
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
