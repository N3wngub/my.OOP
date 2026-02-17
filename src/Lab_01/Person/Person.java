package Person;

class Person {
    String name;
    double height;
    double weight;

public Person (){
    name = "Unknown";
    height = 0;
    weight = 0;

}
 public String getName(){
    return name;
 }
 void setName(String name){
    this.name = name;
 }
    public double getHeight(){
    return height;
    }
    void setHeight(double height){
    this.height = height;
    }
    public double getWeight(){
    return weight;
    }
    void setWeight(double weight){
    this.weight = weight;
    }

    public double bmi (){
    return this.weight/(height*height);

    }
}
