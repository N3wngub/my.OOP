package Lab_09.RetailItem;

public class DvdMovie implements RetailItem {
    private String title;
    private double runningTime;
    private double retailPrice;

    public DvdMovie (String title,Double runningTime,double retailPrice){
        this.runningTime = runningTime;
        this.title = title;
        this.retailPrice = retailPrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public String getTitle() {
        return title;
    }

    public double getRunningTime() {
        return runningTime;
    }
    
    public String toSting(){
        return "Item #2: " + getTitle() + "\nPrice: " + getRetailPrice();
    }
}
