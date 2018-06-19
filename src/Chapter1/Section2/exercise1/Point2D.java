package Chapter1.Section2.exercise1;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class Point2D {

    private int N;
    private double prev;
    private double lower = Double.MAX_VALUE;

    public Point2D(int trials, double max) {

        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(0.005);

    }

    public void addDataValue(double val) {

        N++;
        if(Math.abs(val - prev) < lower)
            lower = Math.abs(val);
        prev = val;
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.point(N, val);

    }

    public String toString() {

        return "The distance separating the closest pair is: " + lower;

    }

    public static void main (String args[]) {

        int N = Integer.parseInt(args[0]);
        Point2D a = new Point2D(N, 1.0);
        for (int i = 0; i < N; i++)
            a.addDataValue(StdRandom.gaussian());
        StdOut.println(a);
        StdOut.println(a);

    }

}
