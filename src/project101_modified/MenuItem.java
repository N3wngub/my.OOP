import java.text.DecimalFormat;

/**
 * คลาสพื้นฐานสำหรับรายการเมนูทั่วไป
 *
 * ใช้เก็บรหัส ชื่อ และราคา และรองรับการพิมพ์รายละเอียดด้วยอินเตอร์เฟซ {@link Printable}
 */
public class MenuItem implements Printable {

    /** รหัสประจำรายการ */
    private String id;

    /** ชื่อของรายการ */
    private String name;

    /** ราคา */
    private double price;

    /**
     * สร้างรายการเมนูใหม่
     *
     * @param id    รหัสของรายการ
     * @param name  ชื่อของรายการ
     * @param price ราคา
     */
    public MenuItem(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * คืนรหัสของรายการ
     *
     * @return รหัส
     */
    public String getId() {
        return id;
    }

    /**
     * คืนชื่อของรายการ
     *
     * @return ชื่อ
     */
    public String getName() {
        return name;
    }

    /**
     * คืนราคา
     *
     * @return ราคา
     */
    public double getPrice() {
        return price;
    }

    /**
     * พิมพ์ ID ชื่อ และราคาในรูปแบบสั้น
     */
    @Override
    public void printDetail() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(getId() + " " + getName() + " " + df.format(getPrice()));
    }
}