package WorkParttime;

public class ParttimeEmployee extends Person {
        int hour;
        int rate;

        public ParttimeEmployee() {
            super();

        }

        public ParttimeEmployee(Person firstname, Person lastname) {
            super(firstname.getFirstname(), lastname.getLastname());
        }
        public void setHour(int hour){
            this.hour =hour;
        }

        public int getHour(){
            return hour;
        }
        public void setRate(int rate){
            this.rate =rate;
        }

        public int getRate(){
            return rate;
        }

        public String toString() {
            return super.toString();
        }

        public void pay(){
            System.out.println("Have salary : "+(hour*rate));
        }
}
