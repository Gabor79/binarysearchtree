package morechildren;

import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Node2<Integer> root = new Node2<>(2);
		List<Node2<Integer>> child = new LinkedList<>();
		Node2<Integer >childNode1 = new Node2<Integer>(3);
		Node2<Integer >childNode3 = new Node2<Integer>(10);
		child.add(childNode1);
		child.add(new Node2<Integer>(4));
		child.add(childNode3);
		root.addNodes(child);
		
		List<Node2<Integer>> child2 = new LinkedList<>();
		Node2<Integer >childNode21 = new Node2<Integer>(20);
		Node2<Integer >childNode23 = new Node2<Integer>(26);
		child2.add(childNode21);
		child2.add(childNode23);
		childNode1.addNodes(child2);
		
		System.out.println(sumof(root));
	}

	private static int sumof(Node2<Integer> root) {
		int sum  = 0;
		if(root==null) {
			return 0;
		}
		for (Node2 n2: root.getChildren()) {
			sum += sumof(n2);
		}
		return root.getData() + sum ;
	}

}
