package Chapter1.Section3.Bag;

import java.util.Iterator;

public class Bag<Item> {

    private Node first;

    private class Node
    {
        Item item;
        Node next;
    }

    public void add(Item item)
    {   //  Add item to top of the stack
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Iterator<Item> iterator()
    {   return new ListIterator();  }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean  hasNext()   {   return current != null; }
        public void     remove()    {                           }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
