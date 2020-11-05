package Problem1;

import java.util.Stack;

public class ReverseStack {
    public static void reverseStack(Stack<Integer> stack) {
        // homework
        if (stack.empty()) {
            return;
        }
        Integer val = stack.pop();
        reverseStack(stack);
        reverseStack(stack, val);
    }

    // helper function
    private static void reverseStack(Stack<Integer> stack, Integer val) {
        if (stack.empty()) {
            stack.push(val);
        } else {
            Integer topVal = stack.pop();
            reverseStack(stack, val);
            stack.push(topVal);
        }
    }
}

// credit to https://www.youtube.com/watch?v=z0bS9ULg5to for explanation of reversing
// a stack recursively