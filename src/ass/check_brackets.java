package ass;

import java.util.Scanner;
import java.util.Stack;

public class check_brackets {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String checkBrackets = scan.next();
        System.out.println(checkBalance(checkBrackets));

    }

    public static String checkBalance(String balance) {

        char[] input = balance.toCharArray();
        Stack<String> stack = new Stack<>();
        boolean flag = false;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(' || input[i] == '{' || input[i] == '[') {
                stack.push(i + "," + input[i]);
                flag = false;
            } else {
                flag = true;
                if (stack.isEmpty() && (input[i] == ')' || input[i] == '}' || input[i] == ']')) {
                    return "" + (i + 1);
                }

                if (input[i] == ')' || input[i] == '}' || input[i] == ']') {

                    String pop = stack.pop();
                    String split[] = pop.split(",");
                    char popedValue = split[1].toCharArray()[0];
                    if ((popedValue == '(' && input[i] != ')') || (popedValue == '[' && input[i] != ']')
                            || (popedValue == '{' && input[i] != '}')) {
                        return "" + (i + 1);
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            /**
             * This section is for stack having all open parenthesis, there were no closing parenthesis in the string
             */
            if (flag == false) {
                String p = stack.firstElement();
                String split[] = p.split(",");
                String i = split[0];
                return "" + (Integer.parseInt(i) + 1);
            }

            /**
             * This section is for String where both open and close parenthesis was present
             */
            String pop = stack.pop();
            String split[] = pop.split(",");
            String index = split[0];
            return "" + (Integer.parseInt(index) + 1);
        }
        return "Success";
    }
}
