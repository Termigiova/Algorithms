package Chapter1.Section1.exercise24;

public class Exercise24 {


    public static void printVariables(int p, int q) {

        System.out.printf("P: %d\n", p);
        System.out.printf("Q: %d\n", q);
        System.out.println("-----------");

    }

    // Euclid's greater common divisor
    public static int gcd(int p, int q) {

        printVariables(p,q);

        if (q == 0)
            return p;

        int r = p % q;

        return gcd(q, r);

    }


    public static void main (String args[]) {

        gcd(1111111,1234567);

    }


}
