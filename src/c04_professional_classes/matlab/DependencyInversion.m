function DependencyInversion()
    % This implementation demonstrates a violation of the DIP.
    % The Manager class directly depends on the Worker and Robot classes,
    % making it difficult to extend or introduce new types of workers
    % without modifying the Manager class.

    worker = Worker();
    robot = Robot();
    manager = Manager(worker, robot);

    % Manager calls manage method to make Worker and Robot work
    manager.manage();
end

% Worker class representing a human worker
classdef Worker
    methods
        function work(obj)
            fprintf('Worker is working...\n');
        end
    end
end

% Robot class representing an automated worker
classdef Robot
    methods
        function work(obj)
            fprintf('Robot is working...\n');
        end
    end
end

% Manager class that directly depends on Worker and Robot classes
classdef Manager < handle
    properties (Access = private)
        worker
        robot
    end
    methods
        % Constructor taking specific Worker and Robot instances
        function obj = Manager(w, r)
            obj.worker = w;
            obj.robot = r;
        end

        % Method to manage both Worker and Robot
        function manage(obj)
            obj.worker.work();
            obj.robot.work();
        end
    end
end
