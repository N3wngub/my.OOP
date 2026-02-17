package Student;

public class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public String checkStatus() {
        if (gpa >= 2.00) {
            return "Normal";
        } else if (gpa >= 1.75) {
            return "Probation";
        } else {
           return  "Retired";
        }

    }

    public String getType() {

       if (id.length() < 3 ){
           return "Null";
       }
        if (id.charAt(2) == '1') {
            return "Day";
        } else if (id.charAt(2) == '6') {
            return "Special";
        } else {
            return "Null";
        }

    }


}
