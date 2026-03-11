function InterfaceSegregationRefactored()
    % In this example:
    % - We split the interfaces into Workable, Eatable, and Sleepable.
    % - HumanWorker implements all three, while RobotWorker only Workable.
    % - Each class only depends on what it needs, adhering to ISP.

    human = HumanWorkerRef();
    robot = RobotWorkerRef();

    human.work();
    human.eat();
    human.sleep();

    robot.work();
end

classdef IWorkable < handle
    methods (Abstract)
        work(obj)
    end
end

classdef IEatable < handle
    methods (Abstract)
        eat(obj)
    end
end

classdef ISleepable < handle
    methods (Abstract)
        sleep(obj)
    end
end

% MATLAB supports multiple inheritance
classdef HumanWorkerRef < IWorkable & IEatable & ISleepable
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

classdef RobotWorkerRef < IWorkable
    methods
        function work(obj)
            fprintf('Robot is working...\n');
        end
    end
end
