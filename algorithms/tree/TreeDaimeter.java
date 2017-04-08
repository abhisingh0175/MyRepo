package algorithms.tree;

import java.util.Random;

public class TreeDaimeter {
	Node<Integer> root;
	static int maxLeftPluMaxRightHeight;
	static int maxNodes = 0;
	static Random random = new Random();

	TreeDaimeter(Node<Integer> node) {
		root = node;
		maxNodes++;
	}

	public int getDiameter() {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return maxLeftPluMaxRightHeight + 1;
		}
		if (root.left == null || root.right == null) {
			return maxLeftPluMaxRightHeight + 2;
		}
		return maxLeftPluMaxRightHeight + 3;
	}

	public int height(Node<Integer> node) {
		if (node == null || (node.left == null && node.right == null)) {
			return 0;
		}
		int l_height = 0, r_height = 0;
		if (node.left != null) {
			l_height = height(node.left);
		}
		if (node.right != null) {
			r_height = height(node.right);
		}
		int localDia = l_height + r_height;
		if (maxLeftPluMaxRightHeight < localDia) {
			maxLeftPluMaxRightHeight = localDia;
		}
		if (l_height > r_height) {
			return l_height + 1;
		} else {
			return r_height + 1;
		}
	}

	public void addMoreNodes(Node<Integer> node) {
		if (node != null && maxNodes++ < 50) {
			if (random.nextBoolean() || (random.nextBoolean() && random.nextBoolean())) {
				node.left = new Node<Integer>(random.nextInt(200));
				addMoreNodes(node.left);
			}
			if (random.nextBoolean() || (random.nextBoolean() && random.nextBoolean())) {
				node.right = new Node<Integer>(random.nextInt(200));
				addMoreNodes(node.right);
			}
		}
	}
	/*
	 * @Override public String toString(){ if(root!=null){ Node node =root;
	 * while(node!=null){
	 * 
	 * } } return ""; }
	 */

	public static void main(String[] args) {
/*		Node<Integer> root = new Node<Integer>(23);
		root.left = new Node<Integer>(23);
		root.left.left = new Node<Integer>(23);
		root.left.right = new Node<Integer>(23);
		root.left.right.left = new Node<Integer>(23);
		root.left.right.right = new Node<Integer>(23);
		root.right = new Node<Integer>(23);
		root.right.right = new Node<Integer>(23);
		root.right.right.right = new Node<Integer>(23);
		root.right.right.right.right = new Node<Integer>(23);
		root.right.right.right.left = new Node<Integer>(23);
		root.right.right.right.left.left = new Node<Integer>(23);
		root.right.right.right.left.right = new Node<Integer>(23);*/

		/*
		 * Node<Integer> root2 = new Node<Integer>(23); root2.left = new
		 * Node<Integer>(23); root2.right = new Node<Integer>(23);
		 * root2.right.left = new Node<Integer>(23); root2.right.right = new
		 * Node<Integer>(23); root2.right.left.left = new Node<Integer>(23);
		 * root2.right.left.left.right = new Node<Integer>(23);
		 * root2.right.left.right = new Node<Integer>(23);
		 * 
		 * 
		 * TreeDaimeter tree1 = new TreeDaimeter(root2);
		 * System.out.println(tree1.height(tree1.root));
		 */

		// if you need to fill random nodes
		// tree1.addMoreNodes(tree1.root);
Node root = new Node<>(12);;
		
		/*root.left = new Node<Integer>(23);
		root.left.right = new Node<Integer>(23);
		root.left.right.right = new Node<Integer>(23);
		root.left.right.left = new Node<Integer>(23);
		root.right = new Node<Integer>(23);
		root.right.left = new Node<Integer>(23);
		root.right.left.left = new Node<Integer>(23);*/
		
		root.right = new Node<Integer>(23);
		root.right.right = new Node<Integer>(23);
		root.left = new Node<Integer>(23);
		root.right = new Node<Integer>(23);
		root.left.right = new Node<Integer>(23);
		root.left.right.right = new Node<Integer>(23);
		root.left.right.right.right = new Node<Integer>(23);
		root.left.right.right.right.right = new Node<Integer>(23);
		root.left.left = new Node<Integer>(23);
		root.left.left.right = new Node<Integer>(23);
		root.left.left.right.left = new Node<Integer>(23);
		root.left.left.right.left.left = new Node<Integer>(23);
		root.left.left.right.left.right = new Node<Integer>(23);
		root.left.left.left = new Node<Integer>(23);
		TreeDaimeter tree1 = new TreeDaimeter(root);

		System.out.println(tree1.height(tree1.root));

		System.out.println(tree1.getDiameter());

	}

}

