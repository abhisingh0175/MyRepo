package algorithms.bst;

public class ValidateBST extends BST<Integer> {

	ValidateBST(Node<Integer> node) {
		super(node);
	}

	public static boolean isBST(Node<Integer> node, int min, int max) {
		if (node == null) {
			return true;
		}
		int val = node.element;
		if (val > max || val < min) {
			return false;
		}
		if (node.left != null && val < node.left.element) {
			return false;
		}
		if (node.right != null && val > node.right.element) {
			return false;
		}
		return isBST(node.left, min, val) && isBST(node.right, val, max);
	}

	public static void main(String[] args) {
		ValidateBST tree = new ValidateBST(new Node<>(4));
		tree.root.left = new Node<>(2);
		tree.root.right = new Node<>(5);
		tree.root.left.left = new Node<>(1);
		tree.root.left.right = new Node<>(3);
		tree.root.right.right = new Node<>(27);
		tree.root.right.right.left = new Node<>(23);
		tree.root.right.right.right = new Node<>(127);

		if (tree.root != null) {
			System.out.println(tree.isBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		}
	}

}
