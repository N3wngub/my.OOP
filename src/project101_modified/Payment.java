import java.text.DecimalFormat;

/**
 * จัดการการชำระเงินสำหรับออร์เดอร์
 *
 * คำนวณยอดรวมหลังภาษีและพิมพ์ใบเสร็จ
 */
public class Payment implements Printable {

    /** ออร์เดอร์ที่กำลังชำระ */
    private Order orderDetails;

    /** อัตราภาษี (เช่น 0.07 = 7%) */
    private double taxRate;

    /** ผู้ชำระเงิน (อาจเป็น {@code null}) */
    private Person payer;

    /**
     * สร้างอ็อบเจ็กต์ Payment ด้วยออร์เดอร์และอัตราภาษี
     *
     * @param orderDetails ออร์เดอร์
     * @param taxRate      อัตราภาษี (0.x)
     */
    public Payment(Order orderDetails, double taxRate) {
        this(orderDetails, taxRate, null);
    }

    /**
     * สร้างอ็อบเจ็กต์ Payment พร้อมกำหนดผู้ชำระเงิน
     *
     * @param orderDetails ออร์เดอร์
     * @param taxRate      อัตราภาษี
     * @param payer        ผู้ชำระเงิน
     */
    public Payment(Order orderDetails, double taxRate, Person payer) {
        this.orderDetails = orderDetails;
        this.taxRate = taxRate;
        this.payer = payer;
    }

    /**
     * คืนออร์เดอร์ที่เกี่ยวข้อง
     *
     * @return ออร์เดอร์
     */
    public Order getOrderDetails() {
        return orderDetails;
    }

    /**
     * คืนอัตราภาษี
     *
     * @return อัตราภาษี
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     * คืนผู้ชำระเงิน หรือ {@code null} หากไม่มี
     *
     * @return ผู้ชำระเงิน
     */
    public Person getPayer() {
        return payer;
    }

    /**
     * คำนวณยอดรวมทั้งหมดรวมภาษี
     *
     * @return ยอดรวมทั้งหมด
     */
    public double calculateGrandTotal() {
        double subtotal = orderDetails.calculateTotal();
        return subtotal + (subtotal * taxRate);
    }

    /**
     * ประมวลผลการชำระเงินและคำนวณเงินทอน
     *
     * @param cash จำนวนเงินสดที่ชำระ
     * @return เงินทอน หรือ 0 หากไม่พอ
     */
    public double processPayment(double cash) {
        double totalDue = calculateGrandTotal();
        if (cash >= totalDue) {
            return cash - totalDue;
        } else {
            System.out.println("Must pay more " + (totalDue - cash));
            return 0;
        }
    }

    /**
     * พิมพ์ใบเสร็จแบบง่ายไปยังเอาต์พุตมาตรฐาน
     */
    public void printReceipt() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("=== RECEIPT ===");
        if (payer != null) {
            System.out.println("Payer: " + payer.getFullName());
        }
        orderDetails.printDetail();
        double subtotal = orderDetails.calculateTotal();
        System.out.println("Tax Rate: " + (taxRate * 100) + "%");
        System.out.println("Grand Total: " + df.format(calculateGrandTotal()));
    }

    /**
     * พิมพ์รายละเอียดตามอินเตอร์เฟซ {@link Printable}
     */
    @Override
    public void printDetail() {
        printReceipt();
    }
}