package c02_oop;

/*
Explanation
Encapsulation through Access Modifiers:

The owner and balance variables are private, hiding them from external access. Only methods within the BankAccount class can directly interact with these variables.
Public Interface:

The methods deposit(), withdraw(), getBalance(), and getOwner() provide controlled access to the private data.
This ensures that balance adjustments are made only through deposit() and withdraw() with specific checks (e.g., amount > 0, amount <= balance).
Encapsulation Benefits:

The account's balance and owner data are protected from outside interference, and the class enforces rules for valid transactions.
*/
public class Encapsulation {

    static class BankAccount {
        private String owner; // Private member variable to store the owner's name
        private double balance; // Private member variable to store the account balance

        // Constructor to initialize account with owner's name and initial balance
        public BankAccount(String owner, double initialBalance) {
            this.owner = owner;
            this.balance = initialBalance;
        }

        // Public method to deposit money (positive value only)
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: $" + amount);
            } else {
                System.out.println("Invalid deposit amount!");
            }
        }

        // Public method to withdraw money (ensures sufficient balance)
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew: $" + amount);
            } else {
                System.out.println("Invalid withdrawal amount or insufficient funds!");
            }
        }

        // Public method to check balance (read-only access)
        public double getBalance() {
            return balance;
        }

        // Public method to get the account owner's name
        public String getOwner() {
            return owner;
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Alice", 500.0); // Create account with initial balance of $500

        System.out.println("Account owner: " + account.getOwner());
        System.out.println("Initial balance: $" + account.getBalance());

        account.deposit(200.0); // Deposit $200
        System.out.println("New balance: $" + account.getBalance());

        account.withdraw(150.0); // Withdraw $150
        System.out.println("New balance: $" + account.getBalance());

        account.withdraw(700.0); // Attempt to withdraw more than the balance
        System.out.println("Final balance: $" + account.getBalance());
    }
}
