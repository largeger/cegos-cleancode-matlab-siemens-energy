package c04_professional_classes.liskov.refactored;/*
In this example:

- We created a Shape interface with getArea as an abstract method.
- Rectangle and Square each have independent implementations of getArea.
- This design allows both Rectangle and Square to be used interchangeably in testArea without any unexpected behavior, preserving the Liskov Substitution Principle.
*/

interface Shape {
    int getArea();
}

class Rectangle implements Shape {
    protected int width;
    protected int height;

    public Rectangle(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public void setWidth(int w) {
        this.width = w;
    }

    public void setHeight(int h) {
        this.height = h;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

class Square implements Shape {
    private int side;

    public Square(int s) {
        this.side = s;
    }

    public void setSide(int s) {
        this.side = s;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}

public class LiskovExampleRefactored {
    public static void testArea(Shape shape) {
        System.out.println("Area: " + shape.getArea());
    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 10);
        testArea(rect);

        Square square = new Square(5);
        testArea(square);
    }
}
