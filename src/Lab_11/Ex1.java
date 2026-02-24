import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter index of array : ");

        try {
            int n = kb.nextInt();
            if (n > 2) {
                throw new IndexOutOfBoundsException();
            } else {
                System.out.println(numbers[n]);
            }
        } catch (InputMismatchException ie) {
            System.out.println("Your input mismatch");
        } catch (IndexOutOfBoundsException ine) {
            System.out.println("Array index is out of bound");
        }

    }

}


