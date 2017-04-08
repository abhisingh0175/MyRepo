package algorithms.tree;

public class Tree<E> {
	Node<E> root;

	Tree(Node<E> n) {
		root = n;
	}

	public void preorder(Node<E> node) {
		if (node != null) {
			System.out.println(node.element);
			preorder(node.left);
			preorder(node.right);
		}
	}

	public void bsf(E element) {
		int level = 0;
		Node<E> node = root;
		if (node != null && element.equals(node.element)) {
			System.out.println("Element found at level : " + level);
		} else if (node != null) {
			bsf(node.left, element, level);
		}

	}

	private void bsf(Node<E> node, E element, int level) {
		if (node.element != null && (element.equals(node.left) || element.equals(node.right))) {
			System.out.println("Element found at level : " + level);
		}
	}

	public static void main(String[] args) {
		Tree<String> tree = new Tree<String>(new Node<String>("a"));
		if (tree.root != null) {
			tree.root.left = new Node<String>("abhi");
			tree.root.right = new Node<String>("abhay");
			tree.root.left.left = new Node<String>("abhishek");
		}
		tree.preorder(tree.root);
	}

}

class Node<E> {
	Node(E e) {
		element = e;
	}

	Node<E> left;
	Node<E> right;
	E element;
}