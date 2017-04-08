package algorithms.stack;

public class InfixToPostfix {
	// a+b*c+d -> abc*d++
	// a+b -> ab+
	// a+b-c -> abc+-
	public static void main(String[] args) throws Exception {

		// final String infix = "a+b*c+d";
		// final String infix = "a*b+c"; // a*b+c->ab*c+
		// final String infix = "a+b*c";//a+b*c->abc*+
		// final String infix = "a-b+c";// a-b+c->ab-c+
		final String infix = "A*(B+C*D)+E";//ABCD*+*E+
		int explen = infix.length();
		char[] postfix = new char[explen];
		int postfixIndex = 0;
		Stack<Character> stack = new Stack<>(Character.class, explen);
		char[] infixArr = infix.toCharArray();
		char c = 'a';
		for (int i = 0; i < explen; i++) {
			c = infixArr[i];
			if (isOperand(c)) {
				postfix[postfixIndex++] = c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (stack.top() != 0 && c != '(') {
					char c1 = (Character) stack.pop();
					if (c1 != '(')
						postfix[postfixIndex++] = c1;
				}
				if (stack.top() != 0)
					stack.pop();
			} else {
				if (stack.top() == 0 || precedence(infixArr[i]) > precedence(stack.peek()))
					stack.push(c);
				else {
					while (stack.top() != 0 && precedence(c) <= precedence(stack.peek())) {
						postfix[postfixIndex++] = (Character) stack.pop();
					}
					stack.push(c);
				}
			}
		}
		while (stack.top() != 0) {
			postfix[postfixIndex++] = stack.pop();
		}

		// print the output
		System.out.println(new String(postfix));
	}

	public static int precedence(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}
	}

	public static boolean isOperand(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}

}
