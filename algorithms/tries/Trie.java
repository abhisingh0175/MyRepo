package algorithms.tries;

import java.util.HashMap;

public class Trie {

	Node root;

	void insert(Node node, String str) {
		if (str == null || "".equals(str))
			return;
		char[] arr = str.toCharArray();
		Node child;
		for (int i = 0; i < arr.length; i++) {
			child = new Node();
			child.map = new HashMap<Character, Node>();
			node.map.put(arr[i], child);
			node = child;
		}
	}

	void insert(String str) {
		// search for the node till the prefix exists
		char[] arr = str.toCharArray();

		Node temp = root;
		HashMap<Character, Node> localMap = temp.map;

		for (int i = 0; i < arr.length; i++) {
			if (localMap != null && localMap.containsKey(arr[i])) {
				temp = localMap.get(arr[i]);
				localMap = temp.map;
			} else {
				insert(temp, str.substring(i));
			}
		}

	}

	boolean searchPrefix(String str) {
		char[] arr = str.toCharArray();
		HashMap<Character, Node> localMap = root.map;
		for (int i = 0; i < arr.length; i++) {
			if (localMap != null && localMap.containsKey(arr[i]))
				localMap = localMap.get(arr[i]).map;
			else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Node {
	HashMap<Character, Node> map;
	boolean wordComplete;
}