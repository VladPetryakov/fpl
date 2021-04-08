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
		return res;
    }
    
    public Fraction Mult(Fraction a, Fraction b) {
        Fraction res = new Fraction();
        res.num = a.num * b.num;
        res.den = a.den * b.den;
        Sokr(res);
        return res;
    }

    public Fraction MultFractOnInt(Fraction f, int number) {
        Fraction res = new Fraction();
        res.den = f.den;
        res.num = f.num * number;
        return res;
    }

    public Fraction Add(Fraction a, Fraction b) {
        Fraction res = new Fraction();
        res.num = a.num * b.den + b.num * a.den;
        res.den = b.den * a.den;
        Sokr(res);
        return res;
    }
};
