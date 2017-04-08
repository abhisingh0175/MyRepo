package algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import algorithms.stack.Stack;

public class Graph<T> {
	Node<T> node;

	Graph(Node<T> inputNode) {
		node = inputNode;
	}

	void printBFS(Graph<T> graph) {
		Node<T> node = graph.node;
		List<Node<T>> list = new ArrayList<>();
		list.addAll(Arrays.asList(node.neighbours));
		int count = 0;
		while (!node.visited) {
			visit(node);
			if (count < list.size())
				node = list.get(count++);
			if (node != null && node.neighbours != null)
				list.addAll(Arrays.asList(node.neighbours));
		}
	}

	void dfs(Node<T> node) throws Exception {
		if (node != null) {
			visit(node);
			node.visited = true;
			if(node.neighbours!=null)
			for (Node<T> n : node.neighbours) {
				if (!n.visited) {
					dfs(n);
				}
			}
		}
	}

	void printDFS(Graph<T> graph) throws Exception {
		Node<T> node = graph.node;
		Stack<Node<T>> stack = new Stack<>();
		while (!node.visited) {
			visit(node);
			for (Node<T> temp : node.neighbours) {
				if (temp != null)
					stack.push(temp);
			}
			while (stack.top != 0 && stack.peek().visited)
				stack.pop();
			if (stack.top == 0)
				return;
			node = stack.pop();
		}

	}

	public void visit(Node<T> node) {
		node.visited = true;
		System.out.println(node.data);
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {

		Node[] node1Neigh = { new Node<>(3), new Node<>(4), new Node<>(5) };
		Node[] node2Neigh = { new Node<>(6), new Node<>(7), new Node<>(8), new Node<>(9) };
		Node[] node3Neigh = { new Node<>(13), new Node<>(14) };
		Node[] node4Neigh = { new Node<>(16), new Node<>(17), new Node<>(18), new Node<>(8), new Node<>(9) };
		Node<Integer> node1 = new Node<>(12, node1Neigh);
		Node<Integer> node2 = new Node<>(12, node2Neigh);
		Node<Integer> node3 = new Node<>(12, node3Neigh);
		Node<Integer> node4 = new Node<>(12, node4Neigh);
		Node[] closetNegh = { node1, node2, node3, node4 };
		Node<Integer> node = new Node<>(1, closetNegh);
		Graph<Integer> graph = new Graph<>(node);
		// graph.printDFS(graph);
		graph.dfs(graph.node);
		int[] abc=null;
		for(int i:abc){
			
		}
	}
}

class Node<T> {
	Node<T>[] neighbours;
	T data;
	boolean visited;

	Node(T inputData) {
		data = inputData;
	}

	Node(T inputData, Node<T>[] neighbourNodes) {
		data = inputData;
		neighbours = neighbourNodes;
	}
}
