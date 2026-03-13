import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * แทนออร์เดอร์ของลูกค้าในระบบ POS
 *
 * เก็บรายการเมนูหลายรายการและสามารถคำนวณยอดรวมย่อยและพิมพ์รายละเอียดได้
 */
public class Order implements Printable {

    /** รหัสประจำออร์เดอร์ */
    private String orderId;

    /** รายการเมนูในออร์เดอร์ */
    private List<MenuItem> items;

    /**
     * สร้างออร์เดอร์ใหม่ด้วยรหัสที่กำหนด
     *
     * @param orderId รหัสออร์เดอร์
     */
    public Order(String orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
    }

    /**
     * คืนรหัสของออร์เดอร์นี้
     *
     * @return รหัสออร์เดอร์
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * คืนรายการเมนูทั้งหมดในออร์เดอร์นี้
     *
     * @return ลิสต์รายการ
     */
    public List<MenuItem> getItems() {
        return items;
    }

    /**
     * คืนจำนวนรายการในออร์เดอร์
     *
     * @return จำนวนรายการ
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * เพิ่มเมนูลงในออร์เดอร์
     *
     * @param item รายการเมนูที่จะเพิ่ม
     */
    public void addItem(MenuItem item) {
        if (item != null) {
            items.add(item);
        }
    }

    /**
     * คำนวณยอดรวมย่อยของออร์เดอร์
     *
     * @return ยอดรวมย่อย
     */
    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    /**
     * พิมพ์รายละเอียดของออร์เดอร์นี้
     */
    @Override
    public void printDetail() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Order ID: " + orderId);
        for (MenuItem item : items) {
            // Polymorphic call to print item details
            item.printDetail();
        }
        System.out.println("Subtotal: " + df.format(calculateTotal()));
    }
}