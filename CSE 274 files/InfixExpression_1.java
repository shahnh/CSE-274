
import java.util.Stack;

public class InfixExpression {
	private String  infix;

	public InfixExpression(String exp) {
		this.infix = exp;
		clean();
	}

	public String toString() {
		return infix;
	}

	private boolean isBalnced() {

		ArrayStack<Character> s = new ArrayStack<>(); 
		int length= infix.length();
		boolean balanced = true;
		int i=0;
		char nextDelimeter=' ';

		while((balanced == true) && (i < length)) {
			char c = infix.charAt(i);
			switch (c) {
			case '(': case '[': case '{': 
				s.push(c);
				break;

			case ')': case ']': case '}': 
				if(s.isEmpty()) 
					balanced=false;
				else {
					char openDelimeter = s.pop();
					if( openDelimeter=='(' || openDelimeter=='[' || openDelimeter=='{') {
						balanced = false;
					}
				}
				break;

			default: break;
			}	
			i++;
		}

		if(!s.isEmpty()) 
			balanced = false;

		return balanced;
	}


	public static boolean isAnOperator(char c){
		return (c == '*' || c == '/' || c == '+' || c == '-' || c == '%');
	}

	private boolean isValid(String s) {
		if (isAnOperator(s.charAt(0)) || isAnOperator(s.charAt(s.length()-1)))
			return false;

		int openCount = 0;
		int closedCount = 0;
		int opCount = 0;

		for (int i = 0; i < s.length(); i++){
			if (s.charAt(i) == '('){
				openCount++;
				opCount = 0;
				if (i == s.length()-1) return false;
			}
			if (s.charAt(i) == ')'){
				closedCount++;
				opCount = 0;
				if (i == 1) return false;

			}
			if (isAnOperator(s.charAt(i))){
				opCount++;
				if (s.charAt(i-1) == '(' || s.charAt(i+1) == ')')
					return false; 
			}
			if (isAnOperator(s.charAt(i)) || opCount > 0)
				return false; 
		}
		if (openCount != closedCount)
			return false;

		return true;
	}


	public void clean() {
		infix = infix.trim();
		String str =" ";
		for(int i=0;i<infix.length();i++) {
			if(!(infix.charAt(i)==' ')) {
				str+= infix.charAt(i)+" ";
			}
		}
		infix = str;
		System.out.println(infix);
	}

	public int Prec(char c){
		switch(c) {
		case '+': case '-': 
			return 0;
		case '*': case '/': case '%':
			return 1;
		case '^':
			return 2;
		default: throw new IllegalArgumentException();
		}
	}

	public String getPostfixExpression() {

		ArrayStack<Character> operatorStack = new ArrayStack<>();
		String postfix= new String();
		int length= infix.length();
		int i=0;
		char topOperator;

		while(i<length)
		{ 
			char c = infix.charAt(i);

			switch (c) {
			case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
				postfix += c;
				break;

			case '^': 
				operatorStack.push(c);
				break;

			case '+': case '-': case '*': case '/':
				while (!operatorStack.isEmpty() && Prec(c) <= Prec(operatorStack.peek())) {
					postfix +=operatorStack.pop();
				}
				operatorStack.push(c);
				break;

			case '(':
				operatorStack.push(c);
				break;

			case ')':
				topOperator = operatorStack.pop();
				while(topOperator!='(') 
					postfix += topOperator;
				postfix +=operatorStack.pop();
				break;

			default: break; 
			}
			i++;
		}
		while (!operatorStack.isEmpty()) {
			topOperator = operatorStack.pop();
			postfix += topOperator; 
		}  

		return postfix; 
	} 


	public int evaluate() {
		ArrayStack<Character> valueStack = new ArrayStack<>();
		int length= infix.length();
		int i=0;
		int operand1, operand2;
		int result;

		while(i<length) {
			char c = infix.charAt(i);
			switch(c) {
			case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
				valueStack.push(c);
				break;

			case '+': case '-': case '*': case '/':
				operand2 = valueStack.pop();
				operand1 = valueStack.pop();
				result = operand2+c+operand1;
				char result1 = (char) result;
				valueStack.push(result1);
				break;

			default: break;
			}
		}
		return valueStack.peek();
	}

	//		public int evaluate() {
	//			ArrayStack<Character> operatorStack = new ArrayStack<>();
	//			ArrayStack<Character> valueStack = new ArrayStack<>();
	//			int length= infix.length();
	//			int i=0;
	//			int topOperator;
	//			int operand1, operand2, result;
	//			char result1;
	//			
	//			while(i<length) {
	//				char c = infix.charAt(i);
	//				switch(c) {
	//				case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
	//					 valueStack.push(c);
	//					 break;
	//					  
	//				case '^':	
	//					operatorStack.push(c);
	//					 break;
	//				
	//				case '+': case '-': case '*': case '/':
	//					while (!operatorStack.isEmpty() && Prec(c) <= Prec(operatorStack.peek())) {
	//						topOperator = operatorStack.pop();
	//						operand2 = valueStack.pop();
	//						operand1 = valueStack.pop();
	//						result = operand2 + topOperator + operand1;
	//						result1 = (char) result;
	//						 valueStack.push(result1);
	//					}
	//					operatorStack.push(c);
	//					break;
	//					
	//				case '(':
	//					operatorStack.push(c);
	//					break;
	//					
	//				case ')':
	//					topOperator = operatorStack.pop();
	//					while(topOperator != '(') {
	//						operand2 = valueStack.pop();
	//						operand1 = valueStack.pop();
	//						result = operand2 + topOperator + operand1;
	//						result1 = (char) result;
	//						valueStack.push(result1);
	//						topOperator = operatorStack.pop();
	//					}
	//					break;
	//					
	//					default: break;
	//				}
	//			}
	//			
	//			while(!operatorStack.isEmpty()) {
	//				topOperator = operatorStack.pop();
	//				operand2 = valueStack.pop();
	//				operand1 = valueStack.pop();
	//				result = operand2 + topOperator + operand1;
	//				result1 = (char) result;
	//				valueStack.push(result1);
	//			}
	//			return valueStack.peek();
	//		}
	//		
}

