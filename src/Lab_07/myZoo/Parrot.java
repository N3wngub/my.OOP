package myZoo;

public class Parrot extends Poultry{
    public Parrot(){}

    public Parrot(String name){
        super(name);
    }

    public String toString(){
        return super.toString() + "I have a "+ o.getType() +" I like to "+ move() + " I eat "+ eat();    }
    public String move(){
        return "Speaking";
    }

    public String eat(){
        return "bean";
    }
}
