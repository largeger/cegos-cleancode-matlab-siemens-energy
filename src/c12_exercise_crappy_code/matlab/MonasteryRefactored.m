function MonasteryRefactored()
    monastery = Monastery();
    monastery.addMonk(MonkRef('Franz', 80, 'Brewmaster'));
    monastery.addMonk(MonkRef('Hans', 60, 'Cheesemaker'));
    monastery.addMonk(MonkRef('Karl', 40, 'Herbalist'));

    monastery.printAllMonks();
    monastery.printElderMonks();

    brewery = Brewery();
    brewery.brewBeer(3);

    inventory = Inventory();
    inventory.storeItem(InventoryItem('beer', 300));

    brewDuty = BrewDuty('Franz');
    cheeseDuty = CheeseDuty('Hans');

    brewDuty.performDuty();
    cheeseDuty.performDuty();
end

% Encapsulates behavior in the class itself
classdef MonkRef < handle
    properties (Access = private)
        name
        age
        role
    end
    methods
        function obj = MonkRef(name, age, role)
            obj.name = name;
            obj.age = age;
            obj.role = role;
        end

        function printInfo(obj) % Encapsulates behavior
            fprintf('%s is %d years old and works as a %s.\n', obj.name, obj.age, obj.role);
        end

        function elder = isElder(obj) % Meaningful behavior in the class
            elder = obj.age > 70;
        end

        function n = getName(obj)
            n = obj.name;
        end
    end
end

% Avoids God Class by separating functionalities
classdef Monastery < handle
    properties (Access = private)
        monks = {}
    end
    methods
        function addMonk(obj, monk)
            obj.monks{end+1} = monk;
        end

        function printAllMonks(obj)
            fprintf('Monks in the monastery:\n');
            for i = 1:length(obj.monks)
                monk = obj.monks{i};
                monk.printInfo(); % Avoids Feature Envy
            end
        end

        function printElderMonks(obj)
            fprintf('Elder monks:\n');
            for i = 1:length(obj.monks)
                monk = obj.monks{i};
                if monk.isElder()
                    fprintf('%s\n', monk.getName());
                end
            end
        end
    end
end

% Separates Brewery logic
classdef Brewery < handle
    methods
        function brewBeer(obj, monksAvailable)
            fprintf('%d monk(s) brewing beer...\n', monksAvailable);
            fprintf('Beer brewing process completed.\n');
        end
    end
end

% Encapsulates inventory items to avoid Primitive Obsession
classdef InventoryItem < handle
    properties (Access = private)
        itemName
        quantity
    end
    methods
        function obj = InventoryItem(name, qty)
            obj.itemName = name;
            obj.quantity = qty;
        end
        function storeItem(obj)
            fprintf('Storing %d units of %s.\n', obj.quantity, obj.itemName);
        end
    end
end

classdef Inventory < handle
    methods
        function storeItem(obj, item)
            if ~isempty(item)
                item.storeItem();
            else
                fprintf('Invalid item quantity.\n');
            end
        end
    end
end

% Uses polymorphism instead of switch statements
classdef IDuty < handle
    methods (Abstract)
        performDuty(obj)
    end
end

classdef BrewDuty < IDuty
    properties (Access = private)
        name
    end
    methods
        function obj = BrewDuty(monkName)
            obj.name = monkName;
        end
        function performDuty(obj)
            fprintf('%s is brewing beer.\n', obj.name);
        end
    end
end

classdef CheeseDuty < IDuty
    properties (Access = private)
        name
    end
    methods
        function obj = CheeseDuty(monkName)
            obj.name = monkName;
        end
        function performDuty(obj)
            fprintf('%s is making cheese.\n', obj.name);
        end
    end
end
