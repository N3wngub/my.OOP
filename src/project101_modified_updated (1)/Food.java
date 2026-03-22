import java.text.DecimalFormat;

// คลาสอาหาร extends MenuItem เก็บความเผ็ดและมังสวิรัติ
public class Food extends MenuItem {

    // ระดับความเผ็ด (0-100)
    private int spicinessLevel;

    // เป็นมังสวิรัติหรือไม่
    private boolean isVegan;

    // สร้างอาหารพร้อมตั้งค่าความเผ็ดและมังสวิรัติ
    public Food(String id, String name, double price, int spicinessLevel, boolean isVegan) {
        super(id, name, price);
        this.spicinessLevel = spicinessLevel;
        this.isVegan = isVegan;
    }

    // คืนระดับความเผ็ด
    public int getSpicinessLevel() {
        return spicinessLevel;
    }

    // คืนว่าเป็นมังสวิรัติไหม
    public boolean isVegan() {
        return isVegan;
    }

    // พิมพ์รายละเอียดอาหาร
    @Override
    public void printDetail() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(getId() + " " + getName() + " " + df.format(getPrice())
                + " Spiciness:" + spicinessLevel + " Vegan:" + isVegan);
    }
}