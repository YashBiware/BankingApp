public class BankAccount {

    private String accountHolder;
    private double balance;

    // constructor — sets up the account with a name and starting balance
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // deposit money into the account
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Deposit amount must be greater than zero.");
            return;
        }
        balance += amount;
        System.out.println("Successfully deposited $" + amount);
    }

    // withdraw money from the account
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be greater than zero.");
            return;
        }
        if (amount > balance) {
            System.out.println("Error: Insufficient funds. Your balance is $" + balance);
            return;
        }
        balance -= amount;
        System.out.println("Successfully withdrew $" + amount);
    }

    // check current balance
    public void checkBalance() {
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Current Balance: $" + balance);
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}
