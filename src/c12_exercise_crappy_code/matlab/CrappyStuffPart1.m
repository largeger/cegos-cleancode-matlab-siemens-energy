function CrappyStuffPart1()
    manager = Manage();
    manager.setValues(25, 'Alice');
    manager.print();

    Control.printTime();
    controlObj = Control();
    controlObj.printStatus();

    worker = Worker();
    taskDoer = DoWork();
    taskDoer.performTask(worker);
    worker.printData();
end

classdef Manage < handle
    properties
        age
        nam % This variable represents the name
    end
    methods
        function obj = Manage()
            obj.age = 0;
            obj.nam = 'Unnamed';
        end
        function setValues(obj, a, n)
            obj.age = a;
            obj.nam = n;
        end
        function print(obj)
            fprintf('Name: %s, Age: %d\n', obj.nam, obj.age);
        end
    end
end

classdef Control < handle
    methods (Static)
        function printTime()
            nowTime = datetime('now');
            fprintf('Time: %s\n', datestr(nowTime, 'yyyy-mm-dd HH:MM:SS'));
        end
    end
    methods
        function printStatus(obj)
            % Print the status
            fprintf('Status: Active\n');
        end
    end
end

classdef Worker < handle
    properties (Access = private)
        mValue
        mData = []
    end
    methods
        function obj = Worker(value)
            if nargin < 1, value = 0; end
            obj.mValue = value;
        end
        function addValue(obj, val)
            obj.mValue = obj.mValue + val; % Increment mValue by the input
            obj.mData(end+1) = val; % Adds value to the data list
        end
        function printData(obj)
            fprintf('Values: ');
            for i = 1:length(obj.mData)
                fprintf('%d ', obj.mData(i));
            end
            fprintf('\n');
        end
    end
end

classdef DoWork < handle
    methods
        function performTask(obj, worker)
            for i = 0:4
                worker.addValue(i); % Adds incremental values to worker
            end
        end
    end
end
