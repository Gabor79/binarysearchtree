package bsf;

public class Main {

	public static void main(String[] args) {
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(20);
		bst.insert(3);
		bst.insert(1);
		bst.insert(30);
		bst.traversal();
		System.out.println();
		System.out.println(bst.getMax());
		System.out.println(bst.getMin());
		System.out.println(bst.getAgesSum());

	}

}
