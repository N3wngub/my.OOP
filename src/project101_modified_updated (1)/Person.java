// คลาสบุคคลพื้นฐาน มีชื่อและนามสกุล
public class Person implements Printable {

    // ชื่อ
    private String firstName;
    // นามสกุล
    private String lastName;

    // สร้าง Person ไม่ระบุชื่อ
    public Person() {
        this("", "");
    }

    // สร้าง Person ระบุชื่อและนามสกุล
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // ตั้งชื่อและนามสกุลใหม่
    public void setFullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // คืนชื่อ
    public String getFirstName() {
        return firstName;
    }

    // คืนค่านามสกุล
    public String getLastName() {
        return lastName;
    }

    // คืนชื่อเต็ม
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // พิมพ์ชื่อเต็ม
    @Override
    public void printDetail() {
        System.out.println(getFullName());
    }
}