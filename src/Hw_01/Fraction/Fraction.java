package Fraction;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(){
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(int n,int d){
        this.numerator = n;
        this.denominator = d;
    }

    public void setValue(int n,int d){
        this.numerator = n;
        this.denominator = d;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void print() {
        System.out.println(numerator + "/" + denominator );
    }

    private int gcd(int n,int d){
        if(d == 0){
            return n;
        }else {
            return gcd(d,n%d);
        }
    }

    public Fraction makeNewFormat() {
        int g = gcd(numerator, denominator);
        int n = numerator / g;
        int d = denominator / g;
        if (d < 0) {
            n = -n;
            d = -d;
        }
        return new Fraction(n, d);
    }

    public Fraction add(Fraction f2) {
        int n = this.numerator * f2.denominator + f2.numerator * this.denominator;
        int d = this.denominator* f2.denominator;
        return new Fraction(n,d).makeNewFormat();
    }

    public Fraction multiply(Fraction f2) {
        int n = this.numerator * f2.numerator;
        int d = this.denominator * f2.denominator;
        return new Fraction(n, d).makeNewFormat();
    }

    public Fraction minus(Fraction f2){
        int n = this.numerator * f2.denominator - f2.numerator * this.denominator;
        int d = this.denominator * f2.denominator;
        return new Fraction(n, d).makeNewFormat();
    }

    public Fraction divide(Fraction f2){
        int n = this.numerator * f2.denominator;
        int d = this.denominator * f2.numerator;
        return new Fraction(n, d).makeNewFormat();
    }

    public boolean isCanReduce(){
        boolean check = true;
        if(gcd(numerator,denominator) != 1){
            return check;
        }else {
            return false;
        }
    }

    public int getGcd(){
        return gcd(numerator,denominator);
    }

}
