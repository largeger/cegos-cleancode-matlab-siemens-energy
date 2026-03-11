function BmiCalculatorApp()
    % Einstiegspunkt der Anwendung – orchestriert den Ablauf

    repo = PersonRepository();
    repo.addPerson(Person('Alice', 1.65, 60));
    repo.addPerson(Person('Bob', 1.80, 90));
    repo.addPerson(Person('Charlie', 1.70, 70));
    repo.addPerson(Person('David', 1.90, 80));

    persons = repo.getAllPersons();
    calc = BmiCalculator();
    catService = BmiCategoryService();

    fprintf('--- BMI Ergebnisse ---\n');
    for i = 1:length(persons)
        p = persons{i};
        bmi = calc.calculate(p);
        category = catService.getCategory(bmi);
        fprintf('%s: BMI = %.2f (%s)\n', p.name, bmi, category);
    end

    statsService = BmiStatisticsService(persons, calc);
    stats = statsService.getStatistics();

    fprintf('\n--- Statistik ---\n');
    fprintf('Durchschnittlicher BMI: %.2f\n', stats.averageBmi);
    fprintf('Minimaler BMI: %.2f\n', stats.minBmi);
    fprintf('Maximaler BMI: %.2f\n', stats.maxBmi);
end

classdef Person < handle
    properties
        name
        height % in m
        weight % in kg
    end
    methods
        function obj = Person(name, height, weight)
            obj.name = name;
            obj.height = height;
            obj.weight = weight;
        end
    end
end

classdef BmiCalculator < handle
    methods
        function bmi = calculate(obj, person)
            if person.height <= 0
                error('Height must be positive');
            end
            bmi = person.weight / (person.height^2);
        end
    end
end

classdef BmiCategoryService < handle
    methods
        function cat = getCategory(obj, bmi)
            if bmi < 18.5, cat = 'Untergewicht';
            elseif bmi < 25, cat = 'Normalgewicht';
            elseif bmi < 30, cat = 'Übergewicht';
            else, cat = 'Adipositas';
            end
        end
    end
end

classdef BmiStatisticsService < handle
    properties (Access = private)
        persons
        calculator
    end
    methods
        function obj = BmiStatisticsService(persons, calculator)
            obj.persons = persons;
            obj.calculator = calculator;
        end
        function stats = getStatistics(obj)
            bmis = zeros(1, length(obj.persons));
            for i = 1:length(obj.persons)
                bmis(i) = obj.calculator.calculate(obj.persons{i});
            end
            stats.averageBmi = mean(bmis);
            stats.minBmi = min(bmis);
            stats.maxBmi = max(bmis);
        end
    end
end

classdef PersonRepository < handle
    properties (Access = private)
        persons = {}
    end
    methods
        function addPerson(obj, person)
            obj.persons{end+1} = person;
        end
        function p = getAllPersons(obj)
            p = obj.persons;
        end
    end
end
