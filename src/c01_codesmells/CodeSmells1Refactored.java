package c01_codesmells;

public class CodeSmells1Refactored {


        // Extracted order processing steps into separate methods
        public static void processOrder() {
            validateOrder();
            applyDiscount();
            calculateTax();
            processPayment();
            sendConfirmationEmail();
        }

        private static void validateOrder() {
            System.out.println("Validating order...");
        }

        private static void applyDiscount() {
            System.out.println("Applying discount...");
        }

        private static void calculateTax() {
            System.out.println("Calculating tax...");
        }

        private static void processPayment() {
            System.out.println("Processing payment...");
        }

        private static void sendConfirmationEmail() {
            System.out.println("Sending confirmation email...");
        }

        // Eliminated duplicate code by using method overloading
        public static double calculateArea(double width, double height) {
            return width * height;
        }

        public static double calculateArea(double side) {
            return side * side;
        }

        // Removed magic number by using a named constant
        private static final double TAX_RATE = 0.08;

        public static double calculateFinalPrice(double price) {
            return price * TAX_RATE;
        }

        // Removed God Object by distributing responsibilities appropriately
        static class OrderProcessor {
            public void processOrder() {
                System.out.println("Processing order...");
                validateOrder();
                applyDiscount();
                calculateTax();
                processPayment();
                sendConfirmationEmail();
            }
        }

        // Removed excessive comments and self-explanatory method
        public static boolean isAuthenticated() {
            return true;
        }

        // Removed dead code
        public static void processOrderWithNewTax() {
            double taxRate = 0.1;
            System.out.println("Processing order with tax: " + taxRate);
        }

        // Consolidated logging to avoid Shotgun Surgery
        public static void logEvent(String event) {
            System.out.println(event);
        }

        // Improved encapsulation to avoid Feature Envy
        static class Order {
            private double price;
            private int itemCount;

            public Order(double price, int itemCount) {
                this.price = price;
                this.itemCount = itemCount;
            }

            public double calculateShippingCost() {
                if (itemCount > 5) return 0;
                if (price > 100) return 5;
                return 10;
            }
        }

        public static void main(String[] args) {
            System.out.println("=== Process Order ===");
            processOrder();

            System.out.println("\n=== Calculate Area ===");
            System.out.println("Rectangle Area: " + calculateArea(5, 10));
            System.out.println("Square Area: " + calculateArea(5));

            System.out.println("\n=== Calculate Final Price ===");
            System.out.println("Final Price: " + calculateFinalPrice(100));

            System.out.println("\n=== Order Processing ===");
            OrderProcessor processor = new OrderProcessor();
            processor.processOrder();

            System.out.println("\n=== Process Order With New Tax ===");
            processOrderWithNewTax();

            System.out.println("\n=== Logging Events ===");
            logEvent("Order processed");
            logEvent("Payment processed");

            System.out.println("\n=== Calculate Shipping Cost ===");
            Order order = new Order(150, 3);
            System.out.println("Shipping Cost: " + order.calculateShippingCost());
        }


}
