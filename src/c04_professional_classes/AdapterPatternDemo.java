package c04_professional_classes;

public class AdapterPatternDemo {

    // Interface representing a square
    static interface Square {
        float getSideLength();
    }

    // Class representing a rectangle
    static class Rectangle {
        private float width;
        private float height;

        // Constructor to initialize width and height
        public Rectangle(float width, float height) {
            this.width = width;
            this.height = height;
        }

        public float getWidth() {
            return width;
        }

        public float getHeight() {
            return height;
        }
    }

    // Adapter Class: RectangleToSquareAdapter
    // This class adapts Rectangle to the Square interface. It holds a reference to
    // a Rectangle object and implements getSideLength. If the Rectangle is actually
    // square-like (width equals height), it returns the width as the side length;
    // otherwise, it prints a warning and returns 0.0f.
    static class RectangleToSquareAdapter implements Square {
        private Rectangle rectangle;

        // Constructor to initialize the rectangle
        public RectangleToSquareAdapter(Rectangle rectangle) {
            this.rectangle = rectangle;
        }

        // Method to get the side length of the square
        @Override
        public float getSideLength() {
            // Check if the rectangle is a square
            if (rectangle.getWidth() == rectangle.getHeight()) {
                return rectangle.getWidth();
            } else {
                // Print a warning if the rectangle is not a square
                System.err.println("Warning: Rectangle is not a square!");
                return 0.0f; // Or throw an exception depending on your requirements
            }
        }
    }

    // Client code
    // In main(), we create a "square" rectangle and a non-square rectangle. We then
    // use the RectangleToSquareAdapter to treat these rectangles as squares. The
    // adapter checks if the rectangle is a square and outputs the side length
    // accordingly.
    public static void main(String[] args) {
        // Create a rectangle that is a square
        Rectangle squareRect = new Rectangle(10.0f, 10.0f);
        // Create a rectangle that is not a square
        Rectangle nonSquareRect = new Rectangle(10.0f, 20.0f);

        // Create adapters for both rectangles
        Square squareAdapter = new RectangleToSquareAdapter(squareRect);
        Square nonSquareAdapter = new RectangleToSquareAdapter(nonSquareRect);

        // Print the side length of the square
        System.out.println("Square side length: " + squareAdapter.getSideLength());
        // Print the side length of the non-square (will print a warning and 0.0)
        System.out.println("Non-square side length: " + nonSquareAdapter.getSideLength());
    }

}
