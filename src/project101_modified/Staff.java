
/**
 * คลาสพนักงานที่สืบทอดจาก {@link Person} และเพิ่มรหัสพนักงาน
 */
public class Staff extends Person {

    /** รหัสพนักงาน */
    private String staffId;

    /**
     * สร้างพนักงานใหม่
     *
     * @param staffId   รหัสพนักงาน
     * @param firstName ชื่อ
     * @param lastName  นามสกุล
     */
    public Staff(String staffId, String firstName, String lastName) {
        super(firstName, lastName);
        this.staffId = staffId;
    }

    /**
     * คืนรหัสพนักงาน
     *
     * @return รหัส
     */
    public String getStaffId() {
        return staffId;
    }

    /**
     * พิมพ์รายละเอียดของพนักงาน
     */
    @Override
    public void printDetail() {
        System.out.println("Staff ID: " + staffId + ", Name: " + getFullName());
    }
}