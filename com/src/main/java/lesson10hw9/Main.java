package lesson10hw9;

public class Main {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("SA001", 1000, 10);
        BankAccount currentAccount = new BankAccount("BA001", 2000) {
            @Override
            public void withdraw(double amount) {
                if (balance >= amount) {
                    balance -= amount;
                } else {
                    System.out.println("Insufficient funds");
                }
            }
        };

        Customer customer = new Customer("Tom");
        customer.addAccount(savingsAccount);
        customer.addAccount(currentAccount);

        System.out.println("Total balance before transactions: " + customer.getTotalBalance());

        // Deposit and withdraw operations
        savingsAccount.deposit(500);
        currentAccount.withdraw(300);

        System.out.println("Total balance after transactions: " + customer.getTotalBalance());

        // Testing interest calculation
        savingsAccount.withdraw(100);
        System.out.println("Balance after interest applied: " + savingsAccount.getBalance());
    }
}
