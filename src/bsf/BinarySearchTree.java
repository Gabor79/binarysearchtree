package bsf;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
	private Node<T> root;

	@Override
	public void insert(T data) {
		if (root == null) {
			root = new Node<T>(data);
		} else {
			insertValue(data, root);
		}

	}

	private void insertValue(T data, Node<T> node) {
		if (data.compareTo(node.getData()) > 0) {
			if (node.getRightChild() == null) {
				node.setRightChild(new Node<T>(data));
			} else {
				insertValue(data, node.getRightChild());
			}
		} else {
			if (node.getLeftChild() == null) {
				node.setLeftChild(new Node<T>(data));
			} else {
				insertValue(data, node.getLeftChild());
			}
		}

	}

	@Override
	public void delete(T data) {
		if(root!=null) {
			root = deleteValue(root,data);
		}
	}

	private Node<T> deleteValue(Node<T> node, T data) {
		if(node == null) return node;
		
		if(data.compareTo(node.getData())<0) {
			node.setLeftChild(deleteValue(node.getLeftChild(),data));
		}else if (data.compareTo(node.getData())>0) {
			node.setRightChild(deleteValue(node.getRightChild(), data));
		}else {
			if(node.getLeftChild()==null && node.getRightChild()==null) {
				System.out.println("Removeing a leaf node");
				return null;
			}
			if(node.getLeftChild()==null) {
				System.out.println("Removing right child");
				Node<T> temp = node.getRightChild();
				node = null;
				return temp;
			}
			else if(node.getRightChild()==null) {
				System.out.println("Removing left child");
				Node<T> temp = node.getLeftChild();
				node = null;
				return temp;
			}
			
			Node<T> temp = getPredesessor(node.getLeftChild());
			node.setData(temp.getData());
			node.setLeftChild(deleteValue(node.getLeftChild(), temp.getData()));
		}
		
		
		return node;
	}

	private Node<T> getPredesessor(Node<T> node) {
		if(node.getRightChild()!=null) {
			return getPredesessor(node.getRightChild());
		}
		return node;
	}

	@Override
	public void traversal() {
		if (root == null)
			return;
		inorderTraversal(root);
		System.out.println();
		preorderTraversal(root);
		System.out.println();
		postorderTraversal(root);
	}

	private void postorderTraversal(Node<T> node) {
		if (node != null) {
			postorderTraversal(node.getLeftChild());
			postorderTraversal(node.getRightChild());
			System.out.print(node.getData() + " -> ");
		}

	}

	private void preorderTraversal(Node<T> node) {
		if (node != null) {
			System.out.print(node.getData() + " -> ");
			preorderTraversal(node.getLeftChild());
			preorderTraversal(node.getRightChild());
		}
	}

	private void inorderTraversal(Node<T> node) {
		if (node != null) {
			inorderTraversal(node.getLeftChild());
			System.out.print(node.getData() + " -> ");
			inorderTraversal(node.getRightChild());
		}
	}

	@Override
	public T getMax() {
		if(root ==null) return null;
		return getMaxValue(root);
	}

	private T getMaxValue(Node<T> node) {
		if(node.getRightChild()!=null) {
			return getMaxValue(node.getRightChild());
		}
		return node.getData();
	}

	@Override
	public T getMin() {
		if(root ==null) return null;
		return getMinValue(root);
	}
	
	private T getMinValue(Node<T> node) {
		if(node.getLeftChild()!=null) {
			return getMaxValue(node.getLeftChild());
		}
		return node.getData();
	}

	@Override
	public int getAgesSum() {
		int leftSum=0;
		int rightSum=0;
		if(root == null ) {
			return 0;
		}
		leftSum = getAgesSumLeft(root.getLeftChild());
		rightSum = getAgesSumRight(root.getRightChild());
		
		return (Integer)root.getData() + leftSum+rightSum;
	}

	private int getAgesSumLeft(Node<T> root) {
		int sum = 0;
		if(root==null) {
			return 0;
		}
		sum += getAgesSumLeft(root.getLeftChild());
		return (Integer)root.getData()+sum;
	}

	private int getAgesSumRight(Node<T> root) {
		int sum = 0;
		if(root==null) {
			return 0;
		}
		sum += getAgesSumRight(root.getRightChild());
		return (Integer)root.getData()+sum;
	}

}
