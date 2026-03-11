package c01_codesmells;

public class CodeSmells3Refactored {

    // Temporary Fields Refactored
    static class Order {
        public int calculateDiscount(int days) {
            return days > 5 ? 10 : 0;
        }
    }

    public static void temporaryFieldsExample() {
        Order order = new Order();
        int discount = order.calculateDiscount(6);
        System.out.println("Refactored - Discount applied: " + discount + "%");
    }

    // Message Chain Refactored
    static class Address {
        private String zipCode = "12345";

        public String getZipCode() {
            return zipCode;
        }
    }

    static class Customer {
        private Address address = new Address();

        public String getCustomerZipCode() {
            return address.getZipCode();
        }
    }

    static class OrderMessageChain {
        private Customer customer = new Customer();

        public void printCustomerZipCode() {
            System.out.println("Refactored - Zip Code: " + customer.getCustomerZipCode());
        }
    }

    public static void messageChainExample() {
        OrderMessageChain order = new OrderMessageChain();
        order.printCustomerZipCode();
    }

    // Middle Man Removed
    static class Engine {
        public void start() {
            System.out.println("Refactored - Engine starting...");
        }
    }

    static class Car {
        private Engine engine = new Engine();

        public Engine getEngine() {
            return engine;
        }
    }

    public static void middleManExample() {
        Car car = new Car();
        car.getEngine().start();
    }

    // Unnecessary Intimacy Removed
    static class Password {
        private String secret;

        public Password(String s) {
            this.secret = s;
        }

        public boolean isValid() {
            return "admin".equals(secret);
        }
    }

    static class Authenticator {
        public boolean authenticate(Password password) {
            return password.isValid();
        }
    }

    public static void unnecessaryIntimacyExample() {
        Password password = new Password("admin");
        Authenticator auth = new Authenticator();
        System.out.println("Refactored - Authentication: " + (auth.authenticate(password) ? "Success" : "Failure"));
    }

    // Alternative Classes with Unified Interface
    interface Parser {
        void parse(String data);
    }

    static class JsonParser implements Parser {
        public void parse(String data) {
            System.out.println("Refactored - Parsing JSON: " + data);
        }
    }

    static class XmlParser implements Parser {
        public void parse(String data) {
            System.out.println("Refactored - Parsing XML: " + data);
        }
    }

    public static void alternativeClassesExample() {
        Parser jsonParser = new JsonParser();
        Parser xmlParser = new XmlParser();
        jsonParser.parse("{ \"key\": \"value\" }");
        xmlParser.parse("<key>value</key>");
    }

    // Incomplete Library Class Wrapped
    static class LegacyLibrary {
        public void doLegacyWork() {
            System.out.println("Refactored - Legacy work done");
        }
    }

    static class ModernLibrary {
        private LegacyLibrary legacyLibrary = new LegacyLibrary();

        public void performTask() {
            legacyLibrary.doLegacyWork();
        }
    }

    public static void incompleteLibraryClassExample() {
        ModernLibrary modernLibrary = new ModernLibrary();
        modernLibrary.performTask();
    }

    public static void main(String[] args) {
        temporaryFieldsExample();
        messageChainExample();
        middleManExample();
        unnecessaryIntimacyExample();
        alternativeClassesExample();
        incompleteLibraryClassExample();
    }
}

