package c01_codesmells;

public class CodeSmells3 {

    // Temporary Fields Example
    static class Order {
        private int discount;
        private int discountDays;

        public Order() {
            this.discount = 0;
            this.discountDays = 0;
        }

        public void applyDiscount(int days) {
            this.discountDays = days;
            if (this.discountDays > 5) {
                this.discount = 10;
            }
            System.out.println("Temporary Fields - Discount applied: " + this.discount + "%");
        }
    }

    public static void temporaryFieldsExample() {
        Order order = new Order();
        order.applyDiscount(6);
    }

    // Message Chain Example
    static class Address {
        public String getZipCode() {
            return "12345";
        }
    }

    static class Customer {
        private Address address = new Address();

        public Address getAddress() {
            return address;
        }
    }

    static class OrderMessageChain {
        private Customer customer = new Customer();

        public void printCustomerZipCode() {
            System.out.println("Message Chain - Zip Code: " + customer.getAddress().getZipCode());
        }
    }

    public static void messageChainExample() {
        OrderMessageChain order = new OrderMessageChain();
        order.printCustomerZipCode();
    }

    // Middle Man Example
    static class Engine {
        public void start() {
            System.out.println("Middle Man - Engine starting...");
        }
    }

    static class Car {
        private Engine engine = new Engine();

        public void startEngine() {
            engine.start();
        }
    }

    public static void middleManExample() {
        Car car = new Car();
        car.startEngine();
    }

    // Unnecessary Intimacy Example
    static class Password {
        private String secret;

        public Password(String s) {
            this.secret = s;
        }

        public String getSecret() {
            return secret;
        }
    }

    static class Authenticator {
        public boolean authenticate(Password password) {
            return password.getSecret().equals("admin");
        }
    }

    public static void unnecessaryIntimacyExample() {
        Password password = new Password("admin");
        Authenticator auth = new Authenticator();
        System.out.println(
                "Unnecessary Intimacy - Authentication: " + (auth.authenticate(password) ? "Success" : "Failure"));
    }

    // Alternative Classes with Different Interfaces Example
    static class JsonParser {
        public void parseJson(String data) {
            System.out.println("Alternative Classes - Parsing JSON: " + data);
        }
    }

    static class XmlParser {
        public void parseXml(String data) {
            System.out.println("Alternative Classes - Parsing XML: " + data);
        }
    }

    public static void alternativeClassesExample() {
        JsonParser jsonParser = new JsonParser();
        XmlParser xmlParser = new XmlParser();
        jsonParser.parseJson("{ \"key\": \"value\" }");
        xmlParser.parseXml("<key>value</key>");
    }

    // Incomplete Library Class Example
    static class LegacyLibrary {
        public void doLegacyWork() {
            System.out.println("Incomplete Library Class - Legacy work done");
        }
    }

    public static void incompleteLibraryClassExample() {
        LegacyLibrary legacy = new LegacyLibrary();
        legacy.doLegacyWork();
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
