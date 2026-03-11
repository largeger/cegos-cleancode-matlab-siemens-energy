package c07_methods;

// Abstract class defining the template method
abstract class DocumentGenerator {
    // Template method
    public final void generateDocument() {
        collectData();
        formatContent();
        saveDocument();
    }

    protected abstract void collectData();
    protected abstract void formatContent();
    protected abstract void saveDocument();
}

// Concrete class implementing PDF document generation
class PDFGenerator extends DocumentGenerator {
    @Override
    protected void collectData() {
        System.out.println("Collecting data for PDF...");
    }

    @Override
    protected void formatContent() {
        System.out.println("Formatting content for PDF...");
    }

    @Override
    protected void saveDocument() {
        System.out.println("Saving as PDF file...");
    }
}

// Concrete class implementing Word document generation
class WordGenerator extends DocumentGenerator {
    @Override
    protected void collectData() {
        System.out.println("Collecting data for Word document...");
    }

    @Override
    protected void formatContent() {
        System.out.println("Formatting content for Word document...");
    }

    @Override
    protected void saveDocument() {
        System.out.println("Saving as Word file...");
    }
}

// Client code
public class TemplateMethod {
    public static void main(String[] args) {
        System.out.println("Generating PDF Document:");
        DocumentGenerator pdfGenerator = new PDFGenerator();
        pdfGenerator.generateDocument();

        System.out.println("\nGenerating Word Document:");
        DocumentGenerator wordGenerator = new WordGenerator();
        wordGenerator.generateDocument();
    }
}
