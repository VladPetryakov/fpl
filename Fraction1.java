package simplemodeldialog;

import java.io.Serializable;

public class Fraction implements Serializable{
    int num, den;

    public Fraction(){
        num = 0;
        den = 1;
    }
    
    public Fraction(int num, int den){
        this.num = num;
        this.den = den;
    }

    private int GCD (int a, int b) {
	while ((a != 0) && (b != 0)) {
            if (a >= b) 
                a %= b; 
            else 
                b %= a;
	}

	return a + b;
    }
    
    public Fraction Sokr (Fraction f) {
        int gcd;
        Fraction res = new Fraction();

        gcd = GCD (Math.abs(f.num), Math.abs(f.den));
        res.num = f.num / gcd;
        res.den = f.den / gcd;

        if (res.den < 0) {
            res.num *= -1;
            res.den *= -1;
        }
    }
    
    public Fraction Mult(Fraction right) 
    {
        Fraction t = new Fraction();
        t.num = this.num * right.num;
        t.den = this.den * right.den;
        t.Sokr();
        return t;
    }

    public Fraction MultFractOnInt(int right) {
        Fraction t = new Fraction();
        t.den = this.den;
        t.num = this.num * right;
        return t;
    }

    public Fraction Add(Fraction right) {
        Fraction t = new Fraction();
        int td = right.den;
        Fraction fr = new Fraction();

        this.Sokr();

        fr.num = right.num * this.den;
        fr.den = right.den * this.den;

        t.den = this.den * td;
        t.num = this.num * td;
        t.num = t.num + fr.num;

        t.Sokr();

        return t;
    }
};
