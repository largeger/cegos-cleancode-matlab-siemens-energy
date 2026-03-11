function ComparableDemo()
    people = { ...
        Person('Alice', 165), ...
        Person('Bob', 175), ...
        Person('Charlie', 160), ...
        Person('David', 180), ...
        Person('Eve', 170) ...
    };

    people = bubbleSort(people);
    printArray(people);
end

function array = bubbleSort(array)
    n = length(array);
    for i = 1:n-1
        for j = i+1:n
            if array{i}.compareTo(array{j}) > 0
                temp = array{i};
                array{i} = array{j};
                array{j} = temp;
            end
        end
    end
end

function printArray(array)
    for i = 1:length(array)
        fprintf('%s ', array{i}.toString());
    end
    fprintf('\n');
end

classdef Person < handle
    properties (Access = private)
        name
        height
    end
    methods
        function obj = Person(name, height)
            obj.name = name;
            obj.height = height;
        end
        function n = getName(obj)
            n = obj.name;
        end
        function h = getHeight(obj)
            h = obj.height;
        end
        function res = compareTo(obj, other)
            res = obj.height - other.height;
        end
        function str = toString(obj)
            str = sprintf('%s (%d cm)', obj.name, obj.height);
        end
    end
end
