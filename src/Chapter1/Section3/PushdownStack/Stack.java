package Chapter1.Section3.PushdownStack;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;

//  Pushdown stack (linked-list implementation)
public class Stack<Item> {

    private Node    first;  //  Top of stack (Most recently added node)
    private int     N;      //  Number of items

    private class Node
    {   // Nested class to define nodes
        Item item;
        Node next;
    }

    public boolean  isEmpty()   {   return first == null;   }   //  Or N == 0
    public int      size()      {   return N;               }

    public void push(Item item)
    {   //  Add item to top of stack
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop()
    {   // Remove item from top of stack
        Item item = first.item;
        first = first.next;
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


    public static void main(String args[])
    {   // Create a stack and push/pop strings as directed on StdIn.
        Stack<String> s = new Stack<String>();

        while(!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if(!item.equals("-"))
                s.push(item);
            else if(!item.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }

}
