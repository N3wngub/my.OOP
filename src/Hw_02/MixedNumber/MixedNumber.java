package MixedNumber;

public class MixedNumber {
    private int numberals;
    private Fraction fraction;

    public MixedNumber() {
        this.numberals = 0;
        this.fraction = new Fraction(0, 1);
    }

    public void setValue(int numberals, Fraction fraction) {
        this.numberals = numberals;
        this.fraction = fraction;
    }

    // แสดงผล
    public void print() {
        if (fraction.getNumerator() == 0) {
            System.out.print(numberals);
        } else if (numberals == 0) {
            fraction.print();
        } else {
            System.out.print(numberals + " ");
            fraction.print();
        }
        // *ระวัง: บางโจทย์อาจต้องการ println หรือไม่ต้องการ เช็คดีๆ*
    }

    // ข้อ 3: แปลงเป็นเศษเกิน (Improper Fraction)
    public Fraction convertToFraction() {
        int newNum = (this.numberals * fraction.getDenominator()) + fraction.getNumerator();
        return new Fraction(newNum, fraction.getDenominator());
    }

    // ข้อ 2: จัดรูปแบบ (ดึงเศษเกินมาเป็นจำนวนเต็ม + ทอนเศษส่วน)
    public MixedNumber makeNewFormat() {
        int num = fraction.getNumerator();
        int den = fraction.getDenominator();

        int extraWhole = num / den;     // จำนวนเต็มที่งอกเพิ่มจากเศษ
        int newNum = num % den;         // เศษที่เหลือ

        // ทอนเป็นอย่างต่ำ
        Fraction temp = new Fraction(newNum, den);
        Fraction simplified = temp.makeNewFormat();

        MixedNumber result = new MixedNumber();
        result.setValue(this.numberals + extraWhole, simplified);
        return result;
    }

    // ข้อ 4, 8: บวก
    public MixedNumber add(MixedNumber m2) {
        Fraction f1 = this.convertToFraction();
        Fraction f2 = m2.convertToFraction();
        Fraction res = f1.add(f2); // บวกกันเป็นเศษเกิน

        MixedNumber ans = new MixedNumber();
        ans.setValue(0, res); // ใส่ 0 ไว้ แล้วให้ makeNewFormat จัดการแปลงกลับ
        return ans.makeNewFormat();
    }

    // Overload สำหรับบวกเศษส่วน (ข้อ 8)
    public MixedNumber add(Fraction f2) {
        Fraction f1 = this.convertToFraction();
        Fraction res = f1.add(f2);

        MixedNumber ans = new MixedNumber();
        ans.setValue(0, res);
        return ans.makeNewFormat();
    }

    // ข้อ 5: ลบ
    public MixedNumber minus(MixedNumber m2) {
        Fraction f1 = this.convertToFraction();
        Fraction f2 = m2.convertToFraction();
        Fraction res = f1.minus(f2);

        MixedNumber ans = new MixedNumber();
        ans.setValue(0, res);
        return ans.makeNewFormat();
    }

    // ข้อ 6: คูณ
    public MixedNumber multiply(MixedNumber m2) {
        Fraction f1 = this.convertToFraction();
        Fraction f2 = m2.convertToFraction();
        Fraction res = f1.multiply(f2);

        MixedNumber ans = new MixedNumber();
        ans.setValue(0, res);
        return ans.makeNewFormat();
    }

    // ข้อ 7: หาร
    public MixedNumber divide(MixedNumber m2) {
        Fraction f1 = this.convertToFraction();
        Fraction f2 = m2.convertToFraction();
        Fraction res = f1.divide(f2);

        MixedNumber ans = new MixedNumber();
        ans.setValue(0, res);
        return ans.makeNewFormat();
    }
}