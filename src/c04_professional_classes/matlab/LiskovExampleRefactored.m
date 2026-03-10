function LiskovExampleRefactored()
    % In this example:
    % - We created a Shape interface (abstract base class) with getArea.
    % - RectangleRef and SquareRef each have independent implementations of getArea.
    % - This design allows both Rectangle and Square to be used interchangeably
    %   in testArea without any unexpected behavior, preserving the LSP.

    rect = RectangleRef(5, 10);
    testArea(rect);

    square = SquareRef(5);
    testArea(square);
end

function testArea(shape)
    fprintf('Area: %d\n', shape.getArea());
end

classdef IShape < handle
    methods (Abstract)
        a = getArea(obj)
    end
end

classdef RectangleRef < IShape
    properties (Access = protected)
        width
        height
    end
    methods
        function obj = RectangleRef(w, h)
            obj.width = w;
            obj.height = h;
        end
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

classdef SquareRef < IShape
    properties (Access = private)
        side
    end
    methods
        function obj = SquareRef(s)
            obj.side = s;
        end
        function setSide(obj, s)
            obj.side = s;
        end
        function a = getArea(obj)
            a = obj.side * obj.side;
        end
    end
end
