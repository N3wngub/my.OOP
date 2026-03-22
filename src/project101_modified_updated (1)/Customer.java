// คลาสลูกค้า extends Person มีรหัสลูกค้า
public class Customer extends Person {

    // รหัสลูกค้า
    private String customerId;

    // สร้างลูกค้า
    public Customer(String customerId, String firstName, String lastName) {
        super(firstName, lastName);
        this.customerId = customerId;
    }

    // คืนรหัสลูกค้า
    public String getCustomerId() {
        return customerId;
    }

    // พิมพ์รายละเอียดลูกค้า
    @Override
    public void printDetail() {
        System.out.println("Customer ID: " + customerId + ", Name: " + getFullName());
    }
}