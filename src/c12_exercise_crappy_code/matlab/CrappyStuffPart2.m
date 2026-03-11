function CrappyStuffPart2()
    c = CatObj();
    ca = CatAct();
    fd = Food();
    ck = CatKeeper();

    ck.feedCat(c, fd); % Cat is being fed
    ck.doSomethingWithCat(c, ca); % Cat does random action
    fd.displayMeals(); % Shows meals eaten
end

classdef CatObj < handle
    properties
        nm % Name of cat
        wt % Cat's weight
        sleepTime % Amount of sleep
    end
    methods
        function obj = CatObj() % Default constructor
            obj.nm = 'Garfield';
            obj.wt = 15;
            obj.sleepTime = 16; % Average hours a cat sleeps
        end
        function details(obj)
            fprintf('Name: %s, Weight: %d lbs, Sleep Time: %d hrs\n', obj.nm, obj.wt, obj.sleepTime);
        end
    end
end

classdef CatAct < handle
    methods
        function eat(obj, amount)
            fprintf('Cat is eating %d servings.\n', amount);
        end
        function nap(obj)
            fprintf('Cat is napping.\n');
        end
        function chaseMice(obj)
            % Chase mice function
            fprintf('Cat is chasing mice!\n');
        end
        function randomAction(obj, cat)
            action = randi([0, 2]);
            if action == 0
                obj.eat(2);
            elseif action == 1
                obj.nap();
            else
                obj.chaseMice();
            end
        end
    end
end

classdef Food < handle
    properties
        meals = {} % Meals eaten by cat
    end
    methods
        function addMeal(obj, meal)
            obj.meals{end+1} = meal; % Adds meal to list
        end
        function displayMeals(obj)
            fprintf('Meals eaten: ');
            for i = 1:length(obj.meals)
                fprintf('%s, ', obj.meals{i});
            end
            fprintf('\n');
        end
    end
end

classdef CatKeeper < handle
    methods
        function doSomethingWithCat(obj, cat, act)
            fprintf('Doing something with cat...\n');
            act.randomAction(cat);
        end
        function feedCat(obj, cat, food)
            fprintf('%s is being fed.\n', cat.nm);
            food.addMeal('Salmon');
        end
    end
end
