package c12_exercise_crappy_code.crappy_stuff.solution;

class Coffee {
    int type; // Coffee type (bad naming and unclear purpose)
    boolean isHot;
    int s; // Size (bad naming)

    Coffee() {
        type = 1; // Default to "Espresso"
        isHot = true;
        s = 2; // Medium size
    }

    void printDetails() { // SRP Violation: Coffee shouldn't be printing itself
        System.out.println("Coffee Type: " + type + ", Size: " + s + ", Hot: " + isHot);
    }
}

class CoffeeMachine { // Monolithic class responsible for too many tasks
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

    void refill() { // SRP Violation: Machine shouldn't refill itself
        System.out.println("Refilling beans and water...");
        beans = 100;
        water = 500;
    }

    void clean() { // SRP Violation: Machine shouldn't clean itself
        System.out.println("Cleaning coffee machine...");
        isClean = true;
    }

    void status() { // Unnecessary method that adds clutter
        System.out.println("Beans: " + beans + "g, Water: " + water + "ml, Clean: " + isClean);
    }
}

class User { // Bad class name; no clear responsibility
    void wantsCoffee(CoffeeMachine machine) { // Method name is unclear
        Coffee coffee = new Coffee(); // Default coffee with poor naming
        System.out.println("User wants coffee.");
        machine.makeCoffee(coffee); // Making coffee with machine
    }

    void addMilk() { // No connection to any coffee object or coffee-making process
        System.out.println("Adding milk...");
    }

    void addSugar() { // Unnecessary function call
        System.out.println("Adding sugar...");
    }

    void drink() { // Method that doesn’t interact with any actual coffee object
        System.out.println("Drinking coffee...");
    }
}

public class CrappyStuffPart3WithComments {
    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine(); // Poor variable name
        User u = new User(); // Poor variable name

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
