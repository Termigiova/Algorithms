// Write a code fragment to print the transposition (rows and columns changed) of a two-dimensional array with M rows and N columns

package Chapter1.Section1.exercise13;

public class Exercise13 {


    public static void main (String args[]) {

        int rows, columns;

        if (!args[0].isEmpty() && !args[1].isEmpty()) {

            rows = Integer.parseInt(args[0]);
            columns = Integer.parseInt(args[1]);
            int arr[][] = new int [columns][rows];

            // Array
            System.out.println("Array");
            for (int i = 0; i < arr.length; i++) {

                System.out.print("|");

                for (int j = 0; j < arr[0].length; j++) {

                    System.out.print(arr[i][j]);
                    System.out.print("|");

                }

                System.out.println();

            }

            System.out.println();

            // Transposition of the array
            System.out.println("Transposition of the array");
            for (int i = 0; i < arr[0].length; i++) {

                System.out.print("|");

                for (int j = 0; j < arr.length; j++) {

                    System.out.print(arr[j][i]);
                    System.out.print("|");

                }

                System.out.println();

            }

        }



    }


}
