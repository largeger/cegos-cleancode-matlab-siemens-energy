function SingleResponsibility()
    % In this example:
    % - The Report class has three responsibilities: generating the report, formatting it, and printing it.
    % - This violates the Single Responsibility Principle because changes in any of these
    %   functionalities could require changes in this one class, creating a tightly coupled design.

    % Create a new report and perform the generation and printing
    report = Report('Annual Financial Summary');
    report.generate();
    report.printReport();
end

classdef Report < handle
    properties (Access = private)
        content
    end
    methods
        % Constructor to initialize the report content
        function obj = Report(text)
            obj.content = text;
        end

        % Generates the report by prepending a string to the content
        function generate(obj)
            obj.content = ['Report Content: ', obj.content];
        end

        % Formats the report by returning a formatted string
        function str = formatReport(obj)
            str = ['Formatted Report: ', obj.content];
        end

        % Prints the formatted report to the console
        function printReport(obj)
            fprintf('%s\n', obj.formatReport());
        end
    end
end
