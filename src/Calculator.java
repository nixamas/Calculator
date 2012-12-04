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
					if (token.equalsIgnoreCase("+")	|| token.equalsIgnoreCase("-") || token.equalsIgnoreCase("*") || token.equalsIgnoreCase("/")) {
						// token is operator
						int opRslt = performOperation(token, stack.pop(), stack.pop());
						stack.push(opRslt);
					} else {
						// token is not number or operator
						System.err.println("Error: Invalid operator - " + token);
					}
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

	public static int performOperation(String op, int param1, int param2) {
		int rslt = 0;
		switch (op) {
		case "+":
			rslt = param1 + param2;
			break;
		case "-":
			rslt = param1 - param2;
			break;
		case "*":
			rslt = param1 * param2;
			break;
		case "/":
			rslt = param1 / param2;
			break;
		default:
			System.err.println("Error: Invalid operator - " + op);
			break;
		}
		return rslt;
	}
}
