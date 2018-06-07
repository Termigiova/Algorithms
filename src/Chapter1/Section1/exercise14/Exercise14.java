package Chapter1.Section1.exercise14;

public class Exercise14 {

    public static int ln (int N) {

        int result = 1;

        for (int i = 1; i <= N; i++) {

            result *= 2;

        }

        return result - 1;

    }


    public static void main (String args[]) {

        int N;

        if (!args[0].isEmpty()) {

            N = Integer.parseInt(args[0]);

            if (N > 0) {

                System.out.printf("The largest int not larger than the base-2 logarithm is: %d", ln(N));

            } else {

                System.out.println("Error, N must be higher than 0");

            }


        }

    }



}
