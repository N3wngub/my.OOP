// คลาสโต๊ะในร้านอาหาร
public class Table implements Printable {

    // หมายเลขโต๊ะ
    private int tableNumber;
    // สถานะการถูกใช้งาน
    private boolean occupied;
    // ออร์เดอร์ปัจจุบัน หรือ null
    private Order currentOrder;
    // พนักงานที่ถูกมอบหมาย หรือ null
    private Staff assignedStaff;

    // สร้างโต๊ะใหม่
    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
        this.occupied = false;
        this.currentOrder = null;
    }

    // คืนหมายเลขโต๊ะ
    public int getTableNumber() {
        return tableNumber;
    }

    // ตรวจสอบว่าโต๊ะถูกใช้งานหรือไม่
    public boolean isOccupied() {
        return occupied;
    }

    // คืนออร์เดอร์ปัจจุบัน
    public Order getCurrentOrder() {
        return currentOrder;
    }

    // เปิดโต๊ะและสร้างออร์เดอร์ใหม่
    public void openTable(String orderId) {
        this.currentOrder = new Order(orderId);
        this.occupied = true;
    }

    // ปิดโต๊ะและล้างออร์เดอร์
    public void closeTable() {
        this.currentOrder = null;
        this.occupied = false;
        this.assignedStaff = null;
    }

    // พิมพ์สถานะของโต๊ะ
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

    // กำหนดพนักงานให้โต๊ะ
    public void setAssignedStaff(Staff staff) {
        this.assignedStaff = staff;
    }

    // คืนพนักงานที่ถูกมอบหมาย
    public Staff getAssignedStaff() {
        return assignedStaff;
    }
}