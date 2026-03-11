package c12_exercise_crappy_code.crappy_stuff;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Manage {
    public int age;
    public String nam; // This variable represents the name

    public Manage() {
        age = 0;
        nam = "Unnamed";
    }

    public void setValues(int a, String n) {
        age = a;
        nam = n;
    }

    public void print() {
        System.out.println("Name: " + nam + ", Age: " + age);
    }
}

class Control {
    public static void printTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Time: " + now.format(formatter));
    }

    public void printStatus() {
        // Print the status
        System.out.println("Status: Active");
    }
}

class Worker {
    private int mValue;
    private List<Integer> mData;

    public Worker(int value) {
        mValue = value;
        mData = new ArrayList<>();
    }

    public Worker() {
        this(0);
    }

    public void addValue(int val) {
        mValue += val; // Increment mValue by the input
        mData.add(val); // Adds value to the data list
    }

    public void printData() {
        System.out.print("Values: ");
        for (int v : mData) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}

class DoWork {
    public void performTask(Worker worker) {
        for (int i = 0; i < 5; i++) {
            worker.addValue(i); // Adds incremental values to worker
        }
    }
}

public class CrappyStuffPart1 {
    public static void main(String[] args) {
        Manage manager = new Manage();
        manager.setValues(25, "Alice");
        manager.print();

        Control.printTime();
        Control control = new Control();
        control.printStatus();

        Worker work = new Worker();
        DoWork taskDoer = new DoWork();
        taskDoer.performTask(work);
        work.printData();
    }
}

