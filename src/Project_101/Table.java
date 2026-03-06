public class Table {
    int tableNumber;
    boolean isOccupied;
    Order currentOrder;

    Table(int tableNumber){
        this.tableNumber = tableNumber;
    }

    void openTable(String orderId){
        this.currentOrder = new Order(orderId);
        this.isOccupied = true;
    }
    void closeTable(){
        this.currentOrder = null;
        this.isOccupied = false;
    }
}
