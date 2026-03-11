package c12_exercise_crappy_code.crappy_stuff.solution;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
1. Code Smells and SOLID Principle Violations
Bad Naming: Classes like Manage, Control, and DoWork are vague and don't clarify their purpose. nam, m_value, and m_data are unclear and non-descriptive.

2. SRP Violation:
- Control class handles both time printing and status handling.
- Worker class both performs calculations and prints data.

3. OCP Violation: Control::print_time function is not open for extension, so adding new time formats would require modifying this function directly.

4. Liskov Substitution Principle: This example does not have inheritance, but if Manage were a base class with specific fields, changes could lead to issues here as well.

5. ISP Violation: The DoWork class should not be required to know about the Worker class directly; rather, it could depend on a generic interface.

6. DIP Violation: DoWork directly depends on Worker, rather than an abstraction or interface, making it less flexible.

7. Comments: Some comments state the obvious, like "Print the status" or "Increment m_value by the input," which don't add value and clutter the code.
*/
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

class Control { // Violates SRP: Does multiple things like time logging and status handling
    public static void printTime() { // Violation of OCP: Adding more print formats would require modifying this method
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Time: " + now.format(formatter));
    }

    public void printStatus() {
        System.out.println("Status: Active");
    }
}

class Worker { // Poor class name; violates SRP as it does both work and printing
    private int mValue;
    private List<Integer> mData; // Unclear variable name

    public Worker(int value) {
        mValue = value;
        mData = new ArrayList<>();
    }

    public Worker() {
        this(0);
    }

    public void addValue(int val) { // Method name does not describe its full function
        mValue += val;
        mData.add(val);
    }

    public void printData() { // Inappropriate responsibility for printing, violating SRP
        System.out.print("Values: ");
        for (int v : mData) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}

class DoWork { // Poorly named, does not follow the Interface Segregation Principle
    public void performTask(Worker worker) { // Violates DIP: depends on low-level Worker class
        for (int i = 0; i < 5; i++) {
            worker.addValue(i);
        }
    }
}

public class CrappyStuffPart1WithComments {
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
