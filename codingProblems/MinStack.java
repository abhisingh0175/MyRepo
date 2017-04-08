package codingProblems;

import algorithms.stack.Stack;



public class MinStack {
	Stack<Integer> minStack = new Stack<>();
	static final int LIMIT = 50;
	int top;
	int arr[] = new int[LIMIT];

	public void push(int val) throws Exception {
		if (top == LIMIT)
			throw new Exception("Stack is full!");
		arr[top++] = val;
		if (val < minStack.peek())
			minStack.push(val);
		java.util.Stack stac = new java.util.Stack();
		
	}

	public int pop() throws Exception {
		if (top == 0)
			throw new Exception("Stack is empty!");
		int val = arr[top--];
		if (val < minStack.peek())
			minStack.pop();
		return val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
