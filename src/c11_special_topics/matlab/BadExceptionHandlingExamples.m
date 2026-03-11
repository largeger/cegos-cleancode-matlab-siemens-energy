function BadExceptionHandlingExamples()
    swallowException();
    emptyCatchBlock();
    wrongExceptionType();
    catchGenericException();
    try
        rethrowGenericException();
    catch ME
        % Generic rethrow
        error('RuntimeException: %s', ME.message);
    end
    overuseTryCatch();
end

% 1. Exception wird geschluckt (Swallowing Exception)
function swallowException()
    try
        result = 10 / 0;
    catch
        % Exception wird ignoriert, keine Fehlermeldung
    end
end

% 2. Leerer Catch-Block (Silent Failure)
function emptyCatchBlock()
    try
        text = []; % Simulate null
        len = length(text.nonexistent);
    catch
        % Leerer Catch-Block - keine Fehlerbehandlung
    end
end

% 3. Falsche Exception gefangen (Wrong Exception Type)
function wrongExceptionType()
    try
        numbers = zeros(1, 5);
        numbers(10) = 42; % Index out of bounds
    catch ME
        if strcmp(ME.identifier, 'MATLAB:nonExistentField')
            fprintf('Falsche Exception gefangen.\n');
        end
    end
end

% 4. Fangen einer generischen Exception (Catching Generic Exception)
function catchGenericException()
    try
        error('MATLAB:custom:Error', 'Fehler aufgetreten');
    catch
        % Fängt alle Exceptions, verhindert gezielte Behandlung
        fprintf('Irgendein Fehler ist passiert.\n');
    end
end

% 5. Exception wird generisch erneut geworfen (Rethrowing Generic Exception)
function rethrowGenericException()
    try
        error('MATLAB:custom:StateError', 'Ein Fehler ist passiert');
    catch
        error('MATLAB:custom:GeneralError', 'Verallgemeinerte Exception'); % Verliert spezifische Info
    end
end

% 6. Übermäßige Nutzung von Try-Catch (Overuse of Try-Catch)
function overuseTryCatch()
    try
        x = 10;
        y = 20;
        sumVal = x + y;
        fprintf('Summe: %d\n', sumVal);
    catch
        fprintf('Dieser Try-Catch-Block ist überflüssig.\n');
    end
end
