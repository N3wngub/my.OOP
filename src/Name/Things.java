package Name;

public class Things implements Nameable{
    String name;
    String howToUse;

    public Things (String name,String howtoUse){
        this.name = name;
        this.howToUse = howtoUse;
    }

    public void setName(String n){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public String getHowToUse() {
        return howToUse;
    }

    public void setHowToUse(String howToUse) {
        this.howToUse = howToUse;
    }
    public String toString(){
        return getName();
    }
}
