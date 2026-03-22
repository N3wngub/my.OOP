import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

// แทนออร์เดอร์ลูกค้า เก็บรายการเมนูและคำนวณยอด
public class Order implements Printable {

    // รหัสออร์เดอร์
    private String orderId;
    // รายการเมนูในออร์เดอร์
    private List<MenuItem> items;

    // สร้างออร์เดอร์ด้วยรหัส
    public Order(String orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
    }

    // คืนรหัสออร์เดอร์
    public String getOrderId() {
        return orderId;
    }

    // คืนรายการเมนูทั้งหมด
    public List<MenuItem> getItems() {
        return items;
    }

    // คืนจำนวนรายการ
    public int getItemCount() {
        return items.size();
    }

    // เพิ่มเมนูลงในออร์เดอร์
    public void addItem(MenuItem item) {
        if (item != null) {
            items.add(item);
        }
    }

    // คำนวณยอดรวมย่อย
    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // พิมพ์รายละเอียดออร์เดอร์
    @Override
    public void printDetail() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Order ID: " + orderId);
        for (MenuItem item : items) {
            item.printDetail();
        }
        System.out.println("Subtotal: " + df.format(calculateTotal()));
    }
}