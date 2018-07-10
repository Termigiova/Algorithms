package Chapter1.Section3.exercise10;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Stack;

public class InfixToPostfix {

    private Stack<String> expression = new Stack<>();
    private Stack<String> postfixString = new Stack<>();
    private Stack<String> stack = new Stack<>();

    private class Item {

        String item;

        Item (String item) {
            this.item = item;
        }

        public String toString() {
            return item;
        }

        private boolean isAlphabetical() {
            char character = item.charAt(0);
            int ascii = (int) character;
            if((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122))
                return true;
            else
                return false;
        }

        private boolean isRightParentheses() {
            return item.equals(")");
        }

    }

    private void storeInput() {
        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            expression.push(s);
        }
    }

    private void stackingExpression() {
        for (String item : expression) {
            Item element = new Item(item);
            if(element.isAlphabetical())
                postfixString.push(element.toString());
            else if (element.isRightParentheses())
                addStackToPostfixString();
            else
                stack.push(element.toString());
        }
        popStackUntilEmpty();
    }

    private void addStackToPostfixString() {
        String item = popRightParentheses();
        postfixString.push(item);
    }

    private void popStackUntilEmpty() {
        while (!stack.empty()) {
            String item = stack.pop();
            if (!item.equals("("))
                postfixString.push(item);
        }
    }

    private String popRightParentheses() {
        String item;
        do {
            item = stack.pop();
        } while (item.equals("(") && !stack.empty());
        return item;
    }

    private void printPostfixString() {
        for (String item : postfixString)
            StdOut.print(item);
    }

    public static void main (String args[]) {

        // test with: "( ( A  – ( B + C ) ) * D ) ↑ ( E + F )"

        InfixToPostfix test = new InfixToPostfix();
        test.storeInput();
        test.stackingExpression();
        test.printPostfixString();

    }

}
