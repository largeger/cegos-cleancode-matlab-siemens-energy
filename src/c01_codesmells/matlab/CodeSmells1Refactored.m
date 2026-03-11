function CodeSmells1Refactored()
    % Main entry point to demonstrate Refactored Code Smells

    fprintf('=== Process Order ===\n');
    processOrder();

    fprintf('\n=== Calculate Area ===\n');
    fprintf('Rectangle Area: %f\n', calculateArea(5, 10));
    fprintf('Square Area: %f\n', calculateArea(5));

    fprintf('\n=== Calculate Final Price ===\n');
    fprintf('Final Price: %f\n', calculateFinalPrice(100));

    fprintf('\n=== Order Processing ===\n');
    processor = OrderProcessor();
    processor.processOrder();

    fprintf('\n=== Process Order With New Tax ===\n');
    processOrderWithNewTax();

    fprintf('\n=== Logging Events ===\n');
    logEvent('Order processed');
    logEvent('Payment processed');

    fprintf('\n=== Calculate Shipping Cost ===\n');
    order = OrderEncapsulated(150, 3);
    fprintf('Shipping Cost: %f\n', order.calculateShippingCost());
end

% Extracted order processing steps into separate methods
function processOrder()
    validateOrder();
    applyDiscount();
    calculateTax();
    processPayment();
    sendConfirmationEmail();
end

function validateOrder()
    fprintf('Validating order...\n');
end

function applyDiscount()
    fprintf('Applying discount...\n');
end

function calculateTax()
    fprintf('Calculating tax...\n');
end

function processPayment()
    fprintf('Processing payment...\n');
end

function sendConfirmationEmail()
    fprintf('Sending confirmation email...\n');
end

% Eliminated duplicate code by using nargin for pseudo-overloading
function area = calculateArea(varargin)
    if nargin == 2
        width = varargin{1};
        height = varargin{2};
        area = width * height;
    elseif nargin == 1
        side = varargin{1};
        area = side * side;
    else
        error('Invalid number of arguments');
    end
end

% Removed magic number by using a local constant (or constant method)
function rate = TAX_RATE()
    rate = 0.08;
end

function price = calculateFinalPrice(price)
    price = price * TAX_RATE();
end

% Removed God Object by distributing responsibilities appropriately
classdef OrderProcessor
    methods
        function processOrder(obj)
            fprintf('Processing order...\n');
            % Note: In a real scenario, these would be calls to other classes
            % Here we call the local functions for simplicity
            CodeSmells1Refactored_internal_validateOrder();
            CodeSmells1Refactored_internal_applyDiscount();
            CodeSmells1Refactored_internal_calculateTax();
            CodeSmells1Refactored_internal_processPayment();
            CodeSmells1Refactored_internal_sendConfirmationEmail();
        end
    end
end

% Helper functions for OrderProcessor simulation
function CodeSmells1Refactored_internal_validateOrder(), fprintf('Validating order...\n'); end
function CodeSmells1Refactored_internal_applyDiscount(), fprintf('Applying discount...\n'); end
function CodeSmells1Refactored_internal_calculateTax(), fprintf('Calculating tax...\n'); end
function CodeSmells1Refactored_internal_processPayment(), fprintf('Processing payment...\n'); end
function CodeSmells1Refactored_internal_sendConfirmationEmail(), fprintf('Sending confirmation email...\n'); end

% Removed excessive comments and self-explanatory method
function auth = isAuthenticated()
    auth = true;
end

% Removed dead code
function processOrderWithNewTax()
    taxRate = 0.1;
    fprintf('Processing order with tax: %f\n', taxRate);
end

% Consolidated logging to avoid Shotgun Surgery
function logEvent(event)
    fprintf('%s\n', event);
end

% Improved encapsulation to avoid Feature Envy
classdef OrderEncapsulated
    properties
        price
        itemCount
    end
    methods
        function obj = OrderEncapsulated(price, itemCount)
            obj.price = price;
            obj.itemCount = itemCount;
        end
        function cost = calculateShippingCost(obj)
            if obj.itemCount > 5
                cost = 0;
                return;
            end
            if obj.price > 100
                cost = 5;
                return;
            end
            cost = 10;
        end
    end
end
