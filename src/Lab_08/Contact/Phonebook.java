package Contact;

import java.util.ArrayList;

public class Phonebook {
    private String name;
    private String phoneNum;

    public Phonebook(String name, String phoneNum){
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String toString(){
        return "Name: " + name + ", Phone: " + phoneNum;
    }
}
