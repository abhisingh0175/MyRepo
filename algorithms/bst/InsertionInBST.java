package algorithms.bst;

import java.util.Random;

public class InsertionInBST {

	BST<Integer> bst = new BST<>();

	static int base = Integer.MIN_VALUE;

	public boolean insert(Node<Integer> node, int value) {
		// Throws NPE if root is null
		if (node.element == value) {
			return false;
		}
		if (value < node.element) {
			if (node.left == null) {
				System.out.print("left->");
				node.left = new Node<Integer>(value);
				return true;
			} else {
				System.out.print("left->");
				return insert(node.left, value);
			}
		} else {
			if (node.right == null) {
				System.out.print("right->");
				node.right = new Node<Integer>(value);
				return true;
			} else {
				System.out.print("right->");
				return insert(node.right, value);
			}
		}
	}

	public void constructRandomBST(Node<Integer> root) {
		Random rand = new Random();
		int numberOfNodes = rand.nextInt(20);
		System.out.println("Total number of nodes : " + numberOfNodes);
		if (bst.root != null) {
			int value = 0;
			for (int i = 0; i < numberOfNodes; i++) {
				value = rand.nextInt(100);
				if (rand.nextBoolean()) {
					value = value * -1;
				}
				System.out.print(value + " inserted at : root>");
				insert(bst.root, value);
				System.out.println();
			}
		}
	}

	public void inorder(Node<Integer> node) throws Exception {
		if (node != null) {
			inorder(node.left);
			System.out.println(node.element);
			if (base > node.element) {
				throw new Exception("Not a BST");
			}
			base = node.element;
			inorder(node.right);
		}
	}

	public static void main(String[] args) {
		InsertionInBST algo = new InsertionInBST();
		Node<Integer> root = new Node<Integer>(12);
		System.out.println("12 inserted at : root>");
		algo.bst.root = root;
		algo.constructRandomBST(root);
		if (ValidateBST.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			System.out.println("Tree is a BST");
		} else {
			System.out.println("Tree is not a BST");
		}
		try {
			algo.inorder(root);
			System.out.println("Tree is a BST");
		} catch (Exception e) {
			System.out.println("Tree is not a BST");
		}
	}

}
