import java.util.Stack;

public class Calculator {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length != 1) {
			System.err.println(args.length);
			System.err.println("Usage: Calculator <expression>");
		} else {
			Stack<Integer> stack = new Stack<Integer>();
			String exp = args[0];
			System.out.println("Entered Expression: " + exp);
			String[] tokens = exp.split(" ");
			for (String token : tokens) {
				try {
					// token is number
					int num = Integer.parseInt(token);
					stack.push(num);
				} catch (NumberFormatException nfe) {
					stack = handleOperation(token, stack);
				}
			}
			if (stack.size() > 1) {
				System.err.println("Error: elements left in stack");
				System.err.println(stack);
			} else {
				System.out.println("Expression calculates to: " + stack.pop());
			}
		}
	}

	public static Stack<Integer> handleOperation(String op, Stack<Integer> stack) {
		if(stack.size() >= 2){
			int rslt = 0, num1 = stack.pop(), num2 = stack.pop();
			switch (op) {
				case "+":
					rslt = num1 + num2;
					stack.push(rslt);
					break;
				case "-":
					rslt = num1 - num2;
					stack.push(rslt);
					break;
				case "*":
					rslt = num1 * num2;
					stack.push(rslt);
					break;
				case "/":
					rslt = num1 / num2;
					stack.push(rslt);
					break;
				default:
					System.err.println("Error: Invalid operator - " + op);
					stack.push(num2);
					stack.push(num1);
					break;
			}
		}else{
			System.err.println("Error: Not enough elements in stack");
		}
		return stack;
	}
}
