package Chapter1.Section3.DoublyLinkedList;

import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;

public class DoublyLinkedList<Item> implements Iterable<Item> {

    private Node    first;  //  Link to least recently added node
    private Node    last;   //  Link to most recently added node
    private int     N = 0;  //  Number of items in the queue

    private class Node
    {
        Item item;
        Node next;
        Node previous;
    }

    private boolean  isEmpty()   {   return first == null;   }   //  Or: N == 0
    private int      size()      {   return N;               }

    private void enqueue(Item item)
    {   //  Add item to the end of the list
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else {
            oldLast.next = last;
            last.previous = oldLast;
        }
        N++;
    }

    private Item dequeue()
    {   //  Remove item from the beginning of the list
        Item item = first.item;
        first = first.next;
        first.previous = null;
        if (isEmpty())  last = null;
        N--;
        return item;
    }

    private void delete(Integer element) {
        try {
            Node current = getNthElementInList(element);
            Node next = current.next;
            Node previous = current.previous;

            next.previous = previous;
            previous.next = next;
        } catch (Exception e) {
            StdOut.print("Error: " + e);
        }
    }

    private Node getNthElementInList(Integer element) {
        Node current = last;
        if (element == 0 || element > N)
            return null;

        for (int i = 0; i < N - element; i++)
            current = current.previous;
        return current;
    }

    private void removeLastNode() {
        last = last.previous;
        last.next = null;
        N--;
    }

    private void find(Item item) {

    }

    public Iterator<Item> iterator()
    {   return new ListIterator();  }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean  hasNext()   {   return current != null;     }
        public void     remove()    {
            Node previous = current.previous;
            Node next = current.next;
            previous.next = next;
            next.previous = previous;
            N--;
        }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private static void fillList(DoublyLinkedList list) {
        for (int i = 1; i < 10; i++)
            list.enqueue(i);
    }

    private static void printList(DoublyLinkedList list) {
        for (Object item:list)
            StdOut.print(item);
        StdOut.println();
    }

    private static void delete(DoublyLinkedList list, Integer element) {
        Iterator<Object> itr = list.iterator();
        for (int i = 0; i < element; i++)
            itr.next();
        itr.remove();
    }

    private static boolean find(DoublyLinkedList list, Object element) {
        Iterator<Object> itr = list.iterator();
        Object value = itr.next();
        while(itr.hasNext()) {
            if (value.equals(element))
                return true;
            value = itr.next();
        }
        return false;
    }

    public static void main(String args[]) {

        DoublyLinkedList<Integer> testLinkedList = new DoublyLinkedList<>();

        // Exercise 1.3.19
        // Code fragment that removes the last node in a linked list whose first node is first.
        fillList(testLinkedList);
        printList(testLinkedList);

        testLinkedList.removeLastNode();
        printList(testLinkedList);

        // Exercise 1.3.20
        // Method delete() that takes an int argument k and deletes the kth element in a linked list, if it exists.
        delete(testLinkedList, 5);
        printList(testLinkedList);

        // Exercise 1.3.21
        // Method find() that takes a linked list and a string key as arguments and returns true if some node in the list has key as its item field, false otherwise.
        // Implementation to this code made the function to only take a string key as argument
        Integer element = 7;
        if(find(testLinkedList, element))
            StdOut.print("Found element " + element + "!");
        else
            StdOut.print("Could not find element " + element);

    }

}
