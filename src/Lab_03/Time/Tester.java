package Time;
public class Tester {
    public static void main(String[] args) {
        // Test case 1 create object clock with time incorrect
        System.out.println("Test case 1 : Create object");
        System.out.println("Test case 1.1 : Create object obj1 with incorrect value");
        Clock obj1 = new Clock(99 , 88);
        System.out.println("Time : " + obj1);
        System.out.println("Test case 1.2 : Create object obj1 with incorrect value");
        obj1 = new Clock(-2 , 34);
        System.out.println("Time : " + obj1);
        System.out.println("Test case 1.3 : Create object obj1 with correct value");
        obj1 = new Clock(23 , 15);
        System.out.println("Time : " + obj1);
        System.out.println();

        // Test case 2 check method getMinute and getHour
        System.out.println("Test case 2 check method setTime(), getHour() and getMinute()");
        System.out.println("Set time to 2:9");
        obj1.setTime(2, 9);
        System.out.println("Hour : " + obj1.getHour() + " Minute : " + obj1.getMinute());
        System.out.println();

        // Test case 3 check method increaseMinute
        System.out.println("Test case 3 : checking method increaseMinute");
        Clock myClock = new Clock(23, 55);
        for(int i = 0; i < 10; i++){
            System.out.println("Time : " + myClock);
            myClock.increaseMinute();
        }
    }
}
