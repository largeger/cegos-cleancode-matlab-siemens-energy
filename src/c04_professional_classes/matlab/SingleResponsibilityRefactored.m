function SingleResponsibilityRefactored()
    % In this example:
    % - ReportRef is only responsible for handling and generating the report content.
    % - ReportFormatter takes care of formatting the report.
    % - ReportPrinter manages the output of the report.

    % Create a new report and perform the generation
    report = ReportRef('Annual Financial Summary');
    report.generate();

    % Create a ReportFormatter and format the report
    formatter = ReportFormatter();
    formattedReport = formatter.format(report);

    % Create a ReportPrinter and print the formatted report
    printer = ReportPrinter();
    printer.print(formattedReport);
end

classdef ReportRef < handle
    properties (Access = private)
        content
    end
    methods
        % Constructor to initialize the report content
        function obj = ReportRef(text)
            obj.content = text;
        end

        % Generates the report by prepending a string to the content
        function generate(obj)
            obj.content = ['Report Content: ', obj.content];
        end

        % Returns the content of the report
        function c = getContent(obj)
            c = obj.content;
        end
    end
end

classdef ReportFormatter
    methods
        % Formats the report content and returns the formatted version
        function str = format(obj, report)
            str = ['Formatted Report: ', report.getContent()];
        end
    end
end

classdef ReportPrinter
    methods
        % Prints the formatted report to the console
        function print(obj, formattedReport)
            fprintf('%s\n', formattedReport);
        end
    end
end
