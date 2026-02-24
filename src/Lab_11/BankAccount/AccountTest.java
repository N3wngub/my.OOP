package BankAccount;
import java.util.Scanner;
import java.io.*;

public class AccountTest {

    public static void main(String[] args) throws NegativeBalance {

        try {
            Scanner kb = new Scanner(System.in);
            System.out.print("Enter initial balance : ");
            BankAccount acc = new BankAccount(kb.nextDouble());
            System.out.println(acc);
        } catch (NegativeBalance ne) {
            System.out.println(ne.getMessage());
        } catch (Exception e) {
            System.out.println("Your input invalid");
        }

    }

}