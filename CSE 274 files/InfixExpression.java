import java.util.Stack;

public class InfixExpression {
	private String infix;

	public InfixExpression(String exp) {
		this.infix = exp;
		clean();
	}

	public String toString(String exp) {
		return exp;
	}

	private boolean isBalanced() {
		ArrayStack<Character> stack = new ArrayStack<Character>();

		for(int i = 0;  i < infix.length(); i++) {
			if(infix.charAt(i) == '(' || infix.charAt(i) == '[' || infix.charAt(i) == '{' )
				stack.push(infix.charAt(i));

			else if(infix.charAt(i) == ')' || infix.charAt(i) == ']' || infix.charAt(i) == '}') {
				if(stack.isEmpty())
					return false;
				char top = stack.pop();
				if(infix.charAt(i) == ')' && top != '(') {
					return false;
				}
				if(infix.charAt(i) == ']' && top != '['){
					return false;
				}
				if(infix.charAt(i) == '}' && top != '{') {
					return false;
				}
			}
		}
		if(stack.isEmpty()) return true;
		return false;
	}



	public static boolean isAnOperator(char c){
		return (c == '*' || c == '/' || c == '+' || c == '-' || c == '%');
	}

	private boolean isValid() {
		if (isAnOperator(infix.charAt(0)) || isAnOperator(infix.charAt(infix.length()-1)))
			return false;

		int openCount = 0;
		int closedCount = 0;
		int opCount = 0;

		for (int i = 0; i < infix.length(); i++){
			if (infix.charAt(i) == '('){
				openCount++;
				opCount = 0;
				if (i == infix.length()-1) return false;
			}
			if (infix.charAt(i) == ')'){
				closedCount++;
				opCount = 0;
				if (i == 1) return false;

			}
			if (isAnOperator(infix.charAt(i))){
				opCount++;
				if (infix.charAt(i-1) == '(' || infix.charAt(i+1) == ')')
					return false; 
			}
			if (isAnOperator(infix.charAt(i)) || opCount > 0)
				return false; 
		}
		if (openCount != closedCount)
			return false;

		return true;
	}


	private void clean() {
		infix = infix.trim();
		String str =" ";
		for(int i=0;i<infix.length()+1;i++) {
			if(infix.charAt(i)=='0' && infix.charAt(i) <='9') {
				if(infix.charAt(i+1) =='0' && infix.charAt(i+1) <='9') {
					str+= infix.charAt(i)+" ";
				} else {
					str+= infix.charAt(i) + " ";
				}	
			}
			else if (infix.charAt(i) != ' ') {
				str += infix.charAt(i)+ " ";
			}
			else {
				str+= " ";
			}
		}
		str += infix.charAt(infix.length()-1)+ " ";
		infix = str + " ";
	}

	public static int Prec(char c){
		if(c == '^')
			return 3;
		if(c == '*' || c == '/' || c == '%')
			return 2;
		if(c == '-' || c == '+')
			return 1;
		return 0;
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
		ArrayStack<Character> s = new ArrayStack<>();
		int length= infix.length();
		int i = 0;
		int operand1, operand2;
		int result = 0;

		while(i<length) {
			char c = infix.charAt(i);
			switch(c) {
			case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
				s.push(c);
				break;

			case '+': case '-': case '*': case '/':
				operand2 = s.pop();
				operand1 = s.pop();
				result = operand2+operand1;
				char result1 = (char) result;
				s.push(result1);
				break;

			default: break;
			}
		}
		return s.peek();
	}
}
