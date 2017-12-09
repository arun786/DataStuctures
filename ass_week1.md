# Assignment 1

Requirement : A string will have brackets (){}[] along with big and small latin words, 
numbers along with punctuation marks. Problem is to find unmatched bracket along with 
the position.

example 1 : [] -> o/p success
example 2 : (){} -> o/p success
example 3 : [{ac}] -> o/p success
example 4 : ( -> o/p 1
example 5 : {[} -> o/p will be 3


Steps of Algorithm

1. Iterate the string after converting it to an array.
2. if any occurance of opening braces, put them into a stack.
3. else check if closing braces are present, pop out value from stack
4. if the opening and closing braces match, continue else return the index after adding 1 to it
5. if the string is balanced return Success
6. else if after complete iteration, still the stack is not empty
7. we need to see if the something was popped out of the stack or not
8. If nothing was poped out, return the index + 1 of the first element of the stack
9. else return the index + 1 of the last one.

Solution


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

