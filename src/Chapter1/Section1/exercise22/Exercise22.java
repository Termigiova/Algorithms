package Chapter1.Section1.exercise22;

import java.util.ArrayList;
import java.util.List;

public class Exercise22 {

    private static int depth = 0;

    public static int rank(int key, List list) {

        return rank(key, list, 0, list.size() - 1);

    }

    private static int rank(int key, List list, int lo, int hi) {

        // Index of key in a[], if present, is not smaller than lo
        //                                  and not larger than hi.

        System.out.printf("Low : %d \n", lo + 1);
        System.out.printf("High : %d \n", hi + 1);
        System.out.printf("Depth : %d \n", depth++);

        if (lo > hi)
            return -1;

        int mid = lo + (hi - lo) / 2;

        if (key == (int)list.get(mid))
            return mid;
        else if (key < (int)list.get(mid))
            return rank(key, list, lo, mid - 1);
//        else if (key > a[mid])
        return rank(key, list, mid + 1, hi);


    }


    public static void main (String args[]) {

        List list = new ArrayList();

        for (int i = 0; i < 100; i++) {

            list.add(i, i);

        }

        if(rank(76, list) != (-1))
            System.out.print("Success!");


    }


}
