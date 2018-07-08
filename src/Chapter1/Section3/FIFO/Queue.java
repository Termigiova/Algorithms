package Chapter1.Section3.FIFO;

import Chapter1.Section3.PushdownStack.Stack;

import java.util.Iterator;

//  FIFO Queue
public class Queue<Item> {

    private Node    first;  //  Link to least recently added node
    private Node    last;   //  Link to most recently added node
    private int     N = 0;  //  Number of items in the queue

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean  isEmpty()   {   return first == null;   }   //  Or: N == 0
    public int      size()      {   return N;               }

    public void enqueue(Item item)
    {   //  Add item to the end of the list
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if      (isEmpty()) first = last;
        else                oldLast.next = last;
        N++;
    }

    public Item dequeue()
    {   //  Remove item from the beginning of the list
        Item item = first.item;
        first = first.next;
        if (isEmpty())  last = null;
        N--;
        return item;
    }

    public Iterator<Item> iterator()
    {   return new ListIterator();  }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean  hasNext()   {   return current != null;     }
        public void     remove()    {                               }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
