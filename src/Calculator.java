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
	
	
	public static int calculate(String exp){
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
		return handleStack(stack);
	}
	
	public static int handleStack(Stack<Integer> stack){
		int result = 0;
		if (stack.size() > 1) {
			System.err.println("Error: elements left in stack");
			System.err.println(stack);
		} else {
			result = stack.pop();
			System.out.println("Expression calculates to: " + result);
		}
		return result;
	}
	
	public static boolean handleNumber(String token, Stack<Integer> stack){
		try{
			stack.push( Integer.parseInt(token) );
			return true;
		}catch(NumberFormatException nfe){
			return false;
		}
		
	}

	public static boolean handleOperator(String operator, Stack<Integer> stack) {
			boolean state = true;
			int rslt = 0, num1, num2;
			Operator op = null;
			switch (operator) {
				case "+":
					op = new Add();
					break;
				case "-":
					op = new Subtract();
					break;
				case "*":
					op = new Multiply();
					break;
				case "/":
					op = new Divide();
					break;
				default:
					System.err.println("Error: Invalid operator - " + operator);
					state = false;
					break;
			}
			if(op != null){
				stack.push(op.operate(stack.pop(), stack.pop()));
			}
			return state;
	}
}
