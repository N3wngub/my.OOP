package Dog;

class Dog {
    String name;
    String breed;

    public Dog (){
    name = "Unknow";
    breed = "Unknow";
}

public String getName(){
    return name;
}
void setName (String name){
    this.name = name;

}
public String getBreed(){
    return breed;
}
void setBreed (String breed){
    this.breed = breed;
}
    public Dog (String name , String breed){
        this.name = name;
        this.breed = breed;
    }
void makeSound (){
    System.out.print("Boc Boc Boc");

}


}

