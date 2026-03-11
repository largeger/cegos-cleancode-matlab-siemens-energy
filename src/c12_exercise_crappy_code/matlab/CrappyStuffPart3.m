function CrappyStuffPart3()
    cm = CoffeeMachine();
    u = User();

    cm.status(); % Status check before making coffee
    u.wantsCoffee(cm); % User "wants" coffee
    u.addMilk(); % Adding milk in a vacuum
    u.addSugar(); % Adding sugar with no actual effect
    u.drink(); % Drinking imaginary coffee

    cm.refill(); % Refilling the machine
    cm.clean(); % Cleaning the machine
    cm.status(); % Final status check
end

classdef Coffee < handle
    properties
        type % Coffee type
        isHot
        s % Size
    end
    methods
        function obj = Coffee()
            obj.type = 1; % Default to "Espresso"
            obj.isHot = true;
            obj.s = 2; % Medium size
        end
        function printDetails(obj)
            fprintf('Coffee Type: %d, Size: %d, Hot: %d\n', obj.type, obj.s, obj.isHot);
        end
    end
end

classdef CoffeeMachine < handle
    properties
        beans % Amount of beans in grams
        water % Water level in ml
        isClean
    end
    methods
        function obj = CoffeeMachine()
            obj.beans = 100;
            obj.water = 500;
            obj.isClean = true;
        end
        function makeCoffee(obj, coffee)
            if obj.beans > 10 && obj.water > 50
                fprintf('Making coffee...\n');
                obj.beans = obj.beans - 10;
                obj.water = obj.water - 50;
                coffee.printDetails();
            else
                fprintf('Not enough beans or water!\n');
            end
        end
        function refill(obj)
            fprintf('Refilling beans and water...\n');
            obj.beans = 100;
            obj.water = 500;
        end
        function clean(obj)
            fprintf('Cleaning coffee machine...\n');
            obj.isClean = true;
        end
        function status(obj)
            fprintf('Beans: %dg, Water: %dml, Clean: %d\n', obj.beans, obj.water, obj.isClean);
        end
    end
end

classdef User < handle
    methods
        function wantsCoffee(obj, machine)
            coffee = Coffee(); % Default coffee
            fprintf('User wants coffee.\n');
            machine.makeCoffee(coffee); % Making coffee with machine
        end
        function addMilk(obj)
            fprintf('Adding milk...\n');
        end
        function addSugar(obj)
            fprintf('Adding sugar...\n');
        end
        function drink(obj)
            fprintf('Drinking coffee...\n');
        end
    end
end
