package Chapter1.Section3;

import edu.princeton.cs.introcs.StdOut;
import Chapter1.Section3.PushdownStack.Stack;

public class BinaryRepresentation {

    public static void main(String args[]) {
        int N = 50;
        Stack<Integer> stack = new Stack<>();
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack)
            StdOut.print(d);
        StdOut.println();
    }

}
