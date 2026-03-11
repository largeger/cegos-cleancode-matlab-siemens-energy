package c12_exercise_crappy_code.crappy_stuff;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class CatObj {
    String nm; // Name of cat
    int wt; // Cat's weight
    int sleepTime; // Amount of sleep

    CatObj() { // Default constructor
        nm = "Garfield";
        wt = 15;
        sleepTime = 16; // Average hours a cat sleeps
    }

    void details() {
        System.out.println("Name: " + nm + ", Weight: " + wt + " lbs, Sleep Time: " + sleepTime + " hrs");
    }
}

class CatAct {
    void eat(int amount) {
        System.out.println("Cat is eating " + amount + " servings.");
    }

    void nap() {
        System.out.println("Cat is napping.");
    }

    void chaseMice() {
        // Chase mice function
        System.out.println("Cat is chasing mice!");
    }

    void randomAction(CatObj cat) {
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

class Food {
    List<String> meals; // Meals eaten by cat

    Food() {
        meals = new ArrayList<>();
    }

    void addMeal(String meal) {
        meals.add(meal); // Adds meal to list
    }

    void displayMeals() {
        System.out.print("Meals eaten: ");
        for (String meal : meals) {
            System.out.print(meal + ", ");
        }
        System.out.println();
    }
}

class CatKeeper {
    void doSomethingWithCat(CatObj cat, CatAct act) {
        System.out.println("Doing something with cat...");
        act.randomAction(cat);
    }

    void feedCat(CatObj cat, Food food) {
        System.out.println(cat.nm + " is being fed.");
        food.addMeal("Salmon");
    }
}

public class CrappyStuffPart2 {
    public static void main(String[] args) {

        CatObj c = new CatObj();
        CatAct ca = new CatAct();
        Food fd = new Food();
        CatKeeper ck = new CatKeeper();

        ck.feedCat(c, fd); // Cat is being fed
        ck.doSomethingWithCat(c, ca); // Cat does random action
        fd.displayMeals(); // Shows meals eaten
    }
}
