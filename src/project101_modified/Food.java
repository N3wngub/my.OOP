import java.text.DecimalFormat;

/**
 * คลาสอาหารที่สืบทอดจาก {@link MenuItem}
 *
 * เพิ่มข้อมูลระดับความเผ็ดและสถานะมังสวิรัติ พร้อมเมธอดเข้าถึงข้อมูล
 */
public class Food extends MenuItem {

    /** ระดับความเผ็ด (0-100) */
    private int spicinessLevel;

    /** ระบุว่าอาหารนี้เป็นมังสวิรัติหรือไม่ */
    private boolean isVegan;

    /**
     * สร้างอาหารใหม่
     *
     * @param id             รหัสอาหาร
     * @param name           ชื่ออาหาร
     * @param price          ราคา
     * @param spicinessLevel ระดับความเผ็ด (0-100)
     * @param isVegan        เป็นมังสวิรัติหรือไม่
     */
    public Food(String id, String name, double price, int spicinessLevel, boolean isVegan) {
        super(id, name, price);
        this.spicinessLevel = spicinessLevel;
        this.isVegan = isVegan;
    }

    /**
     * คืนระดับความเผ็ดของอาหารนี้
     *
     * @return ระดับความเผ็ด
     */
    public int getSpicinessLevel() {
        return spicinessLevel;
    }

    /**
     * ตรวจสอบว่าเป็นมังสวิรัติหรือไม่
     *
     * @return {@code true} ถ้าเป็นมังสวิรัติ; {@code false} หากไม่ใช่
     */
    public boolean isVegan() {
        return isVegan;
    }

    /**
     * พิมพ์รายละเอียดของอาหารรวมถึงระดับความเผ็ดและสถานะมังสวิรัติ
     */
    @Override
    public void printDetail() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(getId() + " " + getName() + " " + df.format(getPrice())
                + " Spiciness:" + spicinessLevel + " Vegan:" + isVegan);
    }
}