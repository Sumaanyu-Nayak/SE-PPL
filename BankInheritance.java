// Base class representing a generic bank account
class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}


// Subclass representing a savings account
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance() * 0.5) { // Limit withdrawal to 50% of balance
            super.withdraw(amount);
        }
    }
}
// Subclass representing a current account
class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance() + overdraftLimit) { // Allow overdraft
            super.withdraw(amount);
        }
    }
}
// Subclass representing a fixed deposit account
class FixedDepositAccount extends BankAccount {
    private int maturityPeriod; // in months

    public FixedDepositAccount(String accountNumber, double initialBalance, int maturityPeriod) {
        super(accountNumber, initialBalance);
        this.maturityPeriod = maturityPeriod;
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawal not allowed until maturity period is over.");
    }
}
// Main class to test the bank account hierarchy


public class BankInheritance {
    public static void main(String[] args) {
        // Create instances of each account type
        SavingsAccount savingsAccount = new SavingsAccount("SA123", 1000.0, 0.05);
        CurrentAccount currentAccount = new CurrentAccount("CA123", 2000.0, 500.0);
        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("FD123", 5000.0, 12);

        // Test deposit and withdraw methods
        System.out.println("Initial Balances:");
        System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
        System.out.println("Current Account Balance: " + currentAccount.getBalance());
        System.out.println("Fixed Deposit Account Balance: " + fixedDepositAccount.getBalance());

        // Deposit into accounts
        savingsAccount.deposit(500.0);
        currentAccount.deposit(1000.0);
        fixedDepositAccount.deposit(2000.0);

        // Withdraw from accounts
        savingsAccount.withdraw(200.0);
        currentAccount.withdraw(2500.0);
        fixedDepositAccount.withdraw(1000.0);

        // Print final balances
        System.out.println("\nFinal Balances:");
        System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
        System.out.println("Current Account Balance: " + currentAccount.getBalance());
        System.out.println("Fixed Deposit Account Balance: " + fixedDepositAccount.getBalance());
    }
}