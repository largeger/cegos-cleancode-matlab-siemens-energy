function Polymorphism()
    % Explanation
    % Base Class (Animal):
    % The speak() method is declared abstract, making it polymorphic.
    % This allows derived classes to provide their specific implementation.
    % Derived Classes (Dog and Cat):
    % Both Dog and Cat override the speak() method to provide specific implementations.
    % Polymorphism in Action:
    % We create a cell array of Animal to hold different Animal types.
    % Using animal.speak(), the correct overridden method is called based on the
    % actual object type (Dog or Cat), demonstrating polymorphism.

    % Using polymorphism: a list of Animal objects, holding different derived types
    animals = {Dog(), Cat()};

    % Iterating through the list and calling speak() on each Animal
    for i = 1:length(animals)
        animal = animals{i};
        animal.speak(); % Calls the appropriate speak() method based on the actual object type
    end
end

% Base Class
classdef Animal < handle
    methods (Abstract)
        % Abstract method to be implemented by derived classes
        speak(obj)
    end
end

% Derived Class Dog
classdef Dog < Animal
    methods
        function speak(obj)
            fprintf('Woof Woof!\n');
        end
    end
end

% Derived Class Cat
classdef Cat < Animal
    methods
        function speak(obj)
            fprintf('Meow!\n');
        end
    end
end
