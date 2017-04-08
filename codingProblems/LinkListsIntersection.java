package codingProblems;

public class LinkListsIntersection {

	public static void main(String[] args) {
		Node nod = new Node(12);
		nod.next = new Node(-7);
		nod.next.next = new Node(13);
		nod.next.next.next = new Node(13);
		nod.next.next.next.next = new Node(-9);
		nod.next.next.next.next.next = new Node(-9);
		nod.next.next.next.next.next.next = new Node(12);
		nod.next.next.next.next.next.next.next = nod.next;
		nod.next.next.next.next.next.next.next.next = new Node(-3);
		System.out.println("nod->"+nod);

		Node node = new Node(12);
		node.next = new Node(-9);
		node.next.next = new Node(13);
		node.next.next.next = new Node(13);
		node.next.next.next.next = new Node(-9);
		node.next.next.next.next.next = new Node(12);
		node.next.next.next.next.next.next = new Node(12);
		node.next.next.next.next.next.next.next = node.next;
		
		System.out.println(intersect(node, nod));
	}

	// brute force, o(n2)
	static boolean intersect(Node first, Node second) {
		while (first != null) {
			while (second != null) {
				if (first == second)
					return true;
				second = second.next;
			}
			first = first.next;
		}
		return false;
	}
}
