package com.bichel.interviewbit;

import java.util.ArrayList;
import java.util.Stack;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /.
Each operand may be an integer or another expression.

Let nn be the length of the list.

Time Complexity : O(n).

We do a linear search to put all numbers on the stack, and process all operators.
Processing an operator requires removing 2 numbers off the stack and replacing them
with a single number, which is an O(1)O(1) operation.
Therefore, the total cost is proportional to the length of the input array.
Unlike before, we're no longer doing expensive deletes from the middle of an Array or List.

Space Complexity : O(n).

In the worst case, the stack will have all the numbers on it at the same time.
This is never more than half the length of the input array.
 */

public class EvaluateExpression {
    public int evalRPN(ArrayList<String> tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (!"+-*/".contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }

            int number2 = stack.pop();
            int number1 = stack.pop();

            int result = 0;

            switch (token) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    result = number1 / number2;
                    break;
            }

            stack.push(result);

        }

        return stack.pop();
    }
}
