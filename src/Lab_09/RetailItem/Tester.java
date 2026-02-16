package Lab_09.RetailItem;

public class Tester {
    public static void main(String[] args) {
        CompactDisc c1 = new CompactDisc("Greatest Hits","Joe Looney Band",18.95);
        DvdMovie d1 = new DvdMovie("Joker",122.0,12.95);


        System.out.println(c1.toString());
        System.out.println(d1.toSting());
    }
}
