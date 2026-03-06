public class Beverage extends MenuItem{
    int sweetnessLevel;
    boolean isHot;

    Beverage(String id, String name, double price, int sweetnessLevel, boolean isHot){
        super(id, name, price);
        this.sweetnessLevel = sweetnessLevel;
        this.isHot = isHot;
    }

    @Override
    void printDetail() {
        System.out.println(this.id + " " + this.name + " " + this.price + " " + this.sweetnessLevel + " " + this.isHot);
    }
}
