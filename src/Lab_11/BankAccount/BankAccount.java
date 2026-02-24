package BankAccount;
public class BankAccount {
    double balance;

    public BankAccount(double initBalance) throws NegativeBalance {

        if (initBalance < 0) {

            throw new NegativeBalance(initBalance);
        }
        balance = initBalance;

    }

    public String toString() {

        return "Your balance : "

                + balance;

    }
}