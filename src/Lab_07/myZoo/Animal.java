package myZoo;

public class Animal {
    protected String name;
    protected Organ o;

    public Animal(){

    }

    public Animal(String name,Organ o){
        this.o = o;
        this.name = name;
    }


    public String toString(){
        return "Hello, my name is " + name;
    }
}
