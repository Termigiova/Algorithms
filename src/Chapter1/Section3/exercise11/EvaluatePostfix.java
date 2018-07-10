package Chapter1.Section3.exercise11;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Stack;

public class EvaluatePostfix {

    private Stack<String> expression = new Stack<>();
    private Stack<Integer> operands = new Stack<>();

    private class Item {

        String item;

        Item (String item) {
            this.item = item;
        }

        public String toString() {
            return item;
        }

        private boolean isOperand() {
            try {
                Integer.parseInt(item);
            }
            catch (NumberFormatException e) {
                return false;
            }
            return true;
        }

        private boolean isOperator() {
            return item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/");
        }

        private Integer toInteger() {
            return Integer.parseInt(item.toString());
        }

    }

    private void storeInput() {
        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            expression.push(s);
        }
    }

    private void solvePostfix(){
        for (String item : expression) {
            Item element = new Item(item);
            if (element.isOperand())
                operands.push(element.toInteger());
            else if (element.isOperator())
                solveLastTwoOperandsUsingOperator(element.toString());
        }
    }

    private void solveLastTwoOperandsUsingOperator(String operator) {
        Integer rightValue = operands.pop();
        Integer leftValue = operands.pop();
        if (operator.equals("+"))
            operands.push(leftValue + rightValue);
        else if (operator.equals("-"))
            operands.push(leftValue - rightValue);
        else if (operator.equals("*"))
            operands.push(leftValue * rightValue);
        else if (operator.equals("/"))
            operands.push(leftValue / rightValue);
    }

    private void printSolution() {
        StdOut.println("The result from ");
        for (String item : expression)
            StdOut.print(item);
        StdOut.println(" is: " + operands);
    }

    public static void main (String args[]) {

        // Test example: "ABC+–D*EF+"

        EvaluatePostfix test = new EvaluatePostfix();
        test.storeInput();
        test.solvePostfix();
        test.printSolution();

    }

}
