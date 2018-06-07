// Sorting three numbers.
// Suppose  that  the  variables a, b, c, and t are all of the same numeric primitive type.
// Show that the following code puts a, b, and c in ascending order: sorting(int a, int b, int c)

package Chapter1.Section1.exercise26;

public class Exercise26 {


    public static void sorting(int a, int b, int c) {

        int t;

        if (a > b) { t = a; a = b; b = t; }
        if (a > c) { t = a; a = c; c = t; }
        if (b > c) { t = b; b = c; c = t; }

        System.out.printf("a: %d, b: %d, c: %d\n", a, b, c);

    }


    public static void main (String args[]) {

        sorting(1,2,3);
        sorting(1,3,2);
        sorting(3,2,1);

    }


}
