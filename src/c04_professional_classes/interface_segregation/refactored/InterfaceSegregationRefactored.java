package c04_professional_classes.interface_segregation.refactored;/*
In this example:

- We split the interfaces into Workable, Eatable, and Sleepable.
- HumanWorker implements all three interfaces, while RobotWorker implements only Workable.
- Each class now only depends on the methods it needs, adhering to the Interface Segregation Principle and resulting in a cleaner design.
*/

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

class HumanWorker implements Workable, Eatable, Sleepable {
    @Override
    public void work() {
        System.out.println("Human is working...");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating...");
    }

    @Override
    public void sleep() {
        System.out.println("Human is sleeping...");
    }
}

class RobotWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Robot is working...");
    }
    // RobotWorker doesn’t need to implement `eat` and `sleep` interfaces.
}

public class InterfaceSegregationRefactored {
    public static void main(String[] args) {
        HumanWorker human = new HumanWorker();
        RobotWorker robot = new RobotWorker();

        human.work();
        human.eat();
        human.sleep();

        robot.work();
    }
}
