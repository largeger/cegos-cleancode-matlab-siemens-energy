package c04_professional_classes.open_closed;

import java.util.List;

/*
In this example:
- AreaCalculator has to know about every shape type, checking the type string to calculate the area.
- This design violates the Open/Closed Principle because adding new shapes (e.g., Triangle) would require modifying calculateArea, leading to less maintainable code.
*/

// Rectangle class representing a rectangle shape
class Rectangle {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
}

// Circle class representing a circle shape
class Circle {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
}

// AreaCalculator class responsible for calculating the area of different shapes
class AreaCalculator {
    public double calculateArea(List<Object> shapes, String type) {
        double area = 0.0;
        for (Object shape : shapes) {
            if (type.equals("rectangle") && shape instanceof Rectangle) {
                Rectangle rect = (Rectangle) shape;
                area += rect.width * rect.height;
            } else if (type.equals("circle") && shape instanceof Circle) {
                Circle circ = (Circle) shape;
                area += Math.PI * circ.radius * circ.radius;
            }
            // New shape types require modifying this method
        }
        return area;
    }
}

// Main class to demonstrate the functionality
public class OpenClosedPrinciple {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 10);
        Circle circ = new Circle(7);

        List<Object> shapes = List.of(rect, circ);

        AreaCalculator calculator = new AreaCalculator();
        double totalArea = calculator.calculateArea(shapes, "rectangle") +
                           calculator.calculateArea(shapes, "circle");

        System.out.println("Total Area: " + totalArea);
    }
}
