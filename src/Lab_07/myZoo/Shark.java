package myZoo;

public class Shark extends Fish{
    public Shark(){}

    public Shark(String name){
        super(name);
    }

    public String toString(){
        return super.toString() + "I have a "+ o.getType() +" I like to "+ move() + " I eat "+ eat();
    }
    public String move(){
        return "straight swimming";
    }

    public String eat(){
        return "smallfish";
    }
}
