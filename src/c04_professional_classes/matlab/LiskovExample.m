function LiskovExample()
    % Explanation:
    % - Square overrides setWidth and setHeight to ensure both dimensions are the same,
    %   violating the expectation that setWidth and setHeight work independently.
    % - This breaks the Liskov Substitution Principle because Square doesn’t behave
    %   like a true Rectangle, leading to unexpected results in testArea().

    rect = Rectangle();
    testArea(rect); % expected: 50, actual: 50

    square = Square();
    testArea(square); % expected: 50, actual: 100
end

function testArea(rect)
    rect.setWidth(5);
    rect.setHeight(10);
    fprintf('Erwartete Fläche: 50, Tatsächliche Fläche: %d\n', rect.getArea());
end

classdef Rectangle < handle
    properties (Access = protected)
        width
        height
    end
    methods
        function setWidth(obj, w)
            obj.width = w;
        end
        function setHeight(obj, h)
            obj.height = h;
        end
        function a = getArea(obj)
            a = obj.width * obj.height;
        end
    end
end

classdef Square < Rectangle
    methods
        function setWidth(obj, w)
            obj.width = w;
            obj.height = w; % forces same width and height
        end
        function setHeight(obj, h)
            obj.width = h;
            obj.height = h; % forces same height and width
        end
    end
end
