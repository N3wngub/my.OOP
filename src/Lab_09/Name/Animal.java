package Lab_09.Name;

public class Animal implements Nameable{
    String name;
    String type;

    public  Animal(String name,String type){
        this.name = name;
        this.type = type;
    }
    public void setName(String n){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String toString(){
        return getName();
    }
}