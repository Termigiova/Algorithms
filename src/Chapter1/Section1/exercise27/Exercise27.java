// Binomial  distribution. Estimate the number of recursive calls that would be used by the code: binomial(int N, int k, double p)
// to  compute binomial(100,  50).  Develop  a  better  implementation  that  is  based  on saving computed values in an array.

package Chapter1.Section1.exercise27;

public class Exercise27 {

    public static int calls = 0;

    public static double binomial(int N, int k, double p) {

        calls++;

        if ((N == 0) || (k < 0))
            return 1.0;

        return (1.0 - p)*binomial(N-1, k, 0.25) + p*binomial(N-1, k-1, 0.25);

    }


    public static void main (String args[]) {

//        binomial(100, 50, 0.25);
        binomial(10, 5, 0.25);
        System.out.printf("Number of calls: " + calls);

    }

}
