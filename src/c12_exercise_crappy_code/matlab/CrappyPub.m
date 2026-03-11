classdef CrappyPub < handle
    properties (Constant)
        ONE_BEER = 'hansa'
        ONE_CIDER = 'grans'
        A_PROPER_CIDER = 'strongbow'
        GT = 'gt'
        BACARDI_SPECIAL = 'bacardi_special'
    end

    methods
        function cost = computeCost(obj, drink, student, amount)
            if amount > 2 && (strcmp(drink, obj.GT) || strcmp(drink, obj.BACARDI_SPECIAL))
                error('Too many drinks, max 2.');
            end

            if strcmp(drink, obj.ONE_BEER)
                price = 74;
            elseif strcmp(drink, obj.ONE_CIDER)
                price = 103;
            elseif strcmp(drink, obj.A_PROPER_CIDER)
                price = 110;
            elseif strcmp(drink, obj.GT)
                price = obj.ingredient6() + obj.ingredient5() + obj.ingredient4();
            elseif strcmp(drink, obj.BACARDI_SPECIAL)
                price = floor(obj.ingredient6()/2) + obj.ingredient1() + obj.ingredient2() + obj.ingredient3();
            else
                error('No such drink exists');
            end

            if student && (strcmp(drink, obj.ONE_CIDER) || strcmp(drink, obj.ONE_BEER) || strcmp(drink, obj.A_PROPER_CIDER))
                price = price - floor(price/10);
            end

            cost = price * amount;
        end
    end

    methods (Access = private)
        % one unit of rum
        function val = ingredient1(obj), val = 65; end
        % one unit of grenadine
        function val = ingredient2(obj), val = 10; end
        % one unit of lime juice
        function val = ingredient3(obj), val = 10; end
        % one unit of green stuff
        function val = ingredient4(obj), val = 10; end
        % one unit of tonic water
        function val = ingredient5(obj), val = 20; end
        % one unit of gin
        function val = ingredient6(obj), val = 85; end
    end
end
