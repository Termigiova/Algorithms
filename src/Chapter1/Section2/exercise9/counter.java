package Chapter1.Section2.exercise9;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Arrays;

public class counter {

    public class BinarySearch {

        public int rank(int key, int[] a, int counter) {
            // Array must be sorted.
            int lo  = 0;
            int hi = a.length - 1;
            while (lo <= hi){
                // Key is in a[lo..hi] or not present.
                int mid = lo + (hi - lo) / 2;
                if      (key < a[mid])  hi = mid - 1;
                else if (key > a[mid])  lo = mid + 1;
                else                    return mid;
                counter++;
            }
            return -1;
        }

        public void main(String[] args) {

            int[] whitelist = In.readInts(args[0]);
            int counter = 0;

            Arrays.sort(whitelist);
            while (!StdIn.isEmpty()) {
                // Read key, print if not in whitelist.
                int key = StdIn.readInt();
                if (rank(key, whitelist,counter) < 0)
                    StdOut.println(key);

            }
        }
    }

}
