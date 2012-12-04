import java.util.Stack;

public class Calculator {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length != 1) {
			System.err.println(args.length);
			System.err.println("Usage: Calculator <expression> invalid");
		} else {
			System.out.println("Entered Expression: " + args[0]);
			calculate(args[0]);
		}
	}
	
	
	private static void calculate(String exp){
		Stack<Integer> stack = new Stack<Integer>();
		
		String[] tokens = exp.split(" ");
		for (String token : tokens) {
			try{
				if(!handleNumber(token, stack) && !handleOperator(token, stack)){
						System.out.println("ILLEGAL ARGUMENT");
						throw new IllegalArgumentException("Error: Invalid Argument in Expression");
				}
			}catch(IllegalArgumentException iae){
				System.err.println(iae);
			}
		}
		handleStack(stack);
	}
	
	private static void handleStack(Stack<Integer> stack){
		if (stack.size() > 1) {
			System.err.println("Error: elements left in stack");
			System.err.println(stack);
		} else {
			System.out.println("Expression calculates to: " + stack.pop());
		}
	}
	
	private static boolean handleNumber(String token, Stack<Integer> stack){
		try{
			stack.push( Integer.parseInt(token) );
			return true;
		}catch(NumberFormatException nfe){
			return false;
		}
		
	}

	private static boolean handleOperator(String op, Stack<Integer> stack) {
			boolean state = true;
			int rslt = 0, num1, num2;
			switch (op) {
				case "+":
					num1 = stack.pop(); num2 = stack.pop();
					rslt = num1 + num2;
					stack.push(rslt);
					break;
				case "-":
					num1 = stack.pop(); num2 = stack.pop();
					rslt = num1 - num2;
					stack.push(rslt);
					break;
				case "*":
					num1 = stack.pop(); num2 = stack.pop();
					rslt = num1 * num2;
					stack.push(rslt);
					break;
				case "/":
					num1 = stack.pop(); num2 = stack.pop();
					rslt = num1 / num2;
					stack.push(rslt);
					break;
				default:
					System.err.println("Error: Invalid operator - " + op);
					state = false;
					break;
			}
			return state;
	}
}
