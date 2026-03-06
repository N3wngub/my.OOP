public class MenuItem {

    String id ;
    String name;
    double price;

    public MenuItem (String id,String name,double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    void printDetail(){
        System.out.println(this.id + " " + this.name + " " + this.price);;
    }
}

