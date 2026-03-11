function DependencyInversionRefactored()
    % In this example:
    % - We create an IWorker interface (abstract class) that Worker and Robot implement.
    % - The ManagerRef class depends on the IWorker abstraction, not specific
    %   worker implementations.
    % - This adheres to DIP, allowing the ManagerRef class to work with any class
    %   that implements IWorker.

    manager = ManagerRef();
    manager.addWorker(WorkerRef());
    manager.addWorker(RobotRef());
    manager.manage();
end

classdef IWorker < handle
    methods (Abstract)
        work(obj)
    end
end

classdef WorkerRef < IWorker
    methods
        function work(obj)
            fprintf('Worker is working...\n');
        end
    end
end

classdef RobotRef < IWorker
    methods
        function work(obj)
            fprintf('Robot is working...\n');
        end
    end
end

classdef ManagerRef < handle
    properties (Access = private)
        workers = {}
    end
    methods
        function addWorker(obj, worker)
            obj.workers{end+1} = worker;
        end
        function manage(obj)
            for i = 1:length(obj.workers)
                worker = obj.workers{i};
                worker.work();
            end
        end
    end
end
