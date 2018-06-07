// Write a code fragment that prints true if the double variables x and y are both strictly between 0 and 1 and false otherwise

package Chapter1.Section1.exercise5;

public class Exercise5 {


    public static boolean isBetween(double value) {

        if ( 0 < value && value < 1)
            return true;

        return false;

    }

    public static void main (String args[]) {

        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        System.out.printf("x -> %f \n", x);
        System.out.printf("y -> %f \n", y);
        System.out.printf("Are both variables strictly between 0 and 1? ");

        if ( isBetween(x) && isBetween(y) )
            System.out.printf("True");
        else
            System.out.printf("False");

    }


}
