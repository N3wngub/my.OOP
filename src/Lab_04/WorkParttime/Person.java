package WorkParttime;

public class Person {
    String firstname;
    String lastname;

    public Person() {
        firstname = "Unknown";
        lastname = "Unknown";
    }

    public Person(String firstname,String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }


    public String toString() {
        return "Firstname : " +firstname+"\nLastname : "+lastname;
    }
}
