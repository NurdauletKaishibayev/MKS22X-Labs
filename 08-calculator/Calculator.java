import java.util.*;
public class Calculator{
      /*Evaluate a postfix expression stored in s.
      *Assume valid postfix notation, of ints doubles and operators separated by spaces.
      *Valid operators are + - / * and % (remainder not modulo)
      *All results are doubles even if the operands are both int.
      *@throws IllegalArgumentException when there are too many or too few operands.
      *        Use the string parameter of your exception to indicate what happened.
      *        Either "too many operands" or "too few operands for operation _" replace _ with +,- etc.
      */
      public static double eval(String s){
        Deque<Double> stack = new ArrayDeque<Double>();
        Scanner input = new Scanner(s);
        while (input.hasNext()) {

          // Adds NUMBERS on top of stack
          if (input.hasNextInt() || input.hasNextDouble()) {
            String token = input.next();
            stack.push(Double.parseDouble(token)); // push will put it on TOP of the stack (pop does reverse)


          } else {

            // Does operation stuff
            String op = input.next();
            if (stack.size() < 2) {
              // Throw exception when you are trying to do an operation on 1 operand
              throw new IllegalArgumentException("not enough operands!");
            }

            // Add
            if (op.equals("+")) {
              double b = stack.pop();
              double a = stack.pop();
              stack.push(a+b);
            }

            // Subtract
            else if (op.equals("-")) {
              double b = stack.pop();
              double a = stack.pop();
              stack.push(a-b);
            }

            // Multiply
            else if (op.equals("*")) {
              double b = stack.pop();
              double a = stack.pop();
              stack.push(a*b);
            }

            // Divide
            else if (op.equals("/")) {
              double b = stack.pop();
              double a = stack.pop();
              stack.push(a/b);
            }

          }
        }

        // Throw exception when there are too many operands (stack size >=2)
        if (stack.size() >= 2) {
          throw new IllegalArgumentException("too many operands!");
        }

        input.close();
        return stack.pop();
      }

      public static void main(String[] args) {
        System.out.println(eval("1 3 +")); // Should be 4.0
        System.out.println(eval("10 2.0 +")); // Should be 12.0
        System.out.println(eval("11 3 - 4 + 2.5 *")); // Should be 30.0
        System.out.println(eval("8 2 + 99 9 - * 2 + 9 -")); // Should be 893.0
        System.out.println(eval("1 2 3 4 5 + * - -")); // Should be 26.0
        System.out.println(eval("5 9 + 2 * 6 5 * +")); // Should be 58.0
        System.out.println(eval("5 9 -")); // Should be -4.0
        // System.out.println(eval("5 9 9 9 - +")); // Too Many
        // System.out.println(eval("5 - 3 2 + 2")); // Not Enough

      }
    }
