package No01;

public class Tea extends Drink implements Discountable{
    private int sweetnessLevel;

    public Tea(String name, double price, int sweet) throws InvalidPriceException, InvalidSweet {
        super(name, price);
        if(price < 0){
            throw new InvalidPriceException(name,price);
        }
        if(sweet < 0 || sweet > 10){
            throw new InvalidSweet(name,sweet);
        }
        this.sweetnessLevel = sweet;
    }

    @Override
    double calculatePrie() {
        if (sweetnessLevel > 0){
            return getPrice()+5;

        }else {
            return getPrice();
        }
    }

    @Override
    public double getDiscountable() {
        return getPrice()*0.05;
    }

    public double getFinalPrice(){
        return calculatePrie()-getDiscountable();
    }
}
