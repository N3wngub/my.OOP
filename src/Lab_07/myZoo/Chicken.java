package myZoo;

public class Chicken extends Poultry{
    public Chicken(){}

    public Chicken(String name){
        super(name);
    }

    public String toString(){
        return super.toString() + "I have a "+ o.getType() +" I like to "+ move() + " I eat "+ eat();
    }
    public String move(){
        return "Walking";
    }

    public String eat(){
        return "worm";
    }
}
