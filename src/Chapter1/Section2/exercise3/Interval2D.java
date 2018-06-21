package Chapter1.Section2.exercise3;

import Chapter1.Section2.exercise2.Interval1D;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class Interval2D {

    private Interval1D Ix, Iy;

    public Interval2D (double min, double max) {

        double Xmin = StdRandom.uniform(min,max);
        double Xmax = StdRandom.uniform(Xmin,max);
        double Ymax = getYHeight(min,max);
        double Ymin = StdRandom.uniform(0.0,Ymax);

        Ix = new Interval1D(Xmin,Xmax);
        Iy = new Interval1D(Ymin,Ymax);

        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BLUE);

        StdDraw.rectangle(min + (Xmin - min) + ((Xmax - Xmin) / 2),((Ymax - Ymin) / 2) + Ymin,(Xmax - Xmin) / 2,(Ymax - Ymin) / 2);

    }

    private double getYHeight(double min, double max) { return ( 1.0 / (max - min) ); }

    public int intersects(Interval2D that) {

        int intersects = 0;

        if(intersectAxis(this.Ix, that.Ix) && intersectAxis(this.Iy, that.Iy))
            intersects += 2;

        return intersects;

    }

    private boolean intersectAxis(Interval1D a, Interval1D b) {

        if (a.intersects(b)) return true;
        if (b.intersects(a)) return true;
        return false;

    }

    public boolean contains(Interval2D that) {

        return this.Ix.intersects(that.Ix) && that.Iy.intersects(this.Iy);

    }

    public static void main (String args[]) {

        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        int intersects = 0;
        int contains = 0;

        Interval2D[] interval = new Interval2D[N];

        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setXscale(0, max*1.5);
        StdDraw.setYscale(0, 1);
        StdDraw.rectangle((max/2)*1.5, 1.0/2, (max/2)*1.5, 1.0/2);

        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.line(min,0,min,1);
        StdDraw.line(max,0,max,1);

        for (int i = 0; i < N; i++)
            interval[i] = new Interval2D(min, max);

        for (int i = 0; i < N - 1; i++){

            intersects += interval[i].intersects(interval[i + 1]);

            if (interval[i].contains(interval[i + 1]))
                contains++;

        }

        StdOut.println("Number of pairs that intersect: " + intersects);
        StdOut.println("Number of intervals that are contained in one another: " + contains);

    }

}
