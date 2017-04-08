package algorithms.tree;

import java.util.LinkedList;

public class TreeMaxSumOnALevel {
	Node1 root;

	TreeMaxSumOnALevel(Node1 node) {
		root = node;
	}

	public int maxSum(Node1 node) {
		if (node == null) {
			return 0;
		}
		LinkedList<Node1> queue = new LinkedList<>();
		queue.push(node);
		int sum = 0;
		int maxSum = 0;
		Node1 temp = null;
		int size = 0;
		while (!queue.isEmpty()) {
			size = queue.size();
			while (size-- > 0) {
				temp = queue.pop();
				sum = sum + temp.data;
				if (temp.left != null) {
					queue.push(temp.left);
				}
				if (temp.right != null) {
					queue.push(temp.right);
				}
			}
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		TreeMaxSumOnALevel tree = new TreeMaxSumOnALevel(new Node1(12));
		tree.root.left = new Node1(24);
		tree.root.right = new Node1(3);
		Node1 temp = tree.root.left;
		temp.left = new Node1(24);
		temp.right = new Node1(24);
		temp = tree.root.right;
		temp.left = new Node1(9);
		temp.right = new Node1(78);
		int i = tree.maxSum(tree.root);
		System.out.println(i);

	}
}

class Node1 {
	Node1(int value) {
		data = value;
	}

	Node1 left;
	Node1 right;
	int data;
}
