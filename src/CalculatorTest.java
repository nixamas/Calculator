import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;


public class CalculatorTest {

	@Test
	public void onePlusOneMustEqualTwo() {
		assertEquals(2, Calculator.calculate("1 1 +"));
	}
	
	@Test
	public void handleNumberMustHandleNumbers(){
		Stack<Integer>stack = new Stack<Integer>();
		assertTrue(Calculator.handleNumber("42", stack));
		assertEquals(42, (int)stack.peek());
	}
	
	@Test 
	public void handleOperatorMustHandleOperators(){
		
	}

}
