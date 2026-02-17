package Employee;

public class Programmer extends Employee {
    String[] progSkills;
    int OT;

    public Programmer(String name , double salary,String[] progSkills , int OT ){
        super(name,salary);
        this.progSkills = progSkills;
        this.OT = OT;
    }

    public String[] getProgSkills() {
        return progSkills;
    }

    public void setProgSkills(String[] progSkills) {
        this.progSkills = progSkills;
    }

    public int getOT() {
        return OT;
    }

    public void setOT(int OT) {
        this.OT = OT;
    }

    @Override
    public double calSalary() {
        return super.calSalary() + getOT();
    }

    public String toString(){
        String Skills = "";
        for (int i = 0; i < progSkills.length; i++) {
            Skills += progSkills[i] ;
            if(i < progSkills.length-1){
                Skills += "," ;
            }

        }
        return "My name is " + getName() + "\nI am a programmer." +"My programmer skill are : " + Skills +"\nMy salary is " + calSalary() ;
    }

}
