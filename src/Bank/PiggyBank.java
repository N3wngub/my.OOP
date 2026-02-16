package Bank;

public class PiggyBank implements Measureable {
    private int one;
    private int five;
    private int ten;
    private int size;

    public PiggyBank(int size) {
    this.size = size;
    }

    public double getMeasure() {
        return (one*1) + (five*5) + (ten*10);
    }
    public int addOne(int n) {
        if (size - (one + five + ten) <= 0) {
            return -1;
        } else if (n <= size - (one + five + ten)) {
            one += n;
        } else {
            one += (size - (one + five + ten));
        }
        return one;
    }

    public int addFive(int n) {
        if (size - (one + five + ten) <= 0) {
            return -1;
        } else if (n <= size - (one + five + ten)) {
            five += n;
        } else {
            five += (size - (one + five + ten)); // แก้จาก one เป็น five ให้แล้ว
        }
        return five;
    }

    public int addTen(int n) {
        if (size - (one + five + ten) <= 0) {
            return -1;
        } else if (n <= size - (one + five + ten)) {
            ten += n;
        } else {
            ten += (size - (one + five + ten)); 
        }
        return ten;
    }
}