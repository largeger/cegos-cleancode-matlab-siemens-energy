function BuilderPattern()
    % This class demonstrates the Builder Pattern by providing a PointBuilder class
    % to create instances of the Point class using a fluent API.

    % Create a Point using the builder with fluent API
    lowerRight = Point.buildWith() ...
                .angleOf(10.0) ...
                .distanceOf(20.0) ...
                .andReturnIt();

    lowerRight.display();
end

classdef Point < handle
    properties (Access = private)
        x
        y
    end
    methods
        % Constructor used by the builder
        function obj = Point(x, y)
            obj.x = x;
            obj.y = y;
        end
        % Display method to print the point's coordinates
        function display(obj)
            fprintf('Point(%f, %f)\n', obj.x, obj.y);
        end
    end
    methods (Static)
        % Static method to initiate the builder
        function builder = buildWith()
            builder = PointBuilder();
        end
    end
end

classdef PointBuilder < handle
    properties (Access = private)
        angle = 0.0
        distance = 0.0
    end
    methods
        % Method to set the angle (in radians)
        function obj = angleOf(obj, angleInRadians)
            obj.angle = angleInRadians;
        end
        % Method to set the distance
        function obj = distanceOf(obj, distanceValue)
            obj.distance = distanceValue;
        end
        % Builds the Point object and returns it
        function pt = andReturnIt(obj)
            pt = Point(obj.distance * cos(obj.angle), obj.distance * sin(obj.angle));
        end
    end
end
