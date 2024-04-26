package lesson10hw9;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        double withdrawalAmount = amount * (1 + interestRate / 100);
        if (balance >= withdrawalAmount) {
            balance -= withdrawalAmount;
        } else {
            System.out.println("Insufficient funds");
        }
    }
}
