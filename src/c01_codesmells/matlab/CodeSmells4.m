function CodeSmells4()
    % Demo for Data Classes and Refused Bequest

    userData = UserData();
    userData.name = 'John';
    userData.age = 25;
    fprintf('User Name: %s, Age: %d\n', userData.name, userData.age);

    dog = Dog();
    dog.makeSound();
    dog.fly(); % Refused Bequest: Dog can fly?!
end

% Data Classes: Original
classdef UserData < handle
    properties
        name
        age
        email
        address
    end
end

% Refused Bequest: Original
classdef Animal < handle
    methods (Abstract)
        makeSound(obj)
    end
    methods
        function fly(obj)
            fprintf('This animal can fly.\n');
        end
    end
end

classdef Dog < Animal
    methods
        function makeSound(obj)
            fprintf('Bark!\n');
        end
    end
end
