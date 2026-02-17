package myZoo;

public class Duck extends Poultry{
    public Duck(){}

    public Duck(String name){
        super(name);
    }

    public String toString(){
        return super.toString() + "I have a "+ o.getType() +" I like to "+ move() + " I eat "+ eat();
    }
    public String move(){
        return "Swimming";
    }

    public String eat(){
        return "rice";
    }
}
