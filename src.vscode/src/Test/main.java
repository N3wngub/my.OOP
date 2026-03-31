package Test;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Pet a = new Cat();
        System.out.print((a instanceof Pet) + " ");
        System.out.print(a instanceof Cat);
    }
}
