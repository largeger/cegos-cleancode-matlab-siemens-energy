package c04_professional_classes.dependency_inversion;

import java.util.ArrayList;
import java.util.List;

/*
In this example:

- We create an IWorker interface that Worker and Robot implement.
- The Manager class depends on the IWorker abstraction, not specific worker implementations.
- This adheres to DIP, allowing the Manager class to work with any class that implements IWorker, making the system more flexible and easier to extend.
*/

interface IWorker {
    void work();
}

class Worker implements IWorker {
    @Override
    public void work() {
        System.out.println("Worker is working...");
    }
}

class Robot implements IWorker {
    @Override
    public void work() {
        System.out.println("Robot is working...");
    }
}

class Manager {
    private List<IWorker> workers = new ArrayList<>();

    public void addWorker(IWorker worker) {
        workers.add(worker);
    }

    public void manage() {
        for (IWorker worker : workers) {
            worker.work();
        }
    }
}

public class DependencyInversionRefactored {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.addWorker(new Worker());
        manager.addWorker(new Robot());
        manager.manage();
    }
}
