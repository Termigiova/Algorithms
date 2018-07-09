package Chapter1.Section3.exercise9;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Stack;

public class InfixExpressionLeftParentheses {

    private Stack<String> expression = new Stack<>();
    private Stack<String> signStack = new Stack<>();
    private Stack<String> sets = new Stack<>();
    private Set set = new Set();

    private class Item {

        String item;

        Item (String item) {
            this.item = item;
        }

        public String toString() {
            return item;
        }

        public boolean isOuterSign(){
            return item.equals("*") || item.equals("/") || item.equals("sqrt");
        }

        public boolean isInnerSign(){
            return item.equals("+") || item.equals("-");
        }

        public boolean isRightParentheses() {
            return item.equals(")");
        }

        public boolean isNumber() {
            try {
                Integer.parseInt(item);
            }
            catch (NumberFormatException e) {
                return false;
            }
            return true;
        }

    }

    public class Set {

        String set;

        Set () {
            set = "";
        }

        public String toString() {
            return set;
        }

        private void append (Item item) {
            set += item;
        }

        private void clearOut() {
            set = "";
        }

        public boolean isEmpty() {
            return set.equals("");
        }
    }

    public void storeInput() {
        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            expression.push(s);
        }
    }

    public void createExpression() {
        for (String item : expression) {
            Item element = new Item(item);
            pushElement(element);
            pushSet(element);
        }
    }

    private void pushElement(Item element) {
        if (element.isOuterSign())  // i.e. * / or sqrt
            addSignToStack(element);
        else if (element.isNumber() || element.isInnerSign()) // i.e. + or -
            set.append(element);
    }

    private void addSignToStack(Item item) {
        signStack.push(item.toString());
    }

    private void pushSet(Item element) {
        if (element.isRightParentheses() && !set.isEmpty()) {
            pushOneSet(set);
        } else if (element.isRightParentheses()) {
            pushTwoSets(set);
        }
    }

    private void pushOneSet(Set set) {
        sets.push("(" + set.toString() + ")");
        set.clearOut();
    }

    private void pushTwoSets(Set set) {
        String rightSet = sets.pop();
        String leftSet = sets.pop();
        String sign = signStack.pop();
        sets.push("(" + leftSet + sign + rightSet + ")");
    }

    public void printExpression() {
        for (String item : sets)
            StdOut.print(item + " ");
    }


    public static void main(String args[]) {

        InfixExpressionLeftParentheses test = new InfixExpressionLeftParentheses();
        test.storeInput();
        test.createExpression();
        test.printExpression();

    }

}
