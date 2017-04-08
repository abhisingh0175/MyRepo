package algorithms.bst;

public class BST<E> {
	Node<E> root;

	BST() {
	}

	BST(Node<E> node) {
		root = node;
	}
}

class Node<E> {
	Node(E e) {
		element = e;
	}

	E element;
	Node<E> left;
	Node<E> right;
}