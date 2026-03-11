function CodeSmells3()
    % Demo for Temporary Fields, Message Chain, Middle Man, Unnecessary Intimacy,
    % Alternative Classes, and Incomplete Library Class

    temporaryFieldsExample();
    messageChainExample();
    middleManExample();
    unnecessaryIntimacyExample();
    alternativeClassesExample();
    incompleteLibraryClassExample();
end

% Temporary Fields Example
function temporaryFieldsExample()
    order = OrderTemp();
    order.applyDiscount(6);
end

classdef OrderTemp < handle
    properties
        discount = 0
        discountDays = 0
    end
    methods
        function applyDiscount(obj, days)
            obj.discountDays = days;
            if obj.discountDays > 5
                obj.discount = 10;
            end
            fprintf('Temporary Fields - Discount applied: %d%%\n', obj.discount);
        end
    end
end

% Message Chain Example
function messageChainExample()
    order = OrderMessageChain();
    order.printCustomerZipCode();
end

classdef AddressChain
    methods
        function zip = getZipCode(obj)
            zip = '12345';
        end
    end
end

classdef CustomerChain
    properties
        address = AddressChain()
    end
end

classdef OrderMessageChain
    properties
        customer = CustomerChain()
    end
    methods
        function printCustomerZipCode(obj)
            fprintf('Message Chain - Zip Code: %s\n', obj.customer.address.getZipCode());
        end
    end
end

% Middle Man Example
function middleManExample()
    car = CarMiddle();
    car.startEngine();
end

classdef Engine
    methods
        function start(obj)
            fprintf('Middle Man - Engine starting...\n');
        end
    end
end

classdef CarMiddle
    properties
        engine = Engine()
    end
    methods
        function startEngine(obj)
            obj.engine.start();
        end
    end
end

% Unnecessary Intimacy Example
function unnecessaryIntimacyExample()
    password = PasswordIntim('admin');
    auth = Authenticator();
    result = 'Failure';
    if auth.authenticate(password)
        result = 'Success';
    end
    fprintf('Unnecessary Intimacy - Authentication: %s\n', result);
end

classdef PasswordIntim
    properties
        secret
    end
    methods
        function obj = PasswordIntim(s)
            obj.secret = s;
        end
    end
end

classdef Authenticator
    methods
        function ok = authenticate(obj, password)
            ok = strcmp(password.secret, 'admin');
        end
    end
end

% Alternative Classes with Different Interfaces Example
function alternativeClassesExample()
    jsonParser = JsonParser();
    xmlParser = XmlParser();
    jsonParser.parseJson('{ "key": "value" }');
    xmlParser.parseXml('<key>value</key>');
end

classdef JsonParser
    methods
        function parseJson(obj, data)
            fprintf('Alternative Classes - Parsing JSON: %s\n', data);
        end
    end
end

classdef XmlParser
    methods
        function parseXml(obj, data)
            fprintf('Alternative Classes - Parsing XML: %s\n', data);
        end
    end
end

% Incomplete Library Class Example
function incompleteLibraryClassExample()
    legacy = LegacyLibrary();
    legacy.doLegacyWork();
end

classdef LegacyLibrary
    methods
        function doLegacyWork(obj)
            fprintf('Incomplete Library Class - Legacy work done\n');
        end
    end
end
