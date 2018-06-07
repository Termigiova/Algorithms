//Write a program that takes three integer command-line arguments and prints equal if all three are equal, and not equal otherwise

package Chapter1.Section1.exercise3;

public class Exercise3 {


    public static void main (String args[]) {

        boolean isRepeated = true;

        for (int i = 0; i < args.length - 1; i++) {

            for (int j = i + 1; j < args.length; j++)
                if (Integer.parseInt(args[i]) != Integer.parseInt(args[j]))
                    isRepeated = false;

        }

        if (isRepeated)
            System.out.printf("Equal");
        else
            System.out.printf("Not equal");

    }


}
