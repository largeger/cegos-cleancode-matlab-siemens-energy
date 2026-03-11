package c04_professional_classes.dependency_inversion;/*
 * This implementation demonstrates a violation of the Dependency Inversion Principle (DIP).
 * The Manager class directly depends on the Worker and Robot classes, making it difficult to extend
 * or introduce new types of workers without modifying the Manager class.
 */

public class DependencyInversion {
    // Worker class representing a human worker
    static class Worker {
        void work() {
            System.out.println("Worker is working...");
        }
    }

    // Robot class representing an automated worker
    static class Robot {
        void work() {
            System.out.println("Robot is working...");
        }
    }

    // Manager class that directly depends on Worker and Robot classes
    static class Manager {
        private Worker worker;
        private Robot robot;

        // Constructor taking specific Worker and Robot instances
        Manager(Worker w, Robot r) {
            this.worker = w;
            this.robot = r;
        }

        // Method to manage both Worker and Robot
        void manage() {
            worker.work();
            robot.work();
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        Robot robot = new Robot();
        Manager manager = new Manager(worker, robot);

        // Manager calls manage method to make Worker and Robot work
        manager.manage();
    }
}
