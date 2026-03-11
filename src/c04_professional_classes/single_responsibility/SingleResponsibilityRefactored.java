package c04_professional_classes.single_responsibility;

/*
   In this example:

   - Report is only responsible for handling and generating the report content.
   - ReportFormatter takes care of formatting the report.
   - ReportPrinter manages the output of the report.
   */
public class SingleResponsibilityRefactored {


    static class Report {
        private String content;

        // Constructor to initialize the report content
        public Report(String text) {
            content = text;
        }

        // Generates the report by prepending a string to the content
        public void generate() {
            content = "Report Content: " + content;
        }

        // Returns the content of the report
        public String getContent() {
            return content;
        }
    }

    static class ReportFormatter {

        // Formats the report content and returns the formatted version
        public String format(Report report) {
            return "Formatted Report: " + report.getContent();
        }
    }

    static class ReportPrinter {

        // Prints the formatted report to the console
        public void print(String formattedReport) {
            System.out.println(formattedReport);
        }
    }

    public static void main(String[] args) {
        // Create a new report and perform the generation
        Report report = new Report("Annual Financial Summary");
        report.generate();

        // Create a ReportFormatter and format the report
        ReportFormatter formatter = new ReportFormatter();
        String formattedReport = formatter.format(report);

        // Create a ReportPrinter and print the formatted report
        ReportPrinter printer = new ReportPrinter();
        printer.print(formattedReport);
    }
}
