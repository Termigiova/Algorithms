package Chapter1.Section1.exercise20;

public class Exercise20 {


    public static int Factorial (int N) {

        int factorial = 1;

        for (int i = N; i > 0 ; i--) {

            factorial *= i;

        }

        return factorial;

    }


    public static void main (String args[]) {

        int N = 5;

        System.out.println("Factorial of 5 is: " + Factorial(N));
        System.out.println("The natural logarithm of the factorial of " + N + " is: " + Math.log(Factorial(N)));


    }


}
