package Person;

public class Police extends Person {
    private String workCountry; // ชื่อจังหวัดที่สังกัด [cite: 150]

    // Constructor รับค่าชื่อ, ปีเกิด และชื่อจังหวัด [cite: 152]
    public Police(String name, int bornYear, String workCountry) {
        super(name, bornYear); // ส่งค่า name และ bornYear ไปให้ constructor ของ Person
        this.workCountry = workCountry;
    }

    // เขียนทับเมธอด introduce (Override) [cite: 154-157]
    @Override
    public void introduce() {
        super.introduce(); // เรียกใช้การแสดงผลชื่อและปีเกิดจากคลาสแม่
        System.out.println("I'm a police and work in " + workCountry + ".");
    }
}
