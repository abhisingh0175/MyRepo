package codingProblems;

import java.util.HashMap;
import java.util.Map;

public class LinkListLoopDetection {

	public static void main(String[] args) {
		Node node = new Node(12);
		node.next = new Node(-9);
		node.next.next = new Node(13);
		node.next.next.next = new Node(13);
		node.next.next.next.next = new Node(-9);
		node.next.next.next.next.next = new Node(12);
		node.next.next.next.next.next.next = new Node(12);
		node.next.next.next.next.next.next.next = node.next.next;
		Node res = loopNode(node);
		if(res==null)
		System.out.println("Not found");
		else System.out.println(res.val);
	
	}
	
	public static Node loopNode(Node start){
		Map<Node, Node> map = new HashMap<>();
		Node tmp = null;
		while(start!=null){
			if(map.containsKey(start)) return map.get(start);
			map.put(start, tmp);
			tmp=start;
			start=start.next;
		}
		
		return null;
	}

}
