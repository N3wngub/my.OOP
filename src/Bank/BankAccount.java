package Bank;
public class BankAccount implements Measureable{
    private String accNo;
    private double balance;

    public BankAccount(String accNo,double balance){
        this.accNo = accNo;
        this.balance = balance;
    }
    public double getMeasure(){
        return getBalance();
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public double getBalance() {
        return balance;
    }

    public String toString(){
        return  "Acc no : " + getAccNo() + " Balance : " + getBalance();
    }
}

