package Person_Wallet;

public class Wallet {
    private int balance;

    public Wallet() {
        balance = 0;  // เริ่มต้น 0 บาท
    }

    public int getBalance() {
        return balance;
    }

    // ใส่เงินลงกระเป๋า
    public void putMoney(int money) {
        if (money > 0) {
            balance += money;
        }
    }

    // หยิบเงินออกจากกระเป๋า
    public void getMoney(int money) {
        if (money <= 0) {
            return;
        }
        if (money <= balance) {
            balance -= money;
        } else {
            System.out.println("Not enough money in wallet.");
        }
    }
}

