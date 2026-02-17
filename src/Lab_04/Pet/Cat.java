package Pet;


    public class Cat extends Pet {

        public Cat() {
            super();
        }

        public Cat(Pet name, Pet weight) {
            super(name.getName(), weight.getWeight());

        }

        public void makeSound() {
            System.out.println("Meaw Meaw");
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

