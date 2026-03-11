function AdapterPatternDemo()
    % Create a rectangle that is a square
    squareRect = Rectangle(10.0, 10.0);
    % Create a rectangle that is not a square
    nonSquareRect = Rectangle(10.0, 20.0);

    % Create adapters for both rectangles
    squareAdapter = RectangleToSquareAdapter(squareRect);
    nonSquareAdapter = RectangleToSquareAdapter(nonSquareRect);

    % Print the side length of the square
    fprintf('Square side length: %f\n', squareAdapter.getSideLength());
    % Print the side length of the non-square (will print a warning and 0.0)
    fprintf('Non-square side length: %f\n', nonSquareAdapter.getSideLength());
end

% "Interface" representing a square
classdef ISquare < handle
    methods (Abstract)
        len = getSideLength(obj)
    end
end

% Class representing a rectangle
classdef Rectangle < handle
    properties (Access = private)
        width
        height
    end
    methods
        % Constructor to initialize width and height
        function obj = Rectangle(width, height)
            obj.width = width;
            obj.height = height;
        end

        function w = getWidth(obj)
            w = obj.width;
        end

        function h = getHeight(obj)
            h = obj.height;
        end
    end
end

% Adapter Class: RectangleToSquareAdapter
classdef RectangleToSquareAdapter < ISquare
    properties (Access = private)
        rectangle
    end
    methods
        % Constructor to initialize the rectangle
        function obj = RectangleToSquareAdapter(rectangle)
            obj.rectangle = rectangle;
        end

        % Method to get the side length of the square
        function len = getSideLength(obj)
            % Check if the rectangle is a square
            if obj.rectangle.getWidth() == obj.rectangle.getHeight()
                len = obj.rectangle.getWidth();
            else
                % Print a warning if the rectangle is not a square
                warning('Rectangle is not a square!');
                len = 0.0;
            end
        end
    end
end
