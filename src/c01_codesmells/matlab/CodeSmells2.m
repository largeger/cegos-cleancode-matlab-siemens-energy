function CodeSmells2()
    % Demo for Data Clumps, Primitive Obsession, Case Statements, and Parallel Inheritance

    fprintf('=== Data Clumps ===\n');
    printPersonDetails('John Doe', 'Main St 1', 'New York', 'NY', '10001');

    fprintf('\n=== Primitive Obsession ===\n');
    order = ProductOrder(19.99, 2, 'USD');
    order.printOrder();

    fprintf('\n=== Case Statements ===\n');
    s1 = Shape('CIRCLE');
    s1.draw();
    s2 = Shape('SQUARE');
    s2.draw();

    fprintf('\n=== Parallel Inheritance ===\n');
    dog = Dog();
    dog.makeSound();
    toy = DogToy();
    toy.playSound();
end

% Data Clumps: Original
function printPersonDetails(name, street, city, state, zip)
    fprintf('Name: %s\n', name);
    fprintf('Address: %s, %s, %s, %s\n', street, city, state, zip);
end

% Primitive Obsession: Original
classdef ProductOrder
    properties
        price
        quantity
        currency
    end
    methods
        function obj = ProductOrder(price, quantity, currency)
            obj.price = price;
            obj.quantity = quantity;
            obj.currency = currency;
        end
        function printOrder(obj)
            fprintf('Order: %d items at %s%f\n', obj.quantity, obj.currency, obj.price);
        end
    end
end

% Case Statements in Object-Oriented Code: Original
classdef Shape
    properties
        type
    end
    methods
        function obj = Shape(type)
            obj.type = type;
        end
        function draw(obj)
            switch obj.type
                case 'CIRCLE'
                    fprintf('Drawing a Circle\n');
                case 'SQUARE'
                    fprintf('Drawing a Square\n');
                case 'TRIANGLE'
                    fprintf('Drawing a Triangle\n');
            end
        end
    end
end

% Parallel Inheritance: Original
classdef Animal < handle
    methods (Abstract)
        makeSound(obj)
    end
end

classdef Dog < Animal
    methods
        function makeSound(obj)
            fprintf('Bark!\n');
        end
    end
end

classdef AnimalToy < handle
    methods (Abstract)
        playSound(obj)
    end
end

classdef DogToy < AnimalToy
    methods
        function playSound(obj)
            fprintf('Squeak Bark!\n');
        end
    end
end
