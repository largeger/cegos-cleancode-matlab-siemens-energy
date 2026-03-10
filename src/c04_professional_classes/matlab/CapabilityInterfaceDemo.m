function CapabilityInterfaceDemo()
    bird = Bird();
    fish = Fish();

    bird.fly();
    fish.swim();
end

classdef IFlyable < handle
    methods (Abstract)
        fly(obj)
    end
end

classdef ISwimmable < handle
    methods (Abstract)
        swim(obj)
    end
end

classdef Bird < IFlyable
    methods
        function fly(obj)
            fprintf('Bird is flying...\n');
        end
    end
end

classdef Fish < ISwimmable
    methods
        function swim(obj)
            fprintf('Fish is swimming...\n');
        end
    end
end

classdef Duck < ISwimmable & IFlyable
    methods
        function swim(obj)
            fprintf('Duck is swimming...\n');
        end
        function fly(obj)
            fprintf('Duck is flying...\n');
        end
    end
end
