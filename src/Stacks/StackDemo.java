package Stacks;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        String str = "()((({}))";
        System.out.println(isBalanced(str));
    }

    public static boolean isBalanced(String parenthesis) {
        char[] valuesinString = parenthesis.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : valuesinString) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty())
                    return false;
                Character fromStack = stack.pop();

                if ((fromStack == '(' && c != ')') || (fromStack == '{' && c != '}') || (fromStack == '[' && c != ']')) {
                    return false;
                }
            }
        }
        if (stack.empty())
            return true;
        else
            return false;
    }
}
