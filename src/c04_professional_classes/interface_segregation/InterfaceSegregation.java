package c04_professional_classes.interface_segregation;/*
In this example:

- The Worker interface has methods work, eat, and sleep, which don’t all apply to both HumanWorker and RobotWorker.
- RobotWorker is forced to implement eat and sleep even though they’re irrelevant, violating the Interface Segregation Principle by making RobotWorker dependent on methods it doesn’t use.
*/

interface Worker {
    void work();
    void eat(); // Not applicable to all workers
    void sleep(); // Not applicable to all workers
}


class HumanWorker implements Worker {
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

class RobotWorker implements Worker {
    @Override
    public void work() {
        System.out.println("Robot is working...");
    }

    @Override
    public void eat() {
        // Robot doesn't eat, but must implement this method.
    }

    @Override
    public void sleep() {
        // Robot doesn't sleep, but must implement this method.
    }
}

public class InterfaceSegregation {
    public static void main(String[] args) {
        HumanWorker human = new HumanWorker();
        RobotWorker robot = new RobotWorker();

        human.work();
        human.eat();
        human.sleep();

        robot.work();
        // eat() and sleep() methods are implemented but unnecessary for RobotWorker.
    }
}

