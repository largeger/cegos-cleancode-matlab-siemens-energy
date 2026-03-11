function TemplateMethod()
    fprintf('Generating PDF Document:\n');
    pdfGenerator = PDFGenerator();
    pdfGenerator.generateDocument();

    fprintf('\nGenerating Word Document:\n');
    wordGenerator = WordGenerator();
    wordGenerator.generateDocument();
end

% Abstract class defining the template method
classdef DocumentGenerator < handle
    methods (Sealed)
        % Template method
        function generateDocument(obj)
            obj.collectData();
            obj.formatContent();
            obj.saveDocument();
        end
    end
    methods (Abstract, Access = protected)
        collectData(obj)
        formatContent(obj)
        saveDocument(obj)
    end
end

% Concrete class implementing PDF document generation
classdef PDFGenerator < DocumentGenerator
    methods (Access = protected)
        function collectData(obj)
            fprintf('Collecting data for PDF...\n');
        end
        function formatContent(obj)
            fprintf('Formatting content for PDF...\n');
        end
        function saveDocument(obj)
            fprintf('Saving as PDF file...\n');
        end
    end
end

% Concrete class implementing Word document generation
classdef WordGenerator < DocumentGenerator
    methods (Access = protected)
        function collectData(obj)
            fprintf('Collecting data for Word document...\n');
        end
        function formatContent(obj)
            fprintf('Formatting content for Word document...\n');
        end
        function saveDocument(obj)
            fprintf('Saving as Word file...\n');
        end
    end
end
