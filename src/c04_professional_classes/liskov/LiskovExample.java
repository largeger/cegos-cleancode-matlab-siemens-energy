package c04_professional_classes.liskov;
/*
Explanation:
- Square overrides setWidth and setHeight to ensure both dimensions are the same, violating the expectation that setWidth and setHeight work independently.
- This breaks the Liskov Substitution Principle because Square doesn’t behave like a true Rectangle, leading to unexpected results in testArea().
*/

class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int w) {
        width = w;
    }

    public void setHeight(int h) {
        height = h;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int w) {
        width = w;
        height = w; // forces same width and height
    }

    @Override
    public void setHeight(int h) {
        width = h;
        height = h; // forces same height and width
    }
}

public class LiskovExample {
    public static void testArea(Rectangle rect) {
        rect.setWidth(5);
        rect.setHeight(10);
        System.out.println("Erwartete Fläche: 50, Tatsächliche Fläche: " + rect.getArea());
    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        testArea(rect); // expected: 50, actual: 50

        Square square = new Square();
        testArea(square); // expected: 50, actual: 100
    }
}
