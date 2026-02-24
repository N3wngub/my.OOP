import java.io.*;
import java.util.Scanner;

public class Check_student {
    public static void main(String[] args) throws IOException {
        File f = new File("/workspaces/my.OOP/src/Lab_10/student.txt");
        Scanner kb = new Scanner(f);
        String num, major, name, surname;
        int countIT = 0;
        int countSE = 0;
        int countCS = 0;

        while (kb.hasNext()) {
            num = kb.next();
            major = kb.next();
            name = kb.next();
            surname = kb.next();

            if (major.equalsIgnoreCase("IT")) {
                countIT++;
            } else if (major.equalsIgnoreCase("SE")) {
                countSE++;
            } else if (major.equalsIgnoreCase("CS")) {
                countCS++;
            }
        }

        kb.close();

        System.out.println("There are " + countCS + " persons in Computer Science.");
        System.out.println("There are " + countIT + " persons in Information Technology.");
        System.out.println("There are " + countSE + " persons in Software Engineering.");


    }
}
