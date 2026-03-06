public class Order {
    String orderId;
    MenuItem[] items;
    int itemCount;

    Order(String orderId){
        this.orderId = orderId;
        this.items = new MenuItem[10];
    }

    void addItem(MenuItem item){
        this.items[this.itemCount] = item;
        this.itemCount++;
    }

    double calculateTotal(){
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getPrice();
        }
        return total;
    }

}
