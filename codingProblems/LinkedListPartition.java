package codingProblems;

class Node {
	Node(int i) {
		val = i;
	}

	Node(int i, Node n) {
		val = i;
		next = n;
	}

	Node next;
	int val;

	@Override
	public String toString() {
		StringBuffer string = new StringBuffer("" + val);
		Node temp = this.next;
		while (temp != null) {
			string = string.append("->" + temp.val);
			temp = temp.next;
		}
		return string.toString();
	}
}

public class LinkedListPartition {

	public static void main(String[] args) {

		Node start = new Node(12);
		start.next = new Node(23);
		start.next.next = new Node(24);
		start.next.next.next = new Node(2);
		start.next.next.next.next = new Node(7);
		start.next.next.next.next.next = new Node(17);
		start.next.next.next.next.next.next = new Node(19);
		start.next.next.next.next.next.next.next = new Node(5);
		LinkedListPartition link = new LinkedListPartition();
		link.partition(start, 7);

	}

	public Node partition(Node start, int index) {
		if (start == null || start.next == null) {
			return start;
		}
		Node before = null, temp = start, tBefore = null;
		if (temp.val < index) {
			before = temp;
			before = before.next;
		} else {
			temp = temp.next;
		}
		while (temp.next != null) {
			if (temp.next.val < index) {
				if (before == null) {
					before = temp;
					tBefore = before.next;
				} else {
					tBefore = temp.next;
					tBefore = tBefore.next;
					temp = temp.next.next;
				}
			}
			temp.next = temp.next.next;
		}

		tBefore.next = temp;
		return before;
	}

}
