package myZoo;

public class Poultry extends Animal{
    private String my_type = "Poultry";

    public Poultry(){}

    public Poultry(String name){
        super(name,new Organ("Wing"));
    }

    public String toString(){
        return super.toString() + ". I am a Poultry " ;
    }

    static int count;
}
