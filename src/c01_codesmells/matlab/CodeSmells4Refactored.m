function CodeSmells4Refactored()
    % Demo for Refactored Data Classes and Animal Hierarchy

    user = UserDataRef('John', 25, 'john@example.com', 'Main St');
    user.printUserSummary();
    if user.isAdult()
        fprintf('User is an adult.\n');
    end

    dog = DogRef();
    dog.makeSound();
    % dog.fly() would fail now, which is correct

    bird = Bird();
    bird.makeSound();
    bird.fly();
end

% Improved UserData class with meaningful behavior
classdef UserDataRef < handle
    properties
        name
        age
        email
        address
    end
    methods
        function obj = UserDataRef(name, age, email, address)
            obj.name = name;
            obj.age = age;
            obj.email = email;
            obj.address = address;
        end
        function printUserSummary(obj)
            fprintf('User: %s, Age: %d\n', obj.name, obj.age);
        end
        function adult = isAdult(obj)
            adult = obj.age >= 18;
        end
    end
end

% Properly structured Animal hierarchy
classdef AnimalBase < handle
    methods (Abstract)
        makeSound(obj)
    end
end

classdef FlyingAnimal < AnimalBase
    methods
        function fly(obj)
            fprintf('This animal can fly.\n');
        end
    end
end

classdef DogRef < AnimalBase
    methods
        function makeSound(obj)
            fprintf('Bark!\n');
        end
    end
end

classdef Bird < FlyingAnimal
    methods
        function makeSound(obj)
            fprintf('Tweet!\n');
        end
    end
end
