package c12_exercise_crappy_code.crappy_stuff.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class CatObj { // Poorly named; unclear that this represents a Cat
    String nm; // Name of cat (bad abbreviation)
    int wt; // Cat's weight (non-descriptive)
    int sleepTime; // Amount of sleep (not clear on the units)

    CatObj() { // Default constructor
        nm = "Garfield";
        wt = 15;
        sleepTime = 16; // Average hours a cat sleeps
    }

    void details() {
        System.out.println("Name: " + nm + ", Weight: " + wt + " lbs, Sleep Time: " + sleepTime + " hrs");
    }
}

class CatAct { // Poorly named; unclear what kind of actions it holds
    void eat(int amount) { // Unclear purpose of 'amount'
        System.out.println("Cat is eating " + amount + " servings.");
    }

    void nap() {
        System.out.println("Cat is napping.");
    }

    void chaseMice() {
        // Chase mice function
        System.out.println("Cat is chasing mice!");
    }

    void randomAction(CatObj cat) { // Poor parameter name; violates SRP by handling random behavior
        Random rand = new Random();
        int action = rand.nextInt(3);
        if (action == 0) {
            eat(2);
        } else if (action == 1) {
            nap();
        } else {
            chaseMice();
        }
    }
}

class Food { // Unclear responsibility; represents both food and a log of meals
    List<String> meals; // Meals eaten by cat

    Food() {
        meals = new ArrayList<>();
    }

    void addMeal(String meal) {
        meals.add(meal); // Adds meal to list
    }

    void displayMeals() { // Shows all meals eaten (responsibility confusion)
        System.out.print("Meals eaten: ");
        for (String meal : meals) {
            System.out.print(meal + ", ");
        }
        System.out.println();
    }
}

class CatKeeper { // Misleading name; implies it does everything for the cat
    void doSomethingWithCat(CatObj cat, CatAct act) { // Generic method name with unclear parameters
        System.out.println("Doing something with cat...");
        act.randomAction(cat);
    }

    void feedCat(CatObj cat, Food food) { // Poor use of parameters; violates DIP
        System.out.println(cat.nm + " is being fed.");
        food.addMeal("Salmon");
    }
}

public class CrappyStuffPart2WithComments {
    public static void main(String[] args) {

        CatObj c = new CatObj(); // Unclear variable name
        CatAct ca = new CatAct(); // Poor naming; hard to understand
        Food fd = new Food(); // Unclear; does not indicate that it stores meals
        CatKeeper ck = new CatKeeper(); // Misleading name

        ck.feedCat(c, fd); // Cat is being fed
        ck.doSomethingWithCat(c, ca); // Cat does random action
        fd.displayMeals(); // Shows meals eaten
    }
}
