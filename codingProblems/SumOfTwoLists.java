package codingProblems;

public class SumOfTwoLists {

	public static void main(String[] args) {
Node first = new Node(5);
first.next = new Node(5);
first.next.next = new Node(5);

Node first2 = new Node(5);
first2.next = new Node(5);
first2.next.next = new Node(5);

Node result = new SumOfTwoLists().sumOfLists(first, first2);
System.out.print(result.val+" ");
System.out.print(result.next.val+" ");
System.out.print(result.next.next.val+" ");
System.out.print(result.next.next.next.val+" ");
	}

	
	// left to right, like - (21+32=53) -> 1 2 + 2 3 = 3 5
	Node sumOfLists(Node first, Node second) {
		if (first == null)
			return second;
		if (second == null)
			return first;
		int sum;
		Node temp = new Node(0), result = temp;
		boolean carry = false;
		while (first != null || second != null) {
			sum = 0;
			if (first != null) {
				sum = first.val;
				first = first.next;
			}
			if (second != null) {
				sum = sum + second.val;
				second = second.next;
			}
			if (carry)
				sum++;
			carry = sum > 9;
			temp.next=new Node(sum % 10);
			temp=temp.next;
		}
		if(carry){
			temp.next = new Node(1);
		}

		return result.next;
	}
	
	// right to left, like - (21+32=53) -> 1 2 + 2 3 = 3 5
	//Node()
}
