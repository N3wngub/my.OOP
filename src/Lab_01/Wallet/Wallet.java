package Wallet;

class Wallet {
    int walletmoney;

    public Wallet (){
        walletmoney = 0;
    }


public int getCurrentBaht (){
    return walletmoney;
}
public int putMoney (int money){
        walletmoney += money;
        return walletmoney;
}
public int getMoney (int money){
        if (walletmoney < money){
            System.out.println("Can't get money, because you money not enough");
        } else  {
            walletmoney -= money;

        }
        return walletmoney;
}

}
