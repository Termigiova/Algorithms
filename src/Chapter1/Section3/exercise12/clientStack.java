package Chapter1.Section3.exercise12;

import Chapter1.Section3.PushdownStack.Stack;
import edu.princeton.cs.introcs.StdOut;

public class clientStack {

    private Stack<String> stack = new Stack<>();
    private Stack<String> copiedStack;

    private static Stack copy(Stack<String> stack) {
        Stack<String> copyReverseStack = new Stack<String>();
        Stack<String> copyStack = new Stack<String>();

        for(String item:stack)
            copyReverseStack.push(item);

        for(String item:copyReverseStack)
            copyStack.push(copyReverseStack.pop());

        return copyStack;
    }


    public static void main(String args[]) {

        clientStack test = new clientStack();

        for (int i = 10; i > 0; i--)
            test.stack.push("" + i);

        test.copiedStack = copy(test.stack);

        for (String item:test.stack)
            StdOut.print(item);

        StdOut.println();

        for (String item:test.copiedStack)
            StdOut.print(item);
    }

}
