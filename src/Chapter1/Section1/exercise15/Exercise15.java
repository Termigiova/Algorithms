// Write a static method histogram() that takes an array a[] of int values and an integer M as arguments
// and returns an array of length M whose ith entry is the num-ber of times the integer i appeared in the argument array.
// If the values in a[] are all between 0  and M–1,  the  sum  of  the  values  in  the  returned  array  should  be  equal  to a.length.

package Chapter1.Section1.exercise15;

import java.util.Random;

public class Exercise15 {


    public static int[] histogram(int a[], int M) {

        int arr[] = new int[M];

        // Initialize array in zeroes
        for (int i = 0; i < arr.length; i++)
            arr[i] = 0;

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a.length; j++) {

                if( a[j] == i)
                    arr[i]++;

            }

        }

        return arr;

    }


    public static void main (String args[]) {

        int a[] = new int[10];
        int M = 20;

        Random random = new Random();

        // Fill a array
        for (int i = 0; i < a.length; i++) {

            a[i] = random.nextInt(M + 1);

        }

        int arr[];
        int sum = 0;

        arr = histogram(a, M);

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0)
                sum++;

        }

        System.out.println("The sum is: " + sum);

        System.out.print(exR1(6));
    }

    public static String exR1(int n) {if (n <= 0) return "";return exR1(n-3) + n + exR1(n-2) + n; }


}
