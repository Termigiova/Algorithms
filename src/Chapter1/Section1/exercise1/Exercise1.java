//  Give the value of each of the following expressions:
//        a. ( 0 + 15 ) / 2
//        b. 2.0e-6 * 100000000.1
//        c.  true && false || true && true

package Chapter1.Section1.exercise1;

public class Exercise1 {


    public static double a () {

        return ( 0 + 15 ) / 2;

    }

    public static double b () {

        return 2.0e-6 * 100000000.1;

    }

    public static boolean c () {

        return true && false || true && true;

    }


    public static void main (String[] args) {

        System.out.printf("a. %f \n", a());
        System.out.printf("b. %f \n", b());
        System.out.printf("c. %b \n", c());

    }


}