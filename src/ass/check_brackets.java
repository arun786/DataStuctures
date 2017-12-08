package ass;

import java.util.Stack;

public class check_brackets {

    public static void main(String[] args) {

    }

    public static String checkBalance(String balance) {

        char[] input = balance.toCharArray();
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack1 = new Stack<>();
        int k = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(' || input[i] == '{' || input[i] == '[') {
                stack.push(input[i]);
                stack1.push(input[i]);
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
                    char peek = stack.peek();
                    if(peek == popedValue && i == input.length - 1){

                    }
                }


                k = i + 1;
            }
        }


        if (!stack.isEmpty()) {
            return "" + (k+1);
        }

        return "Success";
    }
}
