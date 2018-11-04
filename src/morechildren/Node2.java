package morechildren;

import java.util.LinkedList;
import java.util.List;

public class Node2<T> {
	private T data;
	private List<Node2<T>> nodes;
	
	public Node2(T data) {
		this.nodes = new LinkedList<>();
		this.data = data;
	}
	public void addNodes(List<Node2<T>> nodes) {
		this.nodes= nodes;
	}
	
	public List<Node2<T>> getChildren(){
		return nodes;
	}
	public T getData() {
		return data;
	}
	
	
	

}
