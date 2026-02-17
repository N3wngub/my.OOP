package Fraction;

public class MixedNumber {
    private int numberals;
    private Fraction fraction;

    public MixedNumber() {
        this.numberals = 0;
        this.fraction = new Fraction(0, 1);
    }

    public MixedNumber(int numberals,Fraction fraction){
        this.numberals = numberals;
        this.fraction = fraction;
    }

    public int getNumberals() {
        return numberals;
    }

    public Fraction getFraction() {
        return fraction;
    }

    public void setValue(int n, Fraction f) {
        this.numberals = n;
        this.fraction = f;
    }

    public void print() {
        if (fraction.getDenominator() == 0 || fraction.getNumerator() == 0) {
            System.out.println(numberals + " 0/0");
        } else {
            System.out.println(numberals + " " + fraction.getNumerator() + "/" + fraction.getDenominator());
        }
    }

    public Fraction convertToFraction() {
        int n = (this.numberals * fraction.getDenominator()) + fraction.getNumerator();
        int d = fraction.getDenominator();

        Fraction improper = new Fraction(n, d);
        return improper.makeNewFormat();
    }

    public MixedNumber makeNewFormat() {
        Fraction simplified = this.fraction.makeNewFormat();

        int n = simplified.getNumerator();
        int d = simplified.getDenominator();

        int extraWhole = n / d;
        int finalNumerator = n % d;

        this.numberals += extraWhole;
        this.fraction = new Fraction(finalNumerator, d);

        return this;
    }

    public MixedNumber add(MixedNumber m) {
        Fraction f1 = this.convertToFraction();
        Fraction f2 = m.convertToFraction();
        Fraction result = f1.add(f2);
        return new MixedNumber(0, result).makeNewFormat();
    }

    public MixedNumber add(Fraction f) {
        Fraction f1 = this.convertToFraction();
        Fraction result = f1.add(f);
        return new MixedNumber(0, result).makeNewFormat();
    }

    public MixedNumber minus(MixedNumber m) {
        Fraction f1 = this.convertToFraction();
        Fraction f2 = m.convertToFraction();
        Fraction result = f1.minus(f2);
        return new MixedNumber(0, result).makeNewFormat();
    }

    public MixedNumber multiply(MixedNumber m) {
        Fraction f1 = this.convertToFraction();
        Fraction f2 = m.convertToFraction();
        Fraction result = f1.multiply(f2);
        return new MixedNumber(0, result).makeNewFormat();
    }

    public MixedNumber divide(MixedNumber m) {
        Fraction f1 = this.convertToFraction();
        Fraction f2 = m.convertToFraction();
        Fraction result = f1.divide(f2);
        return new MixedNumber(0, result).makeNewFormat();
    }
}

