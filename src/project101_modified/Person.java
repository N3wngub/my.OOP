
/**
 * คลาสบุคคลพื้นฐานที่มีชื่อและนามสกุล
 *
 * ใช้เป็นฐานสำหรับ {@link Staff} และ {@link Customer}
 */
public class Person implements Printable {

    /** ชื่อ */
    private String firstName;

    /** นามสกุล */
    private String lastName;

    /**
     * สร้าง {@code Person} ใหม่โดยไม่มีชื่อและนามสกุล
     */
    public Person() {
        this("", "");
    }

    /**
     * สร้าง {@code Person} พร้อมชื่อและนามสกุล
     *
     * @param firstName ชื่อ
     * @param lastName  นามสกุล
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * ตั้งชื่อและนามสกุล
     *
     * @param firstName ชื่อใหม่
     * @param lastName  นามสกุลใหม่
     */
    public void setFullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * คืนชื่อ
     *
     * @return ชื่อ
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * คืนค่านามสกุล
     *
     * @return นามสกุล
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * คืนชื่อเต็มโดยเชื่อมชื่อและนามสกุล
     *
     * @return ชื่อเต็ม
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * พิมพ์ชื่อเต็มของบุคคล
     */
    @Override
    public void printDetail() {
        System.out.println(getFullName());
    }
}