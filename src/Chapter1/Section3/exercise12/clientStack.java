package Chapter1.Section3.exercise12;

import Chapter1.Section3.PushdownStack.Stack;
import edu.princeton.cs.introcs.StdOut;

public class clientStack {

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
        Stack<String> testStack = new Stack<>();
        Stack<String> testCopyStack;

        for (int i = 10; i > 0; i--)
            testStack.push("" + i);

        testCopyStack = copy(testStack);

        for (String item:testStack)
            StdOut.print(item);

        StdOut.println();

        for (String item:testCopyStack)
            StdOut.print(item);
    }

}
