package Pet;

import java.util.Scanner;

public class Teater {
    public static void main(String[] args) {
        PetCenter petCenter = new PetCenter();
        Scanner kb = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1: Search pet by name");
            System.out.println("2: Remove pet by name");
            System.out.println("3: Show all pets");
            System.out.println("4: Show total food cost");
            System.out.println("5: Add Pets");
            System.out.println("0: Exit");
            System.out.print("Select: ");

            int choice = kb.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter pet name: ");
                    String searchName = kb.next();
                    System.out.println(petCenter.searchPet(searchName));
                    break;
                case 2:
                    System.out.print("Enter pet name to remove: ");
                    String removeName = kb.next();
                    petCenter.removePetByName(removeName);
                    System.out.println("Pet removed!");
                    break;
                case 3:
                    System.out.println("\n========== ALL PETS ==========");
                    petCenter.showAllPets();
                    break;
                case 4:
                    petCenter.showTotalFood();
                    break;
                case 5:
                    System.out.println("Select your Type\n1 : Cat\n2 : Dog\n3 : Rabbit");
                    System.out.print("Select : ");
                    int type = kb.nextInt();

                    if (type == 1 || type == 2 || type == 3) {
                        System.out.print("Name : ");
                        String name = kb.next();
                        System.out.print("Weight : ");
                        double weight = kb.nextDouble();

                        Pet pet;
                        if (type == 1) {
                            pet = new Cat(name, weight);
                        } else if (type == 2) {
                            pet = new Dog(name, weight);
                        } else {
                            pet = new Rabbit(name, weight);
                        }
                        petCenter.addPet(pet);
                        System.out.println("Pet added successfully!");
                    } else {
                        System.out.println("Invalid type!");
                    }
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        kb.close();
    }
}
