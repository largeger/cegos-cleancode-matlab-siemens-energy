package c04_professional_classes.open_closed.refactored;

import java.util.List;

/*
In this example:
- Each shape class (Rectangle, Circle) implements a getArea method from the Shape interface.
- AreaCalculator uses polymorphism to calculate the total area without needing to know the specifics of each shape.
- This design adheres to the Open/Closed Principle since new shapes can be added by extending Shape without modifying AreaCalculator.
*/

// Shape interface enforcing the getArea method
interface Shape {
    double getArea();
}

// Rectangle class implementing Shape
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

// Circle class implementing Shape
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// AreaCalculator class using polymorphism
class AreaCalculator {
    public double calculateTotalArea(List<Shape> shapes) {
        double totalArea = 0.0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }
}

// Main class to demonstrate the functionality
public class OpenClosedPrincipleRefactored {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 10);
        Circle circ = new Circle(7);

        List<Shape> shapes = List.of(rect, circ);

        AreaCalculator calculator = new AreaCalculator();
        System.out.println("Total Area: " + calculator.calculateTotalArea(shapes));
    }
}
