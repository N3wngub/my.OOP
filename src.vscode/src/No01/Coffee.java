package No01;

public class Coffee extends Drink implements Discountable{
    private String latte;
    private String americano;

    public Coffee(String name, double price) throws InvalidPriceException {
        super(name, price);
        if(price < 0){
            throw new InvalidPriceException(name,price);
        }
    }

    @Override
    double calculatePrie() {
        return getPrice() + 10 ;
    }

    @Override
    public double getDiscountable() {
        return getPrice()*0.1;
    }

    public double getFinalPrice(){
        return calculatePrie()-getDiscountable();
    }


}
