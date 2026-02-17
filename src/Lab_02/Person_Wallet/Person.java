package Person_Wallet;

public class Person {
    private String firstname;
    private String lastname;
    private Wallet myWallet;

    // มีแต่ชื่อ–นามสกุล ตาม UML
    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.myWallet = new Wallet();   // มีกระเป๋าตังค์ใบหนึ่งตั้งต้น
    }

    // เช็คว่าในกระเป๋ามีเงินเท่าไหร่
    public int checkMoney() {
        return myWallet.getBalance();
    }

    // ใช้เงิน (หยิบออกจากกระเป๋า)
    public void useMoney(int money) {
        System.out.println(firstname + " uses " + money + " baht.");
        myWallet.getMoney(money);
    }

    // เก็บเงิน (ใส่ลงกระเป๋า)
    public void saveMoney(int money) {
        System.out.println(firstname + " saves " + money + " baht.");
        myWallet.putMoney(money);
    }

    // เปลี่ยนกระเป๋าสตางค์ใบใหม่
    public void changeNewWallet(Wallet wallet) {
        int currentMoney = myWallet.getBalance();
        // เอาเงินออกจากกระเป๋าเก่า
        myWallet.getMoney(currentMoney);
        // ใส่เงินลงกระเป๋าใหม่
        wallet.putMoney(currentMoney);
        // เปลี่ยนไปใช้กระเป๋าใหม่
        myWallet = wallet;
    }

    // แสดงชื่อ–นามสกุล + จำนวนเงินในกระเป๋า
    public void printInfo() {
        System.out.println("Name : " + firstname + " " + lastname);
        System.out.println("wallet : " + myWallet.getBalance() + " baht.");
    }
}

