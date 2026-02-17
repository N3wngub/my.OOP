package Contact;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        ArrayList<Phonebook> phonebooks = new ArrayList<>();
        System.out.println("This program rum util you key Q");

        while (true){
            System.out.print("Insert what do ypu want : ");
            String command = kb.next();

            if (command.equalsIgnoreCase("Q")){
                break;
            }

            if(command.equalsIgnoreCase("add")){
                String name = kb.next();
                String num = kb.next();
                phonebooks.add(new Phonebook(name,num));
            } else if (command.equalsIgnoreCase("search")) {
                String  name = kb.next();
                for (int i = 0; i < phonebooks.size(); i++) {
                    if (phonebooks.get(i).getName().equals(name)){
                        System.out.println(phonebooks.toString());
                    }else {
                        System.out.println("Not found");
                    }
                }
            } else if (command.equalsIgnoreCase("delete")) {
                String name = kb.next();
                for (int i = 0; i < phonebooks.size(); i++) {
                    if (phonebooks.get(i).getName().equals(name)){
                        System.out.print("Do you confirm to delete (Y/N) ");
                        String yesno = kb.next();
                        if (yesno.equalsIgnoreCase("Y")){
                            phonebooks.remove(i);
                        }
                    }else {
                        System.out.println("Not found");
                    }
                }
            }

            System.out.println(phonebooks.toString());

        }

        }
    }


