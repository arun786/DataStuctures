package ass;

import java.util.Stack;

public class check_brackets {

    public static void main(String[] args) {

    }

    public static String checkBalance(String balance) {

        char[] input = balance.toCharArray();
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack1 = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            stack1.push(input[i]);
            if (input[i] == '(' || input[i] == '{' || input[i] == '[') {
                stack.push(input[i]);
            } else {

                if (stack.isEmpty() && (input[i] == ')' || input[i] == '}' || input[i] == ']')) {
                    return "" + (i + 1);
                }

                if (input[i] == ')' || input[i] == '}' || input[i] == ']') {

                    char popedValue = stack.pop();
                    if ((popedValue == '(' && input[i] != ')') || (popedValue == '[' && input[i] != ']')
                            || (popedValue == '{' && input[i] != '}')) {
                        return "" + (i + 1);
                    }
                }
            }
        }

        int index = stack1.size();
        if (!stack.isEmpty()) {
            char firstValueNotMatched = stack.pop();
            for (int i = stack1.size() - 1; i >= 0; i--) {
                if (firstValueNotMatched == input[i]) {
                    if (i > 0) {
                        if (input[i] == input[i - 1]) {
                            index--;
                        }
                    }
                }
            }

            return "" + (index);
        }


        /*if (!stack.isEmpty()) {*/

        /*}*/

        return "Success";
    }
}
