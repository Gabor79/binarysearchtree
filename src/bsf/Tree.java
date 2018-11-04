package bsf;

public interface Tree<T> {
	public void insert(T data);
	public void delete(T data);
	public void traversal();
	public T getMax();
	public T getMin();
	public int getAgesSum();
}
