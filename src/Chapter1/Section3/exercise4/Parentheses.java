package Chapter1.Section3.exercise4;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Parentheses<Item> {

    private Node first;
    private boolean roundBrackets;
    private boolean boxBrackets;
    private boolean curlyBrackets;

    public Parentheses() {
        roundBrackets = true;
        boxBrackets = true;
        curlyBrackets = true;
    }

    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
        if (isEmpty())
            initNullItem(item);
        else
            initItem(item);
    }

    public boolean isEmpty() { return first == null; }

    private void initNullItem(Item item) {
        first = new Node();
        first.item = item;
        first.next = null;
    }

    private void initItem(Item item) {
        //  Add item to top of the stack
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        oldFirst.next = first;
    }

    public void balance(Item item){
        falseBalance(item);
        trueBalance(item);
    }

    private void falseBalance(Item item){
        if (item.equals("("))
            roundBrackets = false;
        else if (item.equals("["))
            boxBrackets = false;
        else if (item.equals("{"))
            curlyBrackets = false;
    }

    private void trueBalance(Item item){
        if (item.equals(")"))
            roundBrackets = true;
        else if (roundBrackets && item.equals("]"))
            boxBrackets = true;
        else if (roundBrackets && boxBrackets && item.equals("}"))
            curlyBrackets = true;
    }

    public boolean isBalanced(){
        return roundBrackets && boxBrackets && curlyBrackets;
    }

    public static void main(String args[])
    {
        Parentheses<String> s = new Parentheses<>();

        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            s.add(item);
            s.balance(item);
        }

        StdOut.println(s.isBalanced());

    }

}
