package c02_oop;

/*
Explanation
1. Tight Coupling (TightlyCoupledWeatherApp):
    - TightlyCoupledWeatherApp has a direct dependency on the APIService class.
    - Changing to another service, such as MockService, would require modifying TightlyCoupledWeatherApp to replace APIService with the new service.
2. Loose Coupling (LooselyCoupledWeatherApp):
    - The LooselyCoupledWeatherApp depends on an interface IWeatherService, not a concrete implementation.
    - APIService and MockService implement IWeatherService, allowing LooselyCoupledWeatherApp to use any service that conforms to this interface.
    - Switching from LooseAPIService to MockService requires no changes to LooselyCoupledWeatherApp.
*/
public class Coupling {

    // Tight Coupling Example
    static class APIService {
        public String fetchWeatherData() {
            return "Sunny, 25°C from API Service";
        }
    }

    static class TightlyCoupledWeatherApp {
        private APIService service; // Direct dependency on APIService

        public TightlyCoupledWeatherApp() {
            service = new APIService(); // Initialize the service directly
        }

        public void displayWeather() {
            System.out.println("Weather: " + service.fetchWeatherData());
        }
    }

    // Loose Coupling Example with Interface
    interface IWeatherService {
        String fetchWeatherData();
    }

    static class LooseAPIService implements IWeatherService {
        public String fetchWeatherData() {
            return "Sunny, 25°C from Loose API Service";
        }
    }

    static class MockService implements IWeatherService {
        public String fetchWeatherData() {
            return "Mock weather: Cloudy, 20°C";
        }
    }

    static class LooselyCoupledWeatherApp {
        private IWeatherService service; // Dependency on interface

        public LooselyCoupledWeatherApp(IWeatherService service) {
            this.service = service; // Initialize the service via the constructor
        }

        public void displayWeather() {
            System.out.println("Weather: " + service.fetchWeatherData());
        }
    }

    public static void main(String[] args) {
        // Tight Coupling Example
        System.out.println("Tight Coupling Example:");
        TightlyCoupledWeatherApp tightlyCoupledApp = new TightlyCoupledWeatherApp();
        tightlyCoupledApp.displayWeather();

        // Loose Coupling Example
        System.out.println("\nLoose Coupling Example:");
        IWeatherService apiService = new LooseAPIService();
        LooselyCoupledWeatherApp looselyCoupledApp = new LooselyCoupledWeatherApp(apiService);
        looselyCoupledApp.displayWeather();

        // Switch to mock service without changing LooselyCoupledWeatherApp
        IWeatherService mockService = new MockService();
        LooselyCoupledWeatherApp looselyCoupledAppWithMock = new LooselyCoupledWeatherApp(mockService);
        looselyCoupledAppWithMock.displayWeather();
    }

}
