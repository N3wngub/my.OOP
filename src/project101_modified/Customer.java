
/**
 * คลาสลูกค้าที่สืบทอดจาก {@link Person} และเพิ่มรหัสลูกค้า
 */
public class Customer extends Person {

    /** รหัสลูกค้า */
    private String customerId;

    /**
     * สร้างลูกค้าใหม่
     *
     * @param customerId รหัสลูกค้า
     * @param firstName  ชื่อ
     * @param lastName   นามสกุล
     */
    public Customer(String customerId, String firstName, String lastName) {
        super(firstName, lastName);
        this.customerId = customerId;
    }

    /**
     * คืนรหัสลูกค้า
     *
     * @return รหัส
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * พิมพ์รายละเอียดของลูกค้า
     */
    @Override
    public void printDetail() {
        System.out.println("Customer ID: " + customerId + ", Name: " + getFullName());
    }
}