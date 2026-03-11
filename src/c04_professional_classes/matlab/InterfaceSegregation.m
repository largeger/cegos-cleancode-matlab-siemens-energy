function InterfaceSegregation()
    % In this example:
    % - The Worker interface has methods work, eat, and sleep, which don’t all
    %   apply to both HumanWorker and RobotWorker.
    % - RobotWorker is forced to implement eat and sleep even though they’re
    %   irrelevant, violating the ISP.

    human = HumanWorker();
    robot = RobotWorker();

    human.work();
    human.eat();
    human.sleep();

    robot.work();
    % eat() and sleep() methods are implemented but unnecessary for RobotWorker.
end

classdef IWorker < handle
    methods (Abstract)
        work(obj)
        eat(obj)
        sleep(obj)
    end
end

classdef HumanWorker < IWorker
    methods
        function work(obj)
            fprintf('Human is working...\n');
        end
        function eat(obj)
            fprintf('Human is eating...\n');
        end
        function sleep(obj)
            fprintf('Human is sleeping...\n');
        end
    end
end

classdef RobotWorker < IWorker
    methods
        function work(obj)
            fprintf('Robot is working...\n');
        end
        function eat(obj)
            % Robot doesn't eat, but must implement this method.
        end
        function sleep(obj)
            % Robot doesn't sleep, but must implement this method.
        end
    end
end
