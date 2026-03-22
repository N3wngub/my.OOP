import java.text.DecimalFormat;

// คลาสพื้นฐานรายการเมนู
public class MenuItem implements Printable {

    // รหัสประจำรายการ
    private String id;

    // ชื่อของรายการ
    private String name;

    // ราคา
    private double price;

    // สร้างเมนูใหม่
    public MenuItem(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // คืนรหัสรายการ
    public String getId() {
        return id;
    }

    // คืนชื่อรายการ
    public String getName() {
        return name;
    }

    // คืนราคา
    public double getPrice() {
        return price;
    }

    // พิมพ์รายละเอียดสั้นๆ
    @Override
    public void printDetail() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(getId() + " " + getName() + " " + df.format(getPrice()));
    }
}