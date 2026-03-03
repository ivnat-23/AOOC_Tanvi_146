class BankAccount {
    protected double balance;
    BankAccount(double balance) {
        if (balance > 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}
class SavingsAccount extends BankAccount {
    SavingsAccount(double balance) {
        super(balance);
    }
    public void withdraw(double amount) {
        if (balance - amount < 100) {
            System.out.println("Withdrawal denied! Minimum balance of 100 must be maintained.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }
}
public class BankDemo {
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount(500);
        account.displayBalance();
        account.deposit(200);
        account.displayBalance();
        account.withdraw(550);   // Allowed
        account.displayBalance();
        account.withdraw(100);   // Not allowed (below 100)
        account.displayBalance();
    }
}