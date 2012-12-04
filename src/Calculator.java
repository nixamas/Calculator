import java.util.Stack;



public class Calculator {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// step 1: get a string containing the expression
				//   - this is going to be the first command-line argument

		// step 2: break the string into "tokens," using spaces as delimiters

		// step 3: loop through all of the tokens
				//   if you see a number: push it on the stack
				//   if you see an operator:
				//     - pop two numbers off the stack
				//     - perform the operation
				//     - push the result back on the stack

		// step 4: print whatever number is left on the stack
		
		if(args.length != 1){
			System.err.println(args.length);
			System.err.println("Usage: Calculator <expression>");
		}else{
			Stack<Integer> stack = new Stack<Integer>();
			String exp = args[0];
			String[] tokens = exp.split(" ");
			for(String token: tokens){
				try{
					//token is number
					int num = Integer.parseInt(token);
					System.out.println("PUSH -> " + num);
					stack.push(num);
				}catch(NumberFormatException nfe){
					if(token.equalsIgnoreCase("+") || token.equalsIgnoreCase("-") || token.equalsIgnoreCase("*") || token.equalsIgnoreCase("/")){
						//token is operator
						System.out.println("Operator: " + token);
						int num1 = stack.pop();
						System.out.println("POP -> " + num1);
						int num2 = stack.pop();
						System.out.println("POP -> " + num2);
						int opRslt = performOperation(token, num1, num2);
						System.out.println("PUSH RESULT " + num1 + token + num2 + " -> " + opRslt);
						stack.push(opRslt);
					}else{
						//token is not number or operator
						System.err.println("Error: Invalid operator");
					}
				}
			}
			if(stack.size() > 1){
				System.err.println("Error: elements left in stack");
				System.err.println(stack);
			}
			
		}
		
	}
	
	public static int performOperation(String op, int param1, int param2){
		int rslt = 0;
		switch(op){
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
			System.err.println("Error: Invalid operator");
			break;
		}
		return rslt;
	}
}
