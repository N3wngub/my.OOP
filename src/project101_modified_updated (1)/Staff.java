// คลาสพนักงาน extends Person มีรหัสพนักงาน
public class Staff extends Person {

    // รหัสพนักงาน
    private String staffId;

    // สร้างพนักงาน
    public Staff(String staffId, String firstName, String lastName) {
        super(firstName, lastName);
        this.staffId = staffId;
    }

    // คืนรหัสพนักงาน
    public String getStaffId() {
        return staffId;
    }

    // พิมพ์รายละเอียดพนักงาน
    @Override
    public void printDetail() {
        System.out.println("Staff ID: " + staffId + ", Name: " + getFullName());
    }
}