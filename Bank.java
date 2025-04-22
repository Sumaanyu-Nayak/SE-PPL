import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

// Custom Exceptions

//MinimumBalanceException: Thrown when the initial balance is less than 1000
class MinimumBalanceException extends Exception {
    public MinimumBalanceException(String message) {
        super(message);
    }
}

// InsufficientBalanceException: Thrown when there are insufficient funds for withdrawal or transfer
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// AccountNotFoundException: Thrown when an account is not found in the bank
class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

// NegativeAmountException: Thrown when a negative amount is entered for deposit, withdrawal, or transfer
class NegativeAmountException extends Exception {
    public NegativeAmountException(String message) {
        super(message);
    }
}


// BankAccount class
class BankAccount {
    private String name;
    private int accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String name, int accountNumber, double initialBalance) throws MinimumBalanceException {
        if (initialBalance < 1000) {
            throw new MinimumBalanceException("Initial balance must be at least 1000.");
        }
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Setters
    public void deposit(double amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Deposit amount cannot be negative.");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Withdrawal amount cannot be negative.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal.");
        }
        balance -= amount;
    }

    public void transferFunds(BankAccount targetAccount, double amount) throws InsufficientBalanceException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Transfer amount cannot be negative.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for transfer.");
        }
        this.withdraw(amount);
        targetAccount.deposit(amount);
    }

    //Overriding toString method to display account details
    // toString method for displaying account details
    @Override
    public String toString() {
        return "Account Name: " + name + "\nAccount Number: " + accountNumber + "\nBalance: " + balance;
    }
}


// Bank class
// This class manages the bank operations and user interactions
class Bank {

    private HashMap<Integer, BankAccount> accounts = new HashMap<>(); // To store accounts
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    // Method to create a new account
    public void createAccount() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        int accountNumber = generateAccountNumber();
        double initialBalance = 0;

        while (true) {
            try {
                System.out.print("Enter initial balance (minimum 1000): ");
                initialBalance = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                BankAccount account = new BankAccount(name, accountNumber, initialBalance);
                accounts.put(accountNumber, account);
                System.out.println("Account created successfully! Account Number: " + accountNumber);
                break;
            } catch (MinimumBalanceException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    // Methods for deposit, withdraw, transfer funds, and display account details
    public void deposit() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        BankAccount account = accounts.get(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        double amount = 0;
        while (true) {
            try {
                System.out.print("Enter deposit amount: ");
                amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                account.deposit(amount);
                System.out.println("Deposit successful! New balance: " + account.getBalance());
                break;
            } catch (NegativeAmountException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
    public void withdraw() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        BankAccount account = accounts.get(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        double amount = 0;
        while (true) {
            try {
                System.out.print("Enter withdrawal amount: ");
                amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                account.withdraw(amount);
                System.out.println("Withdrawal successful! New balance: " + account.getBalance());
                break;
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            } catch (NegativeAmountException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
    public void transferFunds() {
        System.out.print("Enter your account number: ");
        int sourceAccountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        BankAccount sourceAccount = accounts.get(sourceAccountNumber);

        if (sourceAccount == null) {
            System.out.println("Source account not found.");
            return;
        }

        System.out.print("Enter target account number: ");
        int targetAccountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        BankAccount targetAccount = accounts.get(targetAccountNumber);

        if (targetAccount == null) {
            System.out.println("Target account not found.");
            return;
        }

        double amount = 0;
        while (true) {
            try {
                System.out.print("Enter transfer amount: ");
                amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                sourceAccount.transferFunds(targetAccount, amount);
                System.out.println("Transfer successful! New balance: " + sourceAccount.getBalance());
                break;
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            } catch (NegativeAmountException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
    public void displayAccountDetails() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        BankAccount account = accounts.get(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println(account);
    }
    private int generateAccountNumber() {
        return random.nextInt(900000) + 100000; // Generates a random 6-digit account number
    }
    public void showMenu() {
        while (true) {
            System.out.println("\nBank Operations Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");

            int choice = 0;
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    transferFunds();
                    break;
                case 5:
                    displayAccountDetails();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.showMenu();
    }
}