package codingProblems;

import algorithms.stack.Stack;

public class MultipleStacks {

	int cap;
	int size;
	int curr;
	int numberOfStacks = (int) Math.floor(cap / size);

	Stack[] stacks = new Stack[numberOfStacks];

	public void push(int val) throws Exception {
		if (stacks[curr].top == size - 1) {
			if (curr == numberOfStacks - 1)
				throw new Exception();
			curr++;
		}
		stacks[curr].push(val);
	}

	public int pop() throws Exception {
		if (stacks[curr].top == 0) {
			if (curr == 0)
				throw new Exception();
			curr--;
		}
		return (int) stacks[curr].pop();
	}

	/*
	 * size=100, cap = 1000; index = 532 asdf
	 */
	public int pop(int index) throws Exception {
		int stackNumber = index / size;
		if (stackNumber > numberOfStacks)
			throw new Exception();
		int val = removeFromAParticularStack(stackNumber, index);
		if (stacks[stackNumber].top < size - 1) {
			stacks[stackNumber].element[stacks[stackNumber].top - 1] = adjustTopStacks(stackNumber);
		}
		return val;
	}

	private int removeFromAParticularStack(int stackNumber, int index) {
		int val = (int) stacks[stackNumber].element[index];
		for (int i = index; i < stacks[stackNumber].top - 1; i++) {
			stacks[stackNumber].element[i] = stacks[stackNumber].element[i + 1];
		}
		return val;
	}

	private int adjustTopStacks(int stackNumber) {
		int val = (int) stacks[stackNumber].element[0];
		for (int i = 0; i < stacks[stackNumber].top - 1; i++) {
			stacks[stackNumber].element[i] = stacks[stackNumber].element[i + 1];
		}
		if (stackNumber != numberOfStacks) {
			// this are one or more stacks on top of this stack
			stacks[stackNumber].element[stacks[stackNumber].top - 1] = adjustTopStacks(stackNumber++);
		} else {
			stacks[stackNumber].top--;
		}
		return val;
	}

	public static void main(String[] args) {

	}

}
