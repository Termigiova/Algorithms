package Chapter1.Section2.exercise10;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

public class VisualCounter {

    private final int max, N;
    private int op, value;

    public VisualCounter(int N, int max) {

        this.N = N;         // Maximum number of operations
        this.max = max;     // Maximum absolute value for the counter
        this.value = 0;
        this.op = 1;

        StdDraw.setXscale(0,N + 1);
        StdDraw.setYscale(0,max);

    }

    public void increment() {

        if (op <= N && value <= max) {
            value++;
            StdDraw.point(op, value);
            op++;
        } else if (op == N)
            StdOut.println("Cannot do more operations");

    }

    public void decrement() {

        if (op <= N && value > 0) {
            value--;
            StdDraw.point(op, value);
            op++;
        } else if (value == 0)
            StdOut.println("Cannot decrement lower than 0");
        else if (op == N)
            StdOut.println("Cannot do more operations");


    }

    public String toString() {

        return "The counter value is: " + value;

    }

    public static void main (String arg[]) {

        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.RED);

        VisualCounter vc = new VisualCounter(5, 10);
        vc.increment();
        vc.increment();
        vc.increment();
        vc.decrement();
        vc.decrement();
        vc.decrement();


    }

}
