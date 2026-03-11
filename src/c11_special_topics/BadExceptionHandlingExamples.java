package c11_special_topics;

public class BadExceptionHandlingExamples {
    public static void main(String[] args) {
        swallowException();
        emptyCatchBlock();
        wrongExceptionType();
        catchGenericException();
        try {
            rethrowGenericException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        overuseTryCatch();
    }

    // 1. Exception wird geschluckt (Swallowing Exception)
    public static void swallowException() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // Exception wird ignoriert, keine Fehlermeldung
        }
    }

    // 2. Leerer Catch-Block (Silent Failure)
    public static void emptyCatchBlock() {
        try {
            String text = null;
            text.length(); // NullPointerException
        } catch (NullPointerException e) {
            // Leerer Catch-Block - keine Fehlerbehandlung
        }
    }

    // 3. Falsche Exception gefangen (Wrong Exception Type)
    public static void wrongExceptionType() {
        try {
            int[] numbers = new int[5];
            numbers[10] = 42; // ArrayIndexOutOfBoundsException
        } catch (NullPointerException e) {
            System.out.println("Falsche Exception gefangen.");
        }
    }

    // 4. Fangen einer generischen Exception (Catching Generic Exception)
    public static void catchGenericException() {
        try {
            throw new IllegalArgumentException("Fehler aufgetreten");
        } catch (Exception e) { // Fängt alle Exceptions, verhindert gezielte Behandlung
            System.out.println("Irgendein Fehler ist passiert.");
        }
    }

    // 5. Exception wird generisch erneut geworfen (Rethrowing Generic Exception)
    public static void rethrowGenericException() throws Exception {
        try {
            throw new IllegalStateException("Ein Fehler ist passiert");
        } catch (IllegalStateException e) {
            throw new Exception("Verallgemeinerte Exception"); // Verliert spezifische Info
        }
    }

    // 6. Übermäßige Nutzung von Try-Catch (Overuse of Try-Catch)
    public static void overuseTryCatch() {
        try {
            int x = 10;
            int y = 20;
            int sum = x + y;
            System.out.println("Summe: " + sum);
        } catch (Exception e) {
            System.out.println("Dieser Try-Catch-Block ist überflüssig.");
        }
    }
}

