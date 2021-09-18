import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(), in.nextInt());
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.plus(b));
        System.out.println(a.multiply(b).plus(new Fraction(5,6)));
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.toDouble());
        in.close();
    }
}

class Fraction {
    private int Molecular = 0;
    private int Denominator = 0;

    public int gcd(int a, int b) {
        int x = Math.abs(a);
        int y = Math.abs(b);
        int r = x % y;
        while(r != 0)
        {
            x = y;
            y = r;
            r = x % y;
        }
        return y;
    }

    public Fraction(int a, int b) {
        if (a == 0 || b == 0) {
            Molecular = 0;
            Denominator = 0;
            return;
        }
        int t = gcd(a, b);
        Molecular = a/t;
        Denominator = b/t;
    }
    
    @Override
    public String toString() {
        if (Molecular == 0 || Denominator == 0) {
            return "0";
        }

        if (Molecular == 1 && Denominator == 1) {
            return "1";
        }

        int tag1 = (Molecular < 0)?1:0;
        int tag2 = (Denominator < 0)?1:0;

        if (tag1 + tag2 == 1) {
            Molecular = -Math.abs(Molecular);
            Denominator = Math.abs(Denominator);
        }
        else {
            Molecular = Math.abs(Molecular);
            Denominator = Math.abs(Denominator);
        }

        return ""+Molecular+"/"+Denominator;
    }

    public Fraction plus(Fraction that) {
        Fraction result = new Fraction(0, 0);
        if (this.Molecular == 0)
        {
            result.Molecular = that.Molecular;
            result.Denominator = that.Denominator;;
            return result;
        }
        if (that.Molecular == 0)
        {
            result.Molecular = this.Molecular;
            result.Denominator = this.Denominator;
            return result;
        }
        int m = this.Molecular*that.Denominator+that.Molecular*this.Denominator;
        int d = this.Denominator*that.Denominator;
        int t = gcd(m, d);
        result.Molecular = m/t;
        result.Denominator = d/t;
        return result;
    }

    public Fraction multiply(Fraction that) {
        Fraction result = new Fraction(0, 0);
        int m = this.Molecular*that.Molecular;
        int d = this.Denominator*that.Denominator;
        if (m == 0 || d == 0)
        {
            result.Molecular = 0;
            result.Denominator = 0;
            return result;
        }
        int t = gcd(m, d);
        result.Molecular = m/t;
        result.Denominator = d/t;
        return result;
    }

    public double toDouble() {
        double M = Molecular;
        double D = Denominator;
        return M/D;
    }
}