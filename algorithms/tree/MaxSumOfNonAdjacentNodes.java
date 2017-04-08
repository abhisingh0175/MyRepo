package algorithms.tree;

public class MaxSumOfNonAdjacentNodes {
	Node<Integer> root;
	static int recurrsionCounter=0; 

	MaxSumOfNonAdjacentNodes(Node<Integer> node) {
		root = node;
	}

	public int findSum(Node<Integer> node) {
		recurrsionCounter++;
		
		int sum = node.element;
		int leftSum=0, rightSum=0;
		if(node.left!=null){
			leftSum = findSum(node.left);
		}
		if(node.right!=null){
			rightSum = findSum(node.right);
		}
		sum = leftSum + rightSum <= sum ? sum : leftSum + rightSum;
		return sum;
	}

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(100);
		MaxSumOfNonAdjacentNodes tree = new MaxSumOfNonAdjacentNodes(root);
		root.left=new Node<>(2);
		root.right=new Node<>(3);
		root.right.left = new Node<>(4);
	    root.right.right = new Node<>(5);
	    root.left.left = new Node<>(1);
	    root.left.left.left = new Node<>(18);
	    if(root!=null){
	    	System.out.println(tree.findSum(root));
	    }
	    
	    System.out.println(recurrsionCounter);
		
	}

}
