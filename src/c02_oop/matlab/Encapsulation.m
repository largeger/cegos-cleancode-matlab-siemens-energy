function Encapsulation()
    % Explanation
    % Encapsulation through Access Modifiers:
    % The owner and balance variables are private, hiding them from external access.
    % Only methods within the BankAccount class can directly interact with these variables.
    % Public Interface:
    % The methods deposit(), withdraw(), getBalance(), and getOwner() provide controlled access to the private data.
    % This ensures that balance adjustments are made only through deposit() and withdraw() with specific checks.
    % Encapsulation Benefits:
    % The account's balance and owner data are protected from outside interference,
    % and the class enforces rules for valid transactions.

    account = BankAccount('Alice', 500.0); % Create account with initial balance of $500

    fprintf('Account owner: %s\n', account.getOwner());
    fprintf('Initial balance: $%.2f\n', account.getBalance());

    account.deposit(200.0); % Deposit $200
    fprintf('New balance: $%.2f\n', account.getBalance());

    account.withdraw(150.0); % Withdraw $150
    fprintf('New balance: $%.2f\n', account.getBalance());

    account.withdraw(700.0); % Attempt to withdraw more than the balance
    fprintf('Final balance: $%.2f\n', account.getBalance());
end

classdef BankAccount < handle
    properties (Access = private)
        owner   % Private member variable to store the owner's name
        balance % Private member variable to store the account balance
    end
    methods
        % Constructor to initialize account with owner's name and initial balance
        function obj = BankAccount(owner, initialBalance)
            obj.owner = owner;
            obj.balance = initialBalance;
        end

        % Public method to deposit money (positive value only)
        function deposit(obj, amount)
            if amount > 0
                obj.balance = obj.balance + amount;
                fprintf('Deposited: $%.2f\n', amount);
            else
                fprintf('Invalid deposit amount!\n');
            end
        end

        % Public method to withdraw money (ensures sufficient balance)
        function withdraw(obj, amount)
            if amount > 0 && amount <= obj.balance
                obj.balance = obj.balance - amount;
                fprintf('Withdrew: $%.2f\n', amount);
            else
                fprintf('Invalid withdrawal amount or insufficient funds!\n');
            end
        end

        % Public method to check balance (read-only access)
        function b = getBalance(obj)
            b = obj.balance;
        end

        % Public method to get the account owner's name
        function o = getOwner(obj)
            o = obj.owner;
        end
    end
end
