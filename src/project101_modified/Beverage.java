import java.text.DecimalFormat;

/**
 * คลาสเครื่องดื่มที่สืบทอดจาก {@link MenuItem}
 *
 * เก็บระดับความหวานและข้อมูลเสิร์ฟร้อน/เย็น พร้อมเมธอดเข้าถึงข้อมูล
 */
public class Beverage extends MenuItem {

    /** ระดับความหวาน (0-100) */
    private int sweetnessLevel;

    /** ระบุว่าเครื่องดื่มนี้เสิร์ฟร้อนหรือไม่ */
    private boolean isHot;

    /**
     * สร้างเครื่องดื่มใหม่
     *
     * @param id             รหัสเครื่องดื่ม
     * @param name           ชื่อเครื่องดื่ม
     * @param price          ราคา
     * @param sweetnessLevel ระดับความหวาน (0-100)
     * @param isHot          เสิร์ฟร้อนหรือไม่
     */
    public Beverage(String id, String name, double price, int sweetnessLevel, boolean isHot) {
        super(id, name, price);
        this.sweetnessLevel = sweetnessLevel;
        this.isHot = isHot;
    }

    /**
     * คืนระดับความหวานของเครื่องดื่ม
     *
     * @return ระดับความหวาน
     */
    public int getSweetnessLevel() {
        return sweetnessLevel;
    }

    /**
     * ตรวจสอบว่าเครื่องดื่มนี้เสิร์ฟร้อนหรือไม่
     *
     * @return {@code true} หากร้อน; {@code false} หากเย็น
     */
    public boolean isHot() {
        return isHot;
    }

    /**
     * พิมพ์รายละเอียดของเครื่องดื่มรวมถึงความหวานและสถานะร้อน/เย็น
     */
    @Override
    public void printDetail() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(getId() + " " + getName() + " " + df.format(getPrice())
                + " Sweetness:" + sweetnessLevel + " Hot:" + isHot);
    }
}