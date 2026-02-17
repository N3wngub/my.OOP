package myZoo;

public class Ray  extends Fish{
    public Ray(){}

    public Ray(String name){
        super(name);
    }

    public String toString(){
        return super.toString() + "I have a "+ o.getType() +" I like to "+ move() + " I eat "+ eat();
    }
    public String move(){
        return "hover swimming";
    }

    public String eat(){
        return "seaweed";
    }
}
