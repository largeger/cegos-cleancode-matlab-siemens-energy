function CodeSmells1()
    % Main entry point to demonstrate Code Smells

    fprintf('=== Long Function ===\n');
    processOrderLong();

    fprintf('\n=== Duplicate Code ===\n');
    fprintf('Rectangle Area: %f\n', calculateRectangleArea(5, 10));
    fprintf('Square Area: %f\n', calculateSquareArea(5));

    fprintf('\n=== Magic Number ===\n');
    fprintf('Final Price (Magic): %f\n', calculateFinalPriceMagic(100));

    fprintf('\n=== God Object ===\n');
    godProcessor = GodOrderProcessor();
    godProcessor.processOrder();

    fprintf('\n=== Dead Code ===\n');
    processOrderWithDeadCode();

    fprintf('\n=== Shotgun Surgery ===\n');
    logOrderProcessed();
    logPaymentProcessed();

    fprintf('\n=== Feature Envy ===\n');
    order = OrderEnvy(150, 3);
    processor = OrderProcessorFeatureEnvy();
    fprintf('Shipping Cost (Feature Envy): %f\n', processor.calculateShippingCost(order));
end

% Long Function: Original
function processOrderLong()
    fprintf('Processing order...\n');
    fprintf('Validating order...\n');
    fprintf('Applying discount...\n');
    fprintf('Calculating tax...\n');
    fprintf('Processing payment...\n');
    fprintf('Sending confirmation email...\n');
end

% Duplicate Code: Original
function area = calculateRectangleArea(width, height)
    area = width * height;
end

function area = calculateSquareArea(side)
    area = side * side;
end

% Magic Number: Original
function price = calculateFinalPriceMagic(price)
    price = price * 0.08; % 0.08 is a magic number
end

% God Object: Original
classdef GodOrderProcessor
    methods
        function processOrder(obj)
            fprintf('Processing order (God Object)...\n');
            % validate order
            % apply discount
            % calculate tax
            % process payment
            % send confirmation
        end
    end
end

% Excessive Comments: Original
%{
    This function checks if a user is authenticated.
    Parameters: None
    Returns: true if the user is authenticated, false otherwise
%}
function isAuth = check()
    isAuth = true;
end

% Dead Code: Original
function processOrderWithDeadCode()
    oldTax = 0.05; % Old tax calculation, no longer used -> remove!
    newTax = 0.1; % New tax calculation
    fprintf('Processing order with tax: %f\n', newTax);
end

% Shotgun Surgery: Original
function logOrderProcessed()
    fprintf('Order processed\n');
end

function logPaymentProcessed()
    fprintf('Payment processed\n');
end

% Feature Envy: Original
classdef OrderEnvy
    properties
        price
        itemCount
    end
    methods
        function obj = OrderEnvy(price, itemCount)
            obj.price = price;
            obj.itemCount = itemCount;
        end
    end
end

classdef OrderProcessorFeatureEnvy
    methods
        function cost = calculateShippingCost(obj, order)
            if order.itemCount > 5
                cost = 0;
                return;
            end
            if order.price > 100
                cost = 5;
                return;
            end
            cost = 10;
        end
    end
end
