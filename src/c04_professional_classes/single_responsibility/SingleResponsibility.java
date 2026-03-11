package c04_professional_classes.single_responsibility;

/*
In this example:
- The Report class has three responsibilities: generating the report, formatting it, and printing it.
- This violates the Single Responsibility Principle because changes in any of these functionalities could require changes in this one class, creating a tightly coupled design.
*/
public class SingleResponsibility {
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

        // Formats the report by returning a formatted string
        public String formatReport() {
            return "Formatted Report: " + content;
        }

        // Prints the formatted report to the console
        public void printReport() {
            System.out.println(formatReport());
        }

        public static void main(String[] args) {
            // Create a new report and perform the generation and printing
            Report report = new Report("Annual Financial Summary");
            report.generate();
            report.printReport();
        }
    }
}
