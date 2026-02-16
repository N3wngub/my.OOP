package RetailItem;

public class CompactDisc implements  RetailItem{
    private String title;
    private String arstist;
    private double retailPrice;


    public CompactDisc (String title,String arstist,double retailPrice){
        this.title = title;
        this.arstist = arstist;
        this.retailPrice = retailPrice;
    }
    public double getRetailPrice(){
        return retailPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArstist() {
        return arstist;
    }

    public void setArstist(String arstist) {
        this.arstist = arstist;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String toString(){
        return "Item #1: " + getTitle() + "\nPrice: "+ getRetailPrice();
    }
}