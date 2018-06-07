// Write a code fragment that prints the contents of a two-dimensional boolean array, using * to represent true and a space to represent false. Include row and column numbers.

package Chapter1.Section1.exercise11;

import java.util.Random;

public class Exercise11 {


    private static Random random;

    public static boolean getRandomBoolean() {

        return random.nextBoolean();

    }


    public static void main (String args[]) {

        random = new Random();

        boolean arr[][] = new boolean[5][5];

        // Set random boolean values for the two-dimensional array and print result
        for (int i = 0; i < arr.length; i++) {

            System.out.print("|");

            for (int j = 0; j < arr[0].length; j++) {

                arr[i][j] = getRandomBoolean();
                if (arr[i][j])
                    System.out.print("*");
                else
                    System.out.print(" ");

                System.out.print("|");

            }

            System.out.println();

        }

    }


}
