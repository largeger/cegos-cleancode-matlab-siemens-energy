function Coupling()
    % Explanation
    % 1. Tight Coupling (TightlyCoupledWeatherApp):
    %    - TightlyCoupledWeatherApp has a direct dependency on the APIService class.
    %    - Changing to another service, such as MockService, would require modifying TightlyCoupledWeatherApp to replace APIService with the new service.
    % 2. Loose Coupling (LooselyCoupledWeatherApp):
    %    - The LooselyCoupledWeatherApp depends on an interface IWeatherService, not a concrete implementation.
    %    - APIService and MockService implement IWeatherService, allowing LooselyCoupledWeatherApp to use any service that conforms to this interface.
    %    - Switching from LooseAPIService to MockService requires no changes to LooselyCoupledWeatherApp.

    % Tight Coupling Example
    fprintf('Tight Coupling Example:\n');
    tightlyCoupledApp = TightlyCoupledWeatherApp();
    tightlyCoupledApp.displayWeather();

    % Loose Coupling Example
    fprintf('\nLoose Coupling Example:\n');
    apiService = LooseAPIService();
    looselyCoupledApp = LooselyCoupledWeatherApp(apiService);
    looselyCoupledApp.displayWeather();

    % Switch to mock service without changing LooselyCoupledWeatherApp
    mockService = MockService();
    looselyCoupledAppWithMock = LooselyCoupledWeatherApp(mockService);
    looselyCoupledAppWithMock.displayWeather();
end

% Tight Coupling Example
classdef APIService
    methods
        function data = fetchWeatherData(obj)
            data = 'Sunny, 25°C from API Service';
        end
    end
end

classdef TightlyCoupledWeatherApp < handle
    properties
        service % Direct dependency on APIService
    end
    methods
        function obj = TightlyCoupledWeatherApp()
            obj.service = APIService(); % Initialize the service directly
        end
        function displayWeather(obj)
            fprintf('Weather: %s\n', obj.service.fetchWeatherData());
        end
    end
end

% Loose Coupling Example with "Interface" (Abstract Base Class)
classdef IWeatherService < handle
    methods (Abstract)
        data = fetchWeatherData(obj)
    end
end

classdef LooseAPIService < IWeatherService
    methods
        function data = fetchWeatherData(obj)
            data = 'Sunny, 25°C from Loose API Service';
        end
    end
end

classdef MockService < IWeatherService
    methods
        function data = fetchWeatherData(obj)
            data = 'Mock weather: Cloudy, 20°C';
        end
    end
end

classdef LooselyCoupledWeatherApp < handle
    properties
        service (1,1) IWeatherService % Dependency on "interface"
    end
    methods
        function obj = LooselyCoupledWeatherApp(service)
            obj.service = service; % Initialize the service via the constructor
        end
        function displayWeather(obj)
            fprintf('Weather: %s\n', obj.service.fetchWeatherData());
        end
    end
end
