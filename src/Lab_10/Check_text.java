import java.io.*;
import java.util.Scanner;

public class Check_text {
    public static void main(String[] args) throws IOException {
        File f = new File("/workspaces/my.OOP/src/Lab_10/text.txt");
        File o = new File("/workspaces/my.OOP/src/Lab_10/revtext.txt");
        Scanner kb = new Scanner(f);
        PrintWriter writer = new PrintWriter(o);
        String Original;
        String Reversed;

        while (kb.hasNext()) {
           Original = kb.nextLine();
           Reversed = new StringBuilder(Original).reverse().toString();
           writer.println(Reversed);
        }
        kb.close();
        writer.close();

    }
}

