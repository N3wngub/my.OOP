package Pet;

import java.util.ArrayList;

public class PetCenter {
    ArrayList<Pet> pets = new ArrayList<Pet>();

    public void addPet(Pet p) {
        pets.add(p);
    }

    public void removePetByName(String name) {
        for (int i = 0; i < pets.size(); i++) {
            if (name.equalsIgnoreCase(pets.get(i).getName())) {
                pets.remove(i);
            }
        }
    }

    public String searchPet(String name) {
        for (int i = 0; i < pets.size(); i++) {
            if (name.equalsIgnoreCase(pets.get(i).getName())) {
                return pets.get(i).toString();
            }
        }
        return "Pet not found";
    }

    public void showAllPets() {
        for (int i = 0; i < pets.size(); i++) {
            Pet pet = pets.get(i);
            System.out.println(pet.toString());
            System.out.println();
        }
    }

    public void showTotalFood() {
        double total = 0;
        for (int i = 0; i < pets.size(); i++) {
            total += pets.get(i).foodCostPerDay();
        }
        System.out.println("Total food cost per day: " + total);
        System.out.println();
    }
}
