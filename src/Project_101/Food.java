public class Food  extends MenuItem{
    int spicinessLevel ;
    boolean isVegan;

    Food(String id, String name, double price, int spicinessLevel, boolean isVegan) {
        super(id,name,price);
        this.spicinessLevel = spicinessLevel;
        this.isVegan = isVegan;
    }
    void printDetail(){
        System.out.println(this.id + " " + this.name + " " + this.price + " " + this.spicinessLevel + " " + this.isVegan);
    }
}
