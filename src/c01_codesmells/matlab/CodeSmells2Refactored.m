function CodeSmells2Refactored()
    % Demo for Refactored Data Clumps, Primitive Obsession, Polymorphism, and Unified Inheritance

    fprintf('=== Data Clumps (Refactored) ===\n');
    addr = Address('Main St 1', 'New York', 'NY', '10001');
    p = Person('John Doe', addr);
    p.printPersonDetails();

    fprintf('\n=== Primitive Obsession (Refactored) ===\n');
    price = Money(19.99, 'USD');
    order = ProductOrderRef(price, 2);
    order.printOrder();

    fprintf('\n=== Polymorphism (instead of Switch) ===\n');
    s1 = Circle();
    s1.draw();
    s2 = Square();
    s2.draw();

    fprintf('\n=== Unified Inheritance (instead of Parallel) ===\n');
    dog = DogRef();
    dog.makeSound();
    dog.playSound();
end

% Data Clumps: Refactored
classdef Address
    properties
        street, city, state, zip
    end
    methods
        function obj = Address(street, city, state, zip)
            obj.street = street;
            obj.city = city;
            obj.state = state;
            obj.zip = zip;
        end
        function str = getFullAddress(obj)
            str = sprintf('%s, %s, %s, %s', obj.street, obj.city, obj.state, obj.zip);
        end
    end
end

classdef Person
    properties
        name
        address
    end
    methods
        function obj = Person(name, address)
            obj.name = name;
            obj.address = address;
        end
        function printPersonDetails(obj)
            fprintf('Name: %s\n', obj.name);
            fprintf('Address: %s\n', obj.address.getFullAddress());
        end
    end
end

% Primitive Obsession: Refactored
classdef Money
    properties
        amount
        currency
    end
    methods
        function obj = Money(amount, currency)
            obj.amount = amount;
            obj.currency = currency;
        end
        function str = formatted(obj)
            str = sprintf('%s%f', obj.currency, obj.amount);
        end
    end
end

classdef ProductOrderRef
    properties
        price % Money object
        quantity
    end
    methods
        function obj = ProductOrderRef(price, quantity)
            obj.price = price;
            obj.quantity = quantity;
        end
        function printOrder(obj)
            fprintf('Order: %d items at %s\n', obj.quantity, obj.price.formatted());
        end
    end
end

% Case Statements: Refactored using Polymorphism
classdef ShapeRef < handle
    methods (Abstract)
        draw(obj)
    end
end

classdef Circle < ShapeRef
    methods
        function draw(obj)
            fprintf('Drawing a Circle\n');
        end
    end
end

classdef Square < ShapeRef
    methods
        function draw(obj)
            fprintf('Drawing a Square\n');
        end
    end
end

% Parallel Inheritance: Refactored
classdef AnimalRef < handle
    methods (Abstract)
        makeSound(obj)
    end
end

% MATLAB doesn't have interfaces, so we use multiple inheritance or composition
% Here we just add the method to the base or child.
classdef DogRef < AnimalRef
    methods
        function makeSound(obj)
            fprintf('Bark!\n');
        end
        function playSound(obj)
            fprintf('Squeak Bark!\n');
        end
    end
end
