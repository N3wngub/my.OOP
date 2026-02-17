package MixedNumber;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            this.denominator = 1; // กัน error ส่วนเป็น 0
        } else {
            this.denominator = denominator;
        }
    }

    public int getNumerator() { return numerator; }
    public int getDenominator() { return denominator; }

    public void print() {
        System.out.print(numerator + "/" + denominator);
    }

    // หา ห.ร.ม. (ใช้สำหรับทอนเศษส่วนอย่างต่ำ)
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // สร้างเศษส่วนใหม่ที่เป็นอย่างต่ำ (สำหรับข้อ 2 ขึ้นไป)
    public Fraction makeNewFormat() {
        int common = gcd(Math.abs(numerator), Math.abs(denominator));
        return new Fraction(numerator / common, denominator / common);
    }

    // บวก (สำหรับข้อ 4, 8, 9)
    public Fraction add(Fraction f2) {
        int newNum = (this.numerator * f2.denominator) + (f2.numerator * this.denominator);
        int newDen = this.denominator * f2.denominator;
        return new Fraction(newNum, newDen); // ยังไม่ต้องทอน เดี๋ยวไปทอนตอนจบ
    }

    // ลบ (สำหรับข้อ 5)
    public Fraction minus(Fraction f2) {
        int newNum = (this.numerator * f2.denominator) - (f2.numerator * this.denominator);
        int newDen = this.denominator * f2.denominator;
        return new Fraction(newNum, newDen);
    }

    // คูณ (สำหรับข้อ 6)
    public Fraction multiply(Fraction f2) {
        return new Fraction(this.numerator * f2.numerator, this.denominator * f2.denominator);
    }

    // หาร (สำหรับข้อ 7)
    public Fraction divide(Fraction f2) {
        return new Fraction(this.numerator * f2.denominator, this.denominator * f2.numerator);
    }
}
