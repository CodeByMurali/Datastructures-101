package DataStructures.Stacks;

import java.util.Stack;

public class StacksProblems {

    public void reverseString(String inputString) {
        if (inputString == null)
            throw new IllegalArgumentException();

        StringBuilder reverseString = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char i : inputString.toCharArray()) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            // Strings are immutable
            // When you do this operation new strings are created, hence it occupies alot of memory
            // Hence we may use StringBuffer / StringBuilder - where there is a lot of string manuplation operations
            reverseString.append(stack.pop());
        }
        System.out.println(reverseString);
    }

    public boolean balancedExpression(String inputString) {
        if(inputString.isEmpty())
            throw  new IllegalArgumentException();
        Stack<Character> stack = new Stack<>();
        for (char i : inputString.toCharArray()) {
            if (i == '(' || i == '<') {
                stack.push(i);
            } else if (i == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (i == '>') {
                if (stack.isEmpty() || stack.pop() != '<') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}



