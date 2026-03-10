function Association()
    % Explanation
    % Composition:
    % Car contains an Engine object. The Engine is created when the Car is constructed,
    % and it can't exist outside of it.
    %
    % Aggregation:
    % Car has a Driver object. This allows the Driver to exist independently and
    % be shared with other instances of Car.

    % Composition: Car contains an Engine
    myCar = Car('Toyota', 'V8');

    % Aggregation: Driver is shared and can be assigned to different cars
    driver = Driver('Alice');
    myCar.setDriver(driver);

    myCar.start(); % Start the car with the assigned driver
end

classdef Engine < handle
    properties (Access = private)
        model
    end
    methods
        function obj = Engine(model)
            obj.model = model;
        end
        function start(obj)
            fprintf('Engine %s started.\n', obj.model);
        end
        function m = getModel(obj)
            m = obj.model;
        end
    end
end

classdef Driver < handle
    properties (Access = private)
        name
    end
    methods
        function obj = Driver(name)
            obj.name = name;
        end
        function drive(obj)
            fprintf('Driver %s is driving.\n', obj.name);
        end
        function n = getName(obj)
            n = obj.name;
        end
    end
end

classdef Car < handle
    properties (Access = private)
        brand
        engine % Composition: Car *owns* the engine
        driver % Aggregation: Car *uses* the driver
    end
    methods
        function obj = Car(brand, engineModel)
            obj.brand = brand;
            obj.engine = Engine(engineModel);
        end
        function setDriver(obj, driver)
            obj.driver = driver;
        end
        function start(obj)
            fprintf('Car %s is starting.\n', obj.brand);
            obj.engine.start();
            if ~isempty(obj.driver)
                obj.driver.drive();
            else
                fprintf('No driver assigned.\n');
            end
        end
    end
end
