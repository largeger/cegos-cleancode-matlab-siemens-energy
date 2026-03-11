function GoodExceptionHandlingExamples()
    try
        handleArithmeticException();
    catch ME
        fprintf(2, 'Fehler: %s\n', ME.message);
    end

    handleNullPointerException();
    handleSpecificException();
    handleProperException();
    try
        rethrowSpecificException();
    catch ME
        fprintf(2, 'Gefangen: %s\n', ME.message);
    end
    avoidUnnecessaryTryCatch();
end

% 1. Korrekte Behandlung von "ArithmeticException" (Division by zero check)
function handleArithmeticException()
    divisor = 0;
    if divisor == 0
        error('MATLAB:custom:DivByZero', 'Divisor darf nicht null sein');
    end
    result = 10 / divisor;
    fprintf('Ergebnis: %f\n', result);
end

% 2. NullPointerException vermeiden (Empty/Missing check)
function handleNullPointerException()
    text = [];
    if ~isempty(text)
        fprintf('Textlänge: %d\n', length(text));
    else
        fprintf(2, 'Fehler: Variable ''text'' ist leer\n');
    end
end

% 3. Fangen der richtigen Exception (Specific ID check)
function handleSpecificException()
    try
        numbers = zeros(1, 5);
        numbers(10) = 42;
    catch ME
        if strcmp(ME.identifier, 'MATLAB:badsubscript')
            fprintf(2, 'Fehler: Zugriff auf ungültigen Array-Index. %s\n', ME.message);
        else
            rethrow(ME);
        end
    end
end

% 4. Spezifische Fehlerbehandlung statt allgemeiner Exception
function handleProperException()
    try
        error('MATLAB:custom:InvalidArgument', 'Ungültiges Argument');
    catch ME
        if strcmp(ME.identifier, 'MATLAB:custom:InvalidArgument')
            fprintf(2, 'Fehler: %s\n', ME.message);
        else
            rethrow(ME);
        end
    end
end

% 5. Spezifische Exception weiterwerfen
function rethrowSpecificException()
    try
        error('MATLAB:custom:StateError', 'Ein Fehler ist passiert');
    catch ME
        % In MATLAB we can add to the exception cause or just wrap the message
        newME = MException('MATLAB:custom:DetailedError', ...
            'Detaillierte Fehlermeldung: %s', ME.message);
        throw(newME);
    end
end

% 6. Vermeidung unnötiger Try-Catch-Blöcke
function avoidUnnecessaryTryCatch()
    x = 10;
    y = 20;
    sumVal = x + y;
    fprintf('Summe: %d\n', sumVal);
end
