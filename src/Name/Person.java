package Name;

public class Person implements Nameable{
    String name;
    String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String n){
        this.name = name;
    }
    public String getName(){
      return name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public String toString(){
        return getName();
    }


}