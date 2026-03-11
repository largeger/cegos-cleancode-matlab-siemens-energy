function CodeSmells3Refactored()
    % Demo for Refactored Temporary Fields, Message Chain, Middle Man,
    % Unnecessary Intimacy, Alternative Classes, and Incomplete Library Class

    temporaryFieldsExample();
    messageChainExample();
    middleManExample();
    unnecessaryIntimacyExample();
    alternativeClassesExample();
    incompleteLibraryClassExample();
end

% Temporary Fields Refactored
function temporaryFieldsExample()
    order = OrderRef();
    discount = order.calculateDiscount(6);
    fprintf('Refactored - Discount applied: %d%%\n', discount);
end

classdef OrderRef
    methods
        function discount = calculateDiscount(obj, days)
            if days > 5
                discount = 10;
            else
                discount = 0;
            end
        end
    end
end

% Message Chain Refactored
function messageChainExample()
    order = OrderMessageChainRef();
    order.printCustomerZipCode();
end

classdef AddressRef
    properties
        zipCode = '12345'
    end
end

classdef CustomerRef
    properties
        address = AddressRef()
    end
    methods
        function zip = getCustomerZipCode(obj)
            zip = obj.address.zipCode;
        end
    end
end

classdef OrderMessageChainRef
    properties
        customer = CustomerRef()
    end
    methods
        function printCustomerZipCode(obj)
            fprintf('Refactored - Zip Code: %s\n', obj.customer.getCustomerZipCode());
        end
    end
end

% Middle Man Removed
function middleManExample()
    car = CarNoMiddle();
    car.engine.start();
end

classdef EngineRef
    methods
        function start(obj)
            fprintf('Refactored - Engine starting...\n');
        end
    end
end

classdef CarNoMiddle
    properties
        engine = EngineRef()
    end
end

% Unnecessary Intimacy Removed
function unnecessaryIntimacyExample()
    password = PasswordRef('admin');
    auth = AuthenticatorRef();
    result = 'Failure';
    if auth.authenticate(password)
        result = 'Success';
    end
    fprintf('Refactored - Authentication: %s\n', result);
end

classdef PasswordRef
    properties (Access = private)
        secret
    end
    methods
        function obj = PasswordRef(s)
            obj.secret = s;
        end
        function ok = isValid(obj)
            ok = strcmp(obj.secret, 'admin');
        end
    end
end

classdef AuthenticatorRef
    methods
        function ok = authenticate(obj, password)
            ok = password.isValid();
        end
    end
end

% Alternative Classes with Unified Interface
function alternativeClassesExample()
    jsonParser = JsonParserRef();
    xmlParser = XmlParserRef();
    jsonParser.parse('{ "key": "value" }');
    xmlParser.parse('<key>value</key>');
end

classdef Parser < handle
    methods (Abstract)
        parse(obj, data)
    end
end

classdef JsonParserRef < Parser
    methods
        function parse(obj, data)
            fprintf('Refactored - Parsing JSON: %s\n', data);
        end
    end
end

classdef XmlParserRef < Parser
    methods
        function parse(obj, data)
            fprintf('Refactored - Parsing XML: %s\n', data);
        end
    end
end

% Incomplete Library Class Wrapped
function incompleteLibraryClassExample()
    modernLibrary = ModernLibrary();
    modernLibrary.performTask();
end

classdef LegacyLibraryRef
    methods
        function doLegacyWork(obj)
            fprintf('Refactored - Legacy work done\n');
        end
    end
end

classdef ModernLibrary
    properties
        legacyLibrary = LegacyLibraryRef()
    end
    methods
        function performTask(obj)
            obj.legacyLibrary.doLegacyWork();
        end
    end
end
