package No01;

public class InvalidPriceException extends java.lang.Exception {
    public  InvalidPriceException(){
        super("Invalid price!");
    }
    public InvalidPriceException(String name , double price){
        super("Invalid price! "+ name + " -> " +price);
    }
}