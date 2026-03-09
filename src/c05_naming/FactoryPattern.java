package c05_naming;

/*
Explanation
- Static Factory Methods: The Point class has two static methods:
    - FromCartesian to create a point using Cartesian (x, y) coordinates.
    - FromPolar to create a point using polar coordinates, where radius is the distance from the origin and angleInRadians is the angle from the positive x-axis.
- Private Constructor: The constructor for Point is private, enforcing the use of the factory methods to create instances.
- Usage: In the main() method, we demonstrate the creation of Point objects using both Cartesian and Polar coordinates, similar to the provided example syntax.
*/
public class FactoryPattern {
static class Point {
    private double x, y;

    // Private constructor to force the use of factory methods
    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point fromCartesian(float x, float y) {
        return new Point(x, y);
    }

    // Factory method for Polar coordinates
    public static Point fromPolar(float radius, float angleInRadians) {
        return new Point(radius * Math.cos(angleInRadians), radius * Math.sin(angleInRadians));
    }

    public void display() {
        System.out.println("Point(" + x + ", " + y + ")");
    }

    public static void main(String[] args) {
        // Create a Point using Cartesian coordinates
        Point upperLeft = Point.fromCartesian(10, 20);
        upperLeft.display();

        // Create a Point using Polar coordinates
        Point lowerRight = Point.fromPolar(10.0f, 20.0f);
        lowerRight.display();
    }
}

}
