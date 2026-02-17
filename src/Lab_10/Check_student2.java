import java.io.*;
import java.util.Scanner;

public class Check_student2 {
    public static void main(String[] args) throws IOException {
        File f = new File("/workspaces/my.OOP/src/Lab_10/student2.txt");
        Scanner kb = new Scanner(f);
        String ID, name, surname;
        double grade;
        while (kb.hasNext()) {
            ID = kb.next();
            name = kb.next();
            surname = kb.next();
            grade = kb.nextDouble();

           String shortName = name.substring(0,1).toUpperCase() + ".";

            if (grade < 1.00) {
                System.out.println(ID + " " + shortName + " " + surname + " Retired");
            } else if (grade > 1.00 && grade < 2.00 ) {
                System.out.println(ID + " " + shortName + " " + surname + " Critical");
            } else if (grade >= 2.00) {
                System.out.println(ID + " " + shortName + " " + surname + " Pass");
            }
        }

        kb.close();


    }
}
