import java.text.DecimalFormat;

// จัดการการชำระเงินสำหรับออร์เดอร์
public class Payment implements Printable {

    // ออร์เดอร์ที่กำลังชำระ
    private Order orderDetails;
    // อัตราภาษี เช่น 0.07
    private double taxRate;
    // ผู้ชำระเงิน (อาจเป็น null)
    private Person payer;

    // สร้าง Payment ด้วยออร์เดอร์และอัตราภาษี
    public Payment(Order orderDetails, double taxRate) {
        this(orderDetails, taxRate, null);
    }

    // สร้าง Payment พร้อมระบุผู้ชำระเงิน
    public Payment(Order orderDetails, double taxRate, Person payer) {
        this.orderDetails = orderDetails;
        this.taxRate = taxRate;
        this.payer = payer;
    }

    // คืนออร์เดอร์
    public Order getOrderDetails() {
        return orderDetails;
    }

    // คืนอัตราภาษี
    public double getTaxRate() {
        return taxRate;
    }

    // คืนผู้ชำระเงิน
    public Person getPayer() {
        return payer;
    }

    // คำนวณยอดรวมทั้งหมดรวมภาษี
    public double calculateGrandTotal() {
        double subtotal = orderDetails.calculateTotal();
        return subtotal + (subtotal * taxRate);
    }

    // ประมวลผลการชำระและคืนเงินทอน
    public double processPayment(double cash) {
        double totalDue = calculateGrandTotal();
        if (cash >= totalDue) {
            return cash - totalDue;
        } else {
            System.out.println("Must pay more " + (totalDue - cash));
            return 0;
        }
    }

    // พิมพ์ใบเสร็จแบบง่าย
    public void printReceipt() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("=== RECEIPT ===");
        if (payer != null) {
            System.out.println("Payer: " + payer.getFullName());
        }
        orderDetails.printDetail();
        System.out.println("Tax Rate: " + (taxRate * 100) + "%");
        System.out.println("Grand Total: " + df.format(calculateGrandTotal()));
    }

    // พิมพ์รายละเอียด ตามอินเตอร์เฟซ Printable
    @Override
    public void printDetail() {
        printReceipt();
    }
}