package Chapter1.Section3.DoublyLinkedList;

import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;
import java.util.Objects;

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

    public Iterator<Item> iterator()
    {   return new ListIterator();  }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean  hasNext()   {   return current != null;     }
        public void     remove()    {
            Node previous = current.previous;
            Node next = current.next;
            previous.next = next;
            next.previous = previous;
            N--;
        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private void deleteIndexElement(Integer element) {
        Iterator<Item> itr = iterator();
        for (int i = 0; i < element; i++)
            itr.next();
        itr.remove();
    }

    private boolean find(Object element) {
        Iterator<Item> itr = iterator();
        Object value = itr.next();
        while(itr.hasNext()) {
            if (value.equals(element))
                return true;
            value = itr.next();
        }
        return false;
    }

    private void removeAfter(Integer element) {
        Node listNode = getNthElementInList(element);
        try {
            Node deletedNode = listNode.next;
            Node last = deletedNode.next;
            if (last != null) {
                listNode.next = last;
                last.previous = listNode;
            } else listNode.next = null;
        } catch (NullPointerException e) {
            StdOut.println("Element could not be deleted");
        }
    }

    private void insertAfter(Node first, Node second) {
        if (first != null && second != null) {
            Node last = first.next;
            if(last != null) {
                insertSecondAfterFirst(first, second);
                insertLastAfterSecond(second, last);
            } else {
                insertSecondAfterFirst(first, second);
            }
        } else
            StdOut.println("Could not insert null value");
    }

    private void insertSecondAfterFirst(Node first, Node second) {
        first.next = second;
        second.previous = first;
    }

    private void insertLastAfterSecond(Node second, Node last) {
        second.next = last;
        last.previous = second;
    }

    private void remove(Object key) {
        Node current = last;
        Object value = current.item;
        while(current != null) {
            if (value.equals(key)) {
                Node previous = current.previous;
                Node next = current.next;
                if (previous != null && next != null) {
                    deleteNodeBetweenPreviousAndNext(previous, next);
                } else if(previous == null && next == null) {
                    first = last = null;
                } else if (next == null) {
                    previous.next = null;
                    last = previous;
                } else if (previous == null) {
                    next.previous = null;
                    first = next;
                }
                N--;
            }
            current = current.previous;
            if (current != null)
                value = current.item;
        }
    }

    private void deleteNodeBetweenPreviousAndNext(Node previous, Node next) {
        previous.next = next;
        next.previous = previous;
    }

    private Integer max(Node first) {
        Integer maxValue = (Integer)first.item;
        Node current = first;
        while(current != null) {
            if ((Integer)current.item > maxValue)
                maxValue = (Integer)current.item;
            current = current.next;
        }
        return maxValue;
    }

    private Integer recursiveMax(Node current) {
        Integer currentValue = (Integer)current.item;
        Integer nextValue;
        if (current.next != null) {
            nextValue = recursiveMax(current.next);
            if (currentValue > nextValue)
                return currentValue;
            else
                return nextValue;
        } else {
            return Objects.requireNonNullElse(currentValue, 0);
        }
    }

    /////////// Testing functions /////////////////

    private static void testFillList(DoublyLinkedList list) {
        for (int i = 1; i < 10; i++)
            list.enqueue(i);
    }

    private static void testPrintList(DoublyLinkedList list) {
        if(!list.isEmpty())
            for (Object item:list)
                StdOut.print(item);
        else
            StdOut.print("Empty list!");
        StdOut.println();
    }

    private Node testCreateIntNode() {
        return new Node();
    }

    public static void main(String args[]) {

        DoublyLinkedList<Integer> testLinkedList = new DoublyLinkedList<>();

        // Exercise 1.3.19
        // Code fragment that removes the last node in a linked list whose first node is first.
        testFillList(testLinkedList);
        testPrintList(testLinkedList);

//        testLinkedList.removeLastNode();
//        testPrintList(testLinkedList);

        // Exercise 1.3.20
        // Method delete() that takes an int argument k and deletes the kth element in a linked list, if it exists.
//        testLinkedList.deleteIndexElement(5);
//        testPrintList(testLinkedList);

        // Exercise 1.3.21
        // Method find() that takes a linked list and a string key as arguments and returns true if some node in the list has key as its item field, false otherwise.
        // Implementation to this code made the function to only take a string key as argument
//        Integer element = 10;
//        if(testLinkedList.find(element))
//            StdOut.print("Found element " + element + "!");
//        else
//            StdOut.print("Could not find element " + element);
//        StdOut.println();

        // Exercise 1.3.24
        // Method removeAfter() that takes a linked-list Node as argument and removes the node following the given one
        // (and does nothing if the argument or the next field in the argument node is null).
//        testLinkedList.removeAfter(9);
//        testPrintList(testLinkedList);

        // Exercise 1.3.25
        // Method insertAfter() that takes two linked-list Node arguments and inserts the second after the first on its list
        // (and does nothing if either argument is null).
//        testLinkedList.insertAfter(testLinkedList.getNthElementInList(1), testLinkedList.testCreateIntNode());
//        testPrintList(testLinkedList);

        // Exercise 1.3.26
        // Method remove() that takes a linked list and a string key as arguments
        // and removes all of the nodes in the list that have key as its item field.
//        for (int i = 1; i < 10; i++) {
//            testLinkedList.remove(i);
//        }
//        testPrintList(testLinkedList);

        // Exercise 1.3.27
        // Method max() that takes a reference to the first node in a linked list as argument
        // and returns the value of the maximum key in the list. Assume that all keys are positive integers,
        // and return 0 if the list is empty.
//        Integer maxValue = testLinkedList.max(testLinkedList.first);
//        StdOut.println("The maximum value is: " + maxValue);

        // Exercise 1.3.28 Recursive solution to max()
//        maxValue = testLinkedList.recursiveMax(testLinkedList.first);
//        StdOut.println("The maximum value is: " + maxValue);

    }

}
