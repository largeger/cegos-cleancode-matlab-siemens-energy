package c11_special_topics;

public class GoodExceptionHandlingExamples {
    public static void main(String[] args) {
        try {
            handleArithmeticException();
        } catch (ArithmeticException e) {
            System.err.println("Fehler: Division durch Null ist nicht erlaubt. " + e.getMessage());
        }

        handleNullPointerException();
        handleSpecificException();
        handleProperException();
        rethrowSpecificException();
        avoidUnnecessaryTryCatch();
    }

    // 1. Korrekte Behandlung von ArithmeticException
    public static void handleArithmeticException() {
        int divisor = 0;
        if (divisor == 0) {
            throw new ArithmeticException("Divisor darf nicht null sein");
        }
        int result = 10 / divisor;
        System.out.println("Ergebnis: " + result);
    }

    // 2. NullPointerException vermeiden
    public static void handleNullPointerException() {
        String text = null;
        if (text != null) {
            System.out.println("Textlänge: " + text.length());
        } else {
            System.err.println("Fehler: Variable 'text' ist null");
        }
    }

    // 3. Fangen der richtigen Exception
    public static void handleSpecificException() {
        try {
            int[] numbers = new int[5];
            numbers[10] = 42;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Fehler: Zugriff auf ungültigen Array-Index. " + e.getMessage());
        }
    }

    // 4. Spezifische Fehlerbehandlung statt allgemeiner Exception
    public static void handleProperException() {
        try {
            throw new IllegalArgumentException("Ungültiges Argument");
        } catch (IllegalArgumentException e) {
            System.err.println("Fehler: " + e.getMessage());
        }
    }

    // 5. Spezifische Exception weiterwerfen
    public static void rethrowSpecificException() throws IllegalStateException {
        try {
            throw new IllegalStateException("Ein Fehler ist passiert");
        } catch (IllegalStateException e) {
            throw new IllegalStateException("Detaillierte Fehlermeldung: " + e.getMessage(), e);
        }
    }

    // 6. Vermeidung unnötiger Try-Catch-Blöcke
    public static void avoidUnnecessaryTryCatch() {
        int x = 10;
        int y = 20;
        int sum = x + y;
        System.out.println("Summe: " + sum);
    }
}
