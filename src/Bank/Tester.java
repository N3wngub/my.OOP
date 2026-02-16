package Bank;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the number of BankAccount : ");
        int n = kb.nextInt();

        BankAccount[] bankAccounts = new BankAccount[n];
        for (int i = 0; i < bankAccounts.length; i++) {
            String accNo = kb.next();
            int balance = kb.nextInt();
            bankAccounts[i] = new BankAccount(accNo,balance);
        }

        for (int i = 0; i < bankAccounts.length; i++) {
            System.out.println(bankAccounts[i].toString());
        }
        System.out.println("Enter size and number of deposit : ");
        int size = kb.nextInt();
        int number = kb.nextInt();

        PiggyBank[] piggyBanks = new PiggyBank[number];
        for (int i = 0; i < piggyBanks.length; i++) {
            int type = kb.nextInt();
            int coin = kb.nextInt();
            piggyBanks[i] = new PiggyBank(coin);
        }


    }
}
