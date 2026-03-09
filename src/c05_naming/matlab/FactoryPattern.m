function FactoryPattern()
    % Static Factory Methods: The Point class has two static methods:
    % - fromCartesian to create a point using Cartesian (x, y) coordinates.
    % - fromPolar to create a point using polar coordinates.
    % Private Constructor: The constructor for Point is private (simulated),
    % enforcing the use of the factory methods to create instances.

    % Create a Point using Cartesian coordinates
    upperLeft = Point.fromCartesian(10, 20);
    upperLeft.display();

    % Create a Point using Polar coordinates
    lowerRight = Point.fromPolar(10.0, 20.0);
    lowerRight.display();
end

classdef Point < handle
    properties (Access = private)
        x
        y
    end
    methods (Access = private)
        % Private constructor (simulated by access modifier)
        function obj = Point(x, y)
            obj.x = x;
            obj.y = y;
        end
    end
    methods
        function display(obj)
            fprintf('Point(%f, %f)\n', obj.x, obj.y);
        end
    end
    methods (Static)
        % Factory method for Cartesian coordinates
        function pt = fromCartesian(x, y)
            pt = Point(x, y);
        end

        % Factory method for Polar coordinates
        function pt = fromPolar(radius, angleInRadians)
            pt = Point(radius * cos(angleInRadians), radius * sin(angleInRadians));
        end
    end
end
