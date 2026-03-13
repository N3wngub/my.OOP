
/**
 * โมเดลของโต๊ะในร้านอาหาร
 *
 * แต่ละโต๊ะมีหมายเลข สถานะ และออร์เดอร์ปัจจุบัน พร้อมพิมพ์รายละเอียดได้
 */
public class Table implements Printable {

    /** หมายเลขโต๊ะ */
    private int tableNumber;

    /** สถานะการถูกใช้งาน */
    private boolean occupied;

    /** ออร์เดอร์ปัจจุบัน หรือ {@code null} หากไม่มี */
    private Order currentOrder;

    /** พนักงานที่ถูกมอบหมาย หรือ {@code null} */
    private Staff assignedStaff;

    /**
     * สร้างโต๊ะใหม่
     *
     * @param tableNumber หมายเลขโต๊ะ
     */
    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
        this.occupied = false;
        this.currentOrder = null;
    }

    /**
     * คืนหมายเลขโต๊ะนี้
     *
     * @return หมายเลขโต๊ะ
     */
    public int getTableNumber() {
        return tableNumber;
    }

    /**
     * ตรวจสอบว่าโต๊ะนี้ถูกใช้งานหรือไม่
     *
     * @return {@code true} หากมีออร์เดอร์; {@code false} หากว่าง
     */
    public boolean isOccupied() {
        return occupied;
    }

    /**
     * คืนออร์เดอร์ปัจจุบันของโต๊ะ
     *
     * @return ออร์เดอร์ หรือ {@code null}
     */
    public Order getCurrentOrder() {
        return currentOrder;
    }

    /**
     * เปิดโต๊ะและสร้างออร์เดอร์ใหม่
     *
     * @param orderId รหัสออร์เดอร์ใหม่
     */
    public void openTable(String orderId) {
        this.currentOrder = new Order(orderId);
        this.occupied = true;
    }

    /**
     * ปิดโต๊ะและล้างออร์เดอร์
     */
    public void closeTable() {
        this.currentOrder = null;
        this.occupied = false;
        this.assignedStaff = null;
    }

    /**
     * พิมพ์สถานะของโต๊ะ
     */
    @Override
    public void printDetail() {
        if (occupied) {
            String staffInfo = (assignedStaff != null)
                    ? assignedStaff.getStaffId() + " " + assignedStaff.getFullName()
                    : "Unassigned";
            System.out.println("Table " + tableNumber + " : Occupied (Order: " + currentOrder.getOrderId()
                    + ", Staff: " + staffInfo + ")");
        } else {
            System.out.println("Table " + tableNumber + " : Available");
        }
    }

    /**
     * กำหนดพนักงานให้โต๊ะนี้
     *
     * @param staff พนักงาน หรือ {@code null} เพื่อเคลียร์
     */
    public void setAssignedStaff(Staff staff) {
        this.assignedStaff = staff;
    }

    /**
     * คืนพนักงานที่ถูกมอบหมาย
     *
     * @return พนักงาน หรือ {@code null}
     */
    public Staff getAssignedStaff() {
        return assignedStaff;
    }
}