package Pet;

public class Pet {
    String name;
    int weight;

    public  Pet(String name,int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Pet(){
        name ="unknown";
        weight = 0;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public void sound(String sound){
        System.out.println(sound);
    }

    @Override
    public String toString() {
        return "name : "+name+ "\nweigth : "+weight;
    }
}
