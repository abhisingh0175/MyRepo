package codingProblems;

import java.util.Stack;

public class IsAListPalindrom {

	public static void main(String[] args) {
		Node node = new Node(12);
		node.next = new Node(-9);
		node.next.next = new Node(13);
		node.next.next.next = new Node(13);
		node.next.next.next.next = new Node(-9);
		node.next.next.next.next.next = new Node(12);
		//node.next.next.next.next.next.next = new Node(12);
		System.out.println(isPalindrom2(node));

	}

	static boolean isPalindroam(Node start) {
		if (start == null || start.next == null)
			return true;
		Stack<Integer> stack = new Stack<>();
		Node slow = start;
		Node fast = start;
		while (fast != null && fast.next != null) {
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		// now we are at the half of the list

		if (fast != null) {
			// it means length is odd
			slow = slow.next;
		}
		while (slow != null) {
			if (slow.val != stack.pop())
				return false;
			slow = slow.next;
		}
		return true;
	}

	static boolean isPalindrom2(Node node) {
		Node clone = reverseAndClone(node);
		System.out.println("node : " + node);
		System.out.println("clone : " + clone);
		return comparePalindrom(node, clone);
	}

	static Node reverseAndClone(Node start) {
		Node head = null;
		while (start != null) {
			head = new Node(start.val, head);
			start = start.next;
		}
		return head;
	}

	static boolean comparePalindrom(Node node, Node reverse) {
		Node fast = node;
		while (node != null && reverse != null && fast != null && fast.next != null) {
			if (node.val != reverse.val)
				return false;
			fast = fast.next.next;
			node = node.next;
			reverse = reverse.next;
		}
		return true;
	}

}
