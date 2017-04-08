package algorithms.stack;

import java.lang.reflect.Array;

public class Stack<E> {

	public int top;
	private int limit;
	public E[] element;
	final static int DEFAULT_LIMIT = 50;


	public Stack() {
		limit=DEFAULT_LIMIT;
	}

	@SuppressWarnings("unchecked")
	Stack(Class<E> c, final int limit) {
		this.limit = limit;
		element = (E[]) Array.newInstance(c, limit);
	}

	public boolean push(E data) throws Exception {
		if (top == limit)
			throw new Exception("Stack is full!");
		element[top++] = data;
		return true;
	}

	public E pop() throws Exception {
		if (top > 0) {
			top--;
			E e = element[top];
			element[top] = null;
			return e;
		} else
			throw new Exception("Stack is empty!");
	}

	public int top() {
		return top;
	}

	public E peek() {
		if (top == 0)
			return null;
		else
			return element[top - 1];
	}

	@Override
	public String toString() {
		if (top == 0)
			return "";
		StringBuffer string = new StringBuffer();
		for (int i = top - 1; i >= 0; i--) {

			string = element[i] != null ? string.append("<-" + element[i]) : new StringBuffer("--");
		}
		return string.toString();
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>(Integer.class, 50);

		System.out.println("Initially top is : " + stack.top());

		try {
			stack.push(12);
			stack.push(123);
			stack.push(2);
			stack.push(-5);
			stack.push(43);
			stack.push(2);
			stack.push(1);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("Currently top is : " + stack.top());

		System.out.println(stack);

		try {
			stack.pop();
			stack.pop();
			stack.pop();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(stack);
		try {
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(stack);

	}
}