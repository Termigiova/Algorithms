package Chapter1.Section3;

import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;

public class CircularLinkedList<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private Integer N = 0;

    private class Node {
        Node next;
        Item item;
    }

    private boolean isEmpty()   {   return first == null;   }
    private Integer size()      {   return N;               }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty())      first = last;
        else if(N == 1) {
            first = oldLast;
            first.next = last;
            last.next = first;
        } else {
            oldLast.next = last;
            last.next = first;
        }
        N++;
    }

    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        if (isEmpty())  last = first;
        N--;
        return item;
    }

    public void printList() {
        Iterator<Item> itr = iterator();
        for (int i = 0; i < N; i++)
            StdOut.print(itr.next());
        StdOut.println();
    }

    public Iterator<Item> iterator()
    {   return new ListIterator();  }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean  hasNext()   {   return current != last;     }
        public void     remove()    {                               }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void testEnqueueList(CircularLinkedList list) {
        for (int i = 1; i < 10; i++)
            list.enqueue(i);
    }

    public static void testDequeueList(CircularLinkedList list) {
        for (int i = 1; i < 5; i++)
            list.dequeue();
    }

    public static void main (String args[]) {

        CircularLinkedList<Integer> testList = new CircularLinkedList<>();

        testEnqueueList(testList);
        testList.printList();

        testDequeueList(testList);
        testList.printList();
    }

}
