import java.io.*;
import java.util.Scanner;

public class Check_score {
    public static void main(String[] args) throws IOException {
        File f = new File("/workspaces/my.OOP/src/Lab_10/score.txt");
        Scanner kb = new Scanner(f);
        int ID, score;

        while (kb.hasNext()) {
            ID = kb.nextInt();
            score = kb.nextInt();

            if (score >= 60) {
                System.out.println("ID : " + ID + " Grade : S");
            } else if (score < 60 ) {
                System.out.println("ID : " + ID + " Grade : U");
            }
        }

        kb.close();


    }
}
