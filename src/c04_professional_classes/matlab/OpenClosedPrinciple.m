function OpenClosedPrinciple()
    % In this example:
    % - AreaCalculator has to know about every shape type, checking the type string
    %   to calculate the area.
    % - This design violates the Open/Closed Principle because adding new shapes
    %   (e.g., Triangle) would require modifying calculateArea, leading to less
    %   maintainable code.

    rect = Rectangle(5, 10);
    circ = Circle(7);

    shapes = {rect, circ};

    calculator = AreaCalculator();
    totalArea = calculator.calculateArea(shapes, 'rectangle') + ...
                calculator.calculateArea(shapes, 'circle');

    fprintf('Total Area: %f\n', totalArea);
end

classdef Rectangle
    properties
        width
        height
    end
    methods
        function obj = Rectangle(width, height)
            obj.width = width;
            obj.height = height;
        end
    end
end

classdef Circle
    properties
        radius
    end
    methods
        function obj = Circle(radius)
            obj.radius = radius;
        end
    end
end

classdef AreaCalculator
    methods
        function area = calculateArea(obj, shapes, type)
            area = 0.0;
            for i = 1:length(shapes)
                shape = shapes{i};
                if strcmp(type, 'rectangle') && isa(shape, 'Rectangle')
                    area = area + shape.width * shape.height;
                elseif strcmp(type, 'circle') && isa(shape, 'Circle')
                    area = area + pi * shape.radius^2;
                end
                % New shape types require modifying this method
            end
        end
    end
end
