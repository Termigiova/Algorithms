package Chapter1.Section2.exercise2;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Interval1D {

    private double min;
    private double max;

    public Interval1D (double min, double max) {

        this.min = min;
        this.max = max;

    }

    public boolean intersects(Interval1D that) {

        if (this.min <= that.min && that.min <= this.max) return true;
        if (this.min <= that.max && that.max <= this.max) return true;
        if (that.min <= this.min && this.min <= that.max) return true;
        if (that.min <= this.max && this.max <= that.max) return true;
        return false;

    }

    public boolean contains(Interval1D that) {

        return false;

    }

    public String toString() {

        return "[" + min + "," + max + "]";

    }

    public static void main (String args[]) {

        int N = Integer.parseInt(args[0]);
        Interval1D[] interval = new Interval1D[N];
        double min, max;

        for (int i = 0; i < N; i++) {
            StdOut.println("Interval #" + (i + 1));
            StdOut.print("Enter the min value: ");
            min = StdIn.readDouble();
            StdOut.print("Enter the max value: ");
            max = StdIn.readDouble();
            interval[i] = new Interval1D(min,max);
        }

        for (int i = 0; i < N - 1; i++)
            if(interval[i].intersects(interval[i + 1]))
                StdOut.println("Interval " + (i + 1) + ":" + interval[i]);


    }

}
