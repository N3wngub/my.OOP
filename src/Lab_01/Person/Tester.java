package Person;

public class Tester {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Jame Smith");
        p.setHeight(1.68);
        p.setWeight(65);
        System.out.println("Name : " + p.getName());
        System.out.println("Weight : " + p.getWeight());
        System.out.println("Height : " + p.getHeight());
        System.out.printf("BMI : %.2f", p.bmi());
    }
}
