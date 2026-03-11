package c12_exercise_crappy_code.crappy_stuff;

class Coffee {
    int type; // Coffee type
    boolean isHot;
    int s; // Size

    Coffee() {
        type = 1; // Default to "Espresso"
        isHot = true;
        s = 2; // Medium size
    }

    void printDetails() {
        System.out.println("Coffee Type: " + type + ", Size: " + s + ", Hot: " + isHot);
    }
}

class CoffeeMachine {
    int beans; // Amount of beans in grams
    int water; // Water level in ml
    boolean isClean;

    CoffeeMachine() {
        beans = 100;
        water = 500;
        isClean = true;
    }

    void makeCoffee(Coffee coffee) {
        if (beans > 10 && water > 50) {
            System.out.println("Making coffee...");
            beans -= 10;
            water -= 50;
            coffee.printDetails();
        } else {
            System.out.println("Not enough beans or water!");
        }
    }

    void refill() {
        System.out.println("Refilling beans and water...");
        beans = 100;
        water = 500;
    }

    void clean() {
        System.out.println("Cleaning coffee machine...");
        isClean = true;
    }

    void status() {
        System.out.println("Beans: " + beans + "g, Water: " + water + "ml, Clean: " + isClean);
    }
}

class User {
    void wantsCoffee(CoffeeMachine machine) {
        Coffee coffee = new Coffee(); // Default coffee
        System.out.println("User wants coffee.");
        machine.makeCoffee(coffee); // Making coffee with machine
    }

    void addMilk() {
        System.out.println("Adding milk...");
    }

    void addSugar() {
        System.out.println("Adding sugar...");
    }

    void drink() {
        System.out.println("Drinking coffee...");
    }
}

public class CrappyStuffPart3 {
    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        User u = new User();

        cm.status(); // Status check before making coffee
        u.wantsCoffee(cm); // User "wants" coffee
        u.addMilk(); // Adding milk in a vacuum
        u.addSugar(); // Adding sugar with no actual effect
        u.drink(); // Drinking imaginary coffee

        cm.refill(); // Refilling the machine
        cm.clean(); // Cleaning the machine
        cm.status(); // Final status check
    }
}

