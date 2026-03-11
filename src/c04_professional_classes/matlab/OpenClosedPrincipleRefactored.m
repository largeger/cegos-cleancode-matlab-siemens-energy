function OpenClosedPrincipleRefactored()
    % In this example:
    % - Each shape class (RectangleRef, CircleRef) implements a getArea method
    %   from the Shape interface (abstract base class).
    % - AreaCalculatorRef uses polymorphism to calculate the total area without
    %   needing to know the specifics of each shape.
    % - This design adheres to the Open/Closed Principle since new shapes can be
    %   added by extending Shape without modifying AreaCalculator.

    rect = RectangleRef(5, 10);
    circ = CircleRef(7);

    shapes = {rect, circ};

    calculator = AreaCalculatorRef();
    fprintf('Total Area: %f\n', calculator.calculateTotalArea(shapes));
end

% Shape interface enforcing the getArea method
classdef Shape < handle
    methods (Abstract)
        area = getArea(obj)
    end
end

% Rectangle class implementing Shape
classdef RectangleRef < Shape
    properties (Access = private)
        width
        height
    end
    methods
        function obj = RectangleRef(width, height)
            obj.width = width;
            obj.height = height;
        end
        function a = getArea(obj)
            a = obj.width * obj.height;
        end
    end
end

% Circle class implementing Shape
classdef CircleRef < Shape
    properties (Access = private)
        radius
    end
    methods
        function obj = CircleRef(radius)
            obj.radius = radius;
        end
        function a = getArea(obj)
            a = pi * obj.radius^2;
        end
    end
end

% AreaCalculator class using polymorphism
classdef AreaCalculatorRef
    methods
        function totalArea = calculateTotalArea(obj, shapes)
            totalArea = 0.0;
            for i = 1:length(shapes)
                shape = shapes{i};
                totalArea = totalArea + shape.getArea();
            end
        end
    end
end
