import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

public class Project4Tester {

	private static class ExpressionPair {
		private String infix;
		private String postfix;
		private int value;
		
		private ExpressionPair(String in, String post, int val) {
			infix = in;
			postfix = post;
			value = val;
		}
	}
	
	static ExpressionPair[] expressions = {
			new ExpressionPair("3 + 5", "3 5 + ", 8),
			new ExpressionPair("5 - 3", "5 3 - ", 2),
			new ExpressionPair("17 * 2", "17 2 * ", 34),
			new ExpressionPair("17 / 2", "17 2 / ", 8),
			new ExpressionPair("17 % 2", "17 2 % ", 1),
			new ExpressionPair("3 * (4 + 5)", "3 4 5 + * ", 27),
			new ExpressionPair("4 + 7 * 6 - 10", "4 7 6 * + 10 - ", 36),
			new ExpressionPair("(5 + 4) / (4 - 1)", "5 4 + 4 1 - / ", 3),
			new ExpressionPair("(5 + 4) / (4 - 1)", "5 4 + 4 1 - / ", 3),
			new ExpressionPair("10 ^ 2 ^ 3", "10 2 3 ^ ^ ", 100000000),
			new ExpressionPair("10 - 2 - 3", "10 2 - 3 - ", 5),
			new ExpressionPair("3 * (2 + 6)^2", "3 2 6 + 2 ^ * ", 192),
			new ExpressionPair("3 ^ (2 + 1)*2", "3 2 1 + ^ 2 * ", 54),
			new ExpressionPair("3 ^ ((2 + (5 - 4))*2)", "3 2 5 4 - + 2 * ^ ", 729),
			new ExpressionPair("1 / 2 * 3 ^ 2 - 9 + 14 % 10 * (2 + 2) - ((3/3) + (6 - 5))", "1 2 / 3 2 ^ * 9 - 14 10 % 2 2 + * + 3 3 / 6 5 - + - ", 5)
	};
	
	static String[] badValid = {			
			"4( 3 )",
			"()",
			"4 3",
			"+ 4", 
			"+ 4 + 7",
			"4 7 *",
			"4 - 7 *",
			"3 (4 + 5)",
			"3 + (4 * (9 - ) 8)",
			"(()) (( ) ) * ( 3 + 7",
			")3 + 4 * (8 - 9)",
			"3 + (4",	
			"3 + 4)",
			"1 6",
			" ^ 6",
			"3 + 4 * () 7",
			"( 3 + 4  * 7",
			"3 + ( 4 * 7 ) 10",
			"3 + 4 * ( 8 - - 9 ) ",
			"2  3 ^ 4",
			")2(",
			"3 * ( 4 + ( 5 * ( 6 + ( 7 - 8 % 2 ) ) ) ) + 11)",
			"3 + +",
			"(",
			")",
			"()()",
			"())",
			"()",
			")(",
			"(((())))",
			"((()()))",
			"(()())",
			"3 + (4 * (9 - ) 8)",
			"(()) (( ) ) * ( 3 + 7",
			")3 + 4 * (8 - 9)",
			"3 + (4",	
			"3 + 4)"
	};
		
	@Test
	public void testCleanAndToString() {
		for (ExpressionPair e : expressions) {
			InfixExpression ie = new InfixExpression(e.infix);
			String studentString = ie.toString();
			String expectedString = cleanExpression(e.infix);
			assertEquals("clean/toString fail: " + e.infix, expectedString, studentString);
		}
	}
	
	@Test 
	public void testBadValid() {
		
		for (String s : badValid) {
			boolean exThrown = false;
			try {
				InfixExpression ie = new InfixExpression(s);
			} 
			catch (IllegalArgumentException e) {
				exThrown = true;
			}
			
			assertTrue("isValid fail: " + s, exThrown );
		}
	}
	
	@Test
	public void testGetPostfixExpression() {
		for (ExpressionPair e : expressions) {
			InfixExpression ie = new InfixExpression(e.infix);
			String studentResult = clean(ie.getPostfixExpression());
			String expectedResult = clean(e.postfix);
			assertEquals("getPostfixExpression fail: " + e.infix, expectedResult, studentResult);
		}
	}
	
	@Test
	public void testEvaluate() {
		for (ExpressionPair e : expressions) {
			InfixExpression ie = new InfixExpression(e.infix);
			int studentResult = ie.evaluate();
			int expectedResult = e.value;
			assertEquals("evaluate fail: " + e.postfix, expectedResult, studentResult);
		}
	}
	
	// Returns a string where multiple spaces are replaced by single spaces
	public static String clean(String s) {
		s = s.trim();
		while (s.contains("  ")) {
			s = s.replace("  ", " ");
		}
		return s;
	}
	
	public static String cleanExpression(String expression) {
		char[] ops = "+-*/%()^".toCharArray();

		for (char c : ops) {
			expression = expression.replace("" + c, " " + c + " ");
		}

		while (expression.contains("  "))
			expression = expression.replace("  ", " ");

		expression = expression.trim();
		return expression;
	}
	
	
	@Test
	public void testConstructor() {
		StackInterface<Integer> stack = new ArrayStack<>();
		assertTrue(stack.isEmpty());
	}
	
	@Test (expected = EmptyStackException.class)
	public void peekEmpty() {
		StackInterface<Integer> stack = new ArrayStack<>();
		stack.peek();
	}
	
	@Test (expected = EmptyStackException.class)
	public void popEmpty() {
		StackInterface<Integer> stack = new ArrayStack<>();
		stack.pop();
	}
	
	@Test
	public void testClearStack() {
		StackInterface<Integer> stack = new ArrayStack<>();
		stack.push(5);
		stack.push(10);
		assertFalse(stack.isEmpty());
		stack.clear();
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testPushPopPeek() {
		StackInterface<Integer> stack = new ArrayStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		int result = stack.pop();
		assertEquals(4, result);
		
		result = stack.peek();
		assertEquals(3, result);
		result = stack.peek();
		assertEquals(3, result);
		result = stack.pop();
		assertEquals(3, result);
		
		stack.push(99);
		result = stack.peek();
		assertEquals(99, result);
		
		result = stack.pop();
		assertEquals(99, result);
		result = stack.pop();
		assertEquals(2, result);
		result = stack.pop();
		assertEquals(1, result);
		
		assertTrue(stack.isEmpty());
	}
	
	
	
	

}
