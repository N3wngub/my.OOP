public class Payment {
    Order orderDetails;
    double taxRate = 7.0 / 100; // BUG FIX: 7/100 is integer division = 0; must use 7.0/100

    Payment(Order orderDetails, double taxRate) { // BUG FIX: constructor took (String, double) in Tester — must accept Order
        this.orderDetails = orderDetails;
        this.taxRate = taxRate;
    }

    double calculateGrandTotal(){
        return orderDetails.calculateTotal() + (orderDetails.calculateTotal() * taxRate);
    }

    double processPayment(double cash){
        double processCash = 0;
        if (cash >= calculateGrandTotal()){
            processCash = cash - calculateGrandTotal();
        } else {
            System.out.println("Must Pay more " + (calculateGrandTotal() - cash));
        }
        return processCash;
    }

    void printReceipt() {
        // BUG FIX: was printing raw array reference (items.toString()), now prints item names properly
        System.out.println("Order ID: " + orderDetails.orderId);
        System.out.println("Items: " + orderDetails.itemCount);
        for (int i = 0; i < orderDetails.itemCount; i++) {
            orderDetails.items[i].printDetail();
        }
        System.out.println("Grand Total: " + calculateGrandTotal());
    }
}