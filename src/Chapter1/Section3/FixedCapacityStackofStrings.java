package Chapter1.Section3;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class FixedCapacityStackofStrings {

    private String[] stackEntries;
    private int size;

    public FixedCapacityStackofStrings(int cap) {
        stackEntries = new String[cap];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(String item) {
        stackEntries[size++] = item;
    }

    public String pop() {
        return stackEntries[--size];
    }

    public boolean isFull(){
        return stackEntries.length == size;
    }

    public static void main(String[] args) {
        FixedCapacityStackofStrings stackofStrings;
        stackofStrings = new FixedCapacityStackofStrings(100);
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stackofStrings.push(item);
            else if (!stackofStrings.isEmpty())
                StdOut.print(stackofStrings.pop() + " ");
        }
        StdOut.println("(" + stackofStrings.size() + " left on stack)");
    }

}
