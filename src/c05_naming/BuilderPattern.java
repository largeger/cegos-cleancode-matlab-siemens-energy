package c05_naming;

/**
 * This class demonstrates the Builder Pattern by providing a PointBuilder class
 * to create instances of the Point class using a fluent API.
 */
public class BuilderPattern {

    static class Point {
        private double x, y;

        // Private constructor used by the builder
        private Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        // Display method to print the point's coordinates
        public void display() {
            System.out.println("Point(" + x + ", " + y + ")");
        }

        // PointBuilder class for fluent API
        static class PointBuilder {
            private float angle = 0.0f;
            private float distance = 0.0f;

            // Method to set the angle (in radians)
            public PointBuilder angleOf(float angleInRadians) {
                this.angle = angleInRadians;
                return this;
            }

            // Method to set the distance
            public PointBuilder distanceOf(float distanceValue) {
                this.distance = distanceValue;
                return this;
            }

            // Builds the Point object and returns it
            public Point andReturnIt() {
                return new Point(distance * Math.cos(angle), distance * Math.sin(angle));
            }
        }

        // Static method to initiate the builder
        public static PointBuilder buildWith() {
            return new PointBuilder();
        }
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        // Create a Point using the builder with fluent API
        Point lowerRight = Point.buildWith()
                .angleOf(10.0f)
                .distanceOf(20.0f)
                .andReturnIt();

        lowerRight.display();
    }

}
