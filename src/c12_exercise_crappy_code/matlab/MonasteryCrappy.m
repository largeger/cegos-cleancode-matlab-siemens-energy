function MonasteryCrappy()
    manager = MonasteryManager();
    manager.monks{end+1} = Monk('Franz', 80, 'Brewmaster');
    manager.monks{end+1} = Monk('Hans', 60, 'Cheesemaker');
    manager.monks{end+1} = Monk('Karl', 40, 'Herbalist');

    manager.printAllMonks();
    manager.printElderMonks();
    manager.manageBrewery(3, 400);
    manager.manageInventory('beer', 300);
    manager.monitorAirQuality(150);
    manager.giveMonkRaise(manager.monks{1});
    manager.performDuties(manager.monks{2});
end

classdef Monk < handle
    properties
        name
        age
        role
    end
    methods
        function obj = Monk(name, age, role)
            obj.name = name;
            obj.age = age;
            obj.role = role;
        end
    end
end

classdef Library < handle
    methods
        function catalog(obj)
            fprintf('Cataloging ancient scrolls...\n');
        end
    end
end

classdef MonasteryManager < handle
    properties
        monks = {}
        library = Library()
    end
    methods
        function printMonkInfo(obj, monk)
            fprintf('%s is %d years old and works as a %s.\n', monk.name, monk.age, monk.role);
        end

        function printAllMonks(obj)
            fprintf('Monks in the monastery:\n');
            for i = 1:length(obj.monks)
                monk = obj.monks{i};
                fprintf('%s\n', monk.name);
            end
        end

        function printElderMonks(obj)
            fprintf('Elder monks:\n');
            for i = 1:length(obj.monks)
                monk = obj.monks{i};
                if monk.age > 70
                    fprintf('%s\n', monk.name);
                end
            end
        end

        function manageBrewery(obj, monksAvailable, beerBottles)
            if monksAvailable < 1
                fprintf('Not enough monks to brew beer.\n');
                return;
            end
            if beerBottles > 500
                fprintf('Too much beer! The brewery is overflowing!\n');
                return;
            end
            if monksAvailable >= 3
                fprintf('Three monks are brewing beer...\n');
            elseif monksAvailable == 2
                fprintf('Two monks are brewing beer.\n');
            else
                fprintf('One monk is brewing beer.\n');
            end
            fprintf('Beer brewing process completed.\n');
        end

        function manageInventory(obj, item, quantity)
            if quantity > 0
                fprintf('Storing %d %s(s).\n', quantity, item);
            else
                fprintf('Invalid item or quantity.\n');
            end
        end

        function monitorAirQuality(obj, days)
            if days > 100
                fprintf('Monitoring air quality over %d days is too excessive.\n', days);
            end
        end

        function giveMonkRaise(obj, monk)
            if strcmp('Brewmaster', monk.role)
                monk.age = monk.age + 1;
                fprintf('%s received a raise for his brewmaster skills!\n', monk.name);
            end
        end

        function performDuties(obj, monk)
            switch monk.role
                case 'Brewmaster'
                    fprintf('%s is brewing beer.\n', monk.name);
                case 'Cheesemaker'
                    fprintf('%s is making cheese.\n', monk.name);
                case 'Herbalist'
                    fprintf('%s is gathering herbs.\n', monk.name);
                otherwise
                    fprintf('%s has an unknown role.\n', monk.name);
            end
        end
    end
end
