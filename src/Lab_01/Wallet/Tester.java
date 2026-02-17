package Wallet;

public class Tester {
    public static void main(String[] args) {
        Wallet myWallet = new Wallet();
        System.out.println("I have new wallet");
        System.out.println("Current wallet have : " + myWallet.getCurrentBaht() + " baht");
        System.out.println("I put " + myWallet.putMoney(500) + " to wallet");
        System.out.println("Current wallet have : " + myWallet.getCurrentBaht() + " baht");
        myWallet.getMoney(200);
        System.out.println("I would like to eating buffet (use 200 baht)");
        System.out.println("your get money 200 baht");
        System.out.println("Your money in wallet : " + myWallet.getCurrentBaht() + " baht");
        System.out.println("Current wallet have : " + myWallet.getCurrentBaht() + " baht");
        myWallet.getMoney(170);
        System.out.println("I am going to msee movie at cinema (use 170 baht)");
        System.out.println("Your money in wallet : " + myWallet.getCurrentBaht() + " baht");
        System.out.println("Current wallet have : " + myWallet.getCurrentBaht() + " baht");
        System.out.println("I would like to eating buffet (use 200 baht)");
        myWallet.getMoney(200);
        System.out.println("Your money in wallet : " + myWallet.getCurrentBaht() + " baht");
        System.out.println("Current wallet have : " + myWallet.getCurrentBaht() + " baht");
    }

}
