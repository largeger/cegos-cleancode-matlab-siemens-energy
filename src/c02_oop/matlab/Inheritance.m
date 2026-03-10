function Inheritance()
    % Explanation
    % Base Class (Vehicle):
    % Contains common attributes and methods (like start() and honk()) that all vehicles share.
    % Derived Class Car:
    % Inherits from Vehicle and adds a specific attribute, doors.
    % Overrides honk() to provide a car-specific honking sound and includes an additional method, openDoors().
    % Derived Class Bike:
    % Inherits from Vehicle and adds a specific attribute, hasCarrier.
    % Overrides honk() to provide a bike-specific honking sound and includes an additional method, showCarrierStatus().

    myCar = Car('Toyota', 2022, 4);
    myBike = Bike('Yamaha', 2021, true);

    myCar.start();
    myCar.honk();
    myCar.openDoors();

    fprintf('\n');

    myBike.start();
    myBike.honk();
    myBike.showCarrierStatus();
end

classdef Vehicle < handle
    properties (Access = protected)
        brand
        year
    end
    methods
        function obj = Vehicle(brand, year)
            obj.brand = brand;
            obj.year = year;
        end
        function start(obj)
            fprintf('Starting the vehicle: %s (%d)\n', obj.brand, obj.year);
        end
        function honk(obj)
            fprintf('Vehicle honking!\n');
        end
    end
end

classdef Car < Vehicle
    properties (Access = private)
        doors
    end
    methods
        function obj = Car(brand, year, doors)
            obj@Vehicle(brand, year);
            obj.doors = doors;
        end
        function honk(obj)
            fprintf('Car honking: Beep Beep!\n');
        end
        function openDoors(obj)
            fprintf('Opening %d doors of the car.\n', obj.doors);
        end
    end
end

classdef Bike < Vehicle
    properties (Access = private)
        hasCarrier
    end
    methods
        function obj = Bike(brand, year, hasCarrier)
            obj@Vehicle(brand, year);
            obj.hasCarrier = hasCarrier;
        end
        function honk(obj)
            fprintf('Bike honking: Ring Ring!\n');
        end
        function showCarrierStatus(obj)
            status = 'No';
            if obj.hasCarrier, status = 'Yes'; end
            fprintf('Bike has a carrier: %s\n', status);
        end
    end
end
