import java.text.DecimalFormat;

// คลาสสำหรับเครื่องดื่ม extends MenuItem
public class Beverage extends MenuItem {

    // ระดับความหวาน (0-100)
    private int sweetnessLevel;

    // เป็นเครื่องดื่มร้อนหรือไม่
    private boolean isHot;

    // สร้างเครื่องดื่มพร้อมตั้งค่าความหวานและสถานะร้อน
    public Beverage(String id, String name, double price, int sweetnessLevel, boolean isHot) {
        super(id, name, price);
        this.sweetnessLevel = sweetnessLevel;
        this.isHot = isHot;
    }

    // คืนระดับความหวาน
    public int getSweetnessLevel() {
        return sweetnessLevel;
    }

    // คืนว่าร้อนไหม
    public boolean isHot() {
        return isHot;
    }

    // พิมพ์รายละเอียดเครื่องดื่ม
    @Override
    public void printDetail() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(getId() + " " + getName() + " " + df.format(getPrice())
                + " Sweetness:" + sweetnessLevel + " Hot:" + isHot);
    }
}