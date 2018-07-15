package Chapter1.Section3.exercise15;

import Chapter1.Section3.FIFO.Queue;
import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class printLastStringFromStdIn {

    private Queue<String> queue = new Queue<String>();
    private Scanner scanner = new Scanner(System.in);

    private void scan() {
        System.out.print("Enter some strings: ");
        try {
            while(true) {
                enqueue(scanner.next());
            }
        } catch (NoSuchElementException e) {

        }
    }

    private void enqueue(String item){
        queue.enqueue(item);
    }

    private String lastQueueString() {
        if (queue.isEmpty())
            return "Error: Empty queue";

        Iterator<String> itr = queue.iterator();
        String lastElement = itr.next();
        while(itr.hasNext())
            lastElement = itr.next();

        return lastElement;
    }

    public static void main(String args[]) {

        printLastStringFromStdIn test = new printLastStringFromStdIn();

        test.scan();
        StdOut.print(test.lastQueueString());

    }

}
