

public interface Fila<T> {
	public void enqueue(T e);
	public T dequeue();
	public T head();
	public int size();
	public boolean isEmpty();
	public void clear();
}
