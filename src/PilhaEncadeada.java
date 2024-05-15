import java.util.EmptyStackException;

public class PilhaEncadeada implements Pilha{
	class Node{
		public Integer element;
		public Node next;
		public Node(Integer element) {
			this.element = element;
		}
	}
	
	private int count;
	private Node topo;
	
	public PilhaEncadeada(){
		count = 0;
		topo = null;
	}
	
	public void push(Integer element) {
		Node n = new Node(element);
		if(count > 0) {
			n.next = topo;
		}
		topo = n;
		count++;
		
	}
	
	public Integer pop() {
		if(count == 0)throw new EmptyStackException();
		Integer elemento = (Integer)topo.element;
		topo = topo.next;
		count--;
		return elemento;
	}
	
	public int size() {
		return count;
	}
	
	public Integer top() {
		if(count == 0)throw new EmptyStackException();
		return (Integer)topo.element;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public void clear() {
		while(topo != null) {
			pop();
		}
	}
}
