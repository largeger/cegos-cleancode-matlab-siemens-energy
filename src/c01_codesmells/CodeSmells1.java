package c01_codesmells;

public class CodeSmells1 {

    // Long Function: Original
    public static void processOrderLong() {
        System.out.println("Processing order...");
        System.out.println("Validating order...");
        System.out.println("Applying discount...");
        System.out.println("Calculating tax...");
        System.out.println("Processing payment...");
        System.out.println("Sending confirmation email...");
    }

    // Duplicate Code: Original
    public static double calculateRectangleArea(double width, double height) {
        return width * height;
    }

    public static double calculateSquareArea(double side) {
        return side * side;
    }

    // Magic Number: Original
    public static double calculateFinalPriceMagic(double price) {
        return price * 0.08; // 0.08 is a magic number
    }

    // God Object: Original
    static class GodOrderProcessor {
        public void processOrder() {
            System.out.println("Processing order (God Object)...");
            // validate order
            // apply discount
            // calculate tax
            // process payment
            // send confirmation
        }
    }

    // Excessive Comments: Original
    /*
        This function checks if a user is authenticated.
        Parameters: None
        Returns: true if the user is authenticated, false otherwise
    */
    public static boolean check() {
        return true;
    }

    // Dead Code: Original
    public static void processOrderWithDeadCode() {
        double oldTax = 0.05; // Old tax calculation, no longer used -> remove!
        double newTax = 0.1; // New tax calculation
        System.out.println("Processing order with tax: " + newTax);
    }

    // Shotgun Surgery: Original
    public static void logOrderProcessed() {
        System.out.println("Order processed");
    }

    public static void logPaymentProcessed() {
        System.out.println("Payment processed");
    }

    // Feature Envy: Original
    static class Order {
        private double price;
        private int itemCount;

        public Order(double price, int itemCount) {
            this.price = price;
            this.itemCount = itemCount;
        }

        public double getPrice() {
            return price;
        }

        public int getItemCount() {
            return itemCount;
        }
    }

    static class OrderProcessorFeatureEnvy {
        public double calculateShippingCost(Order order) {
            if (order.getItemCount() > 5) return 0;
            if (order.getPrice() > 100) return 5;
            return 10;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Long Function ===");
        processOrderLong();

        System.out.println("\n=== Duplicate Code ===");
        System.out.println("Rectangle Area: " + calculateRectangleArea(5, 10));
        System.out.println("Square Area: " + calculateSquareArea(5));

        System.out.println("\n=== Magic Number ===");
        System.out.println("Final Price (Magic): " + calculateFinalPriceMagic(100));

        System.out.println("\n=== God Object ===");
        GodOrderProcessor godProcessor = new GodOrderProcessor();
        godProcessor.processOrder();

        System.out.println("\n=== Dead Code ===");
        processOrderWithDeadCode();

        System.out.println("\n=== Shotgun Surgery ===");
        logOrderProcessed();
        logPaymentProcessed();

        System.out.println("\n=== Feature Envy ===");
        Order order = new Order(150, 3);
        OrderProcessorFeatureEnvy processor = new OrderProcessorFeatureEnvy();
        System.out.println("Shipping Cost (Feature Envy): " + processor.calculateShippingCost(order));
    }
}
