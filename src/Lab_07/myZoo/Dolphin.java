package myZoo;

public class Dolphin extends Fish{
    public Dolphin(){}

    public Dolphin(String name){
        super(name);
    }

    public String toString(){
        return super.toString() + "I have a "+ o.getType() +" I like to "+ move() + " I eat "+ eat();    }
    public String move(){
        return "circulate swimming";
    }

    public String eat(){
        return "plankton" ;
    }

}
