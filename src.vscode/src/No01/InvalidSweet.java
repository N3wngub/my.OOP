package No01;

public class InvalidSweet extends Exception {
    public  InvalidSweet(){
        super("Invalid sweetness!");
    }
    public InvalidSweet(String name , int sweet){
        super("Invalid sweetness! "+ name + " -> " +sweet);
    }
}
