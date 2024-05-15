import java.util.EmptyStackException;
////IMCOMPLETO
public class PilhaArray<T> implements Pilha {
	
	private Integer[] pilha;
	private int count;
	
	public PilhaArray(){
		count = 0;
		pilha = new Integer[10];
	}
	
	public void push(Integer element) {
		if(count == pilha.length)throw new IndexOutOfBoundsException();
		pilha[count] = element;
		count++;
		
	}
	
	public Integer pop() {
		if(count == 0)throw new EmptyStackException();
		Integer aux = pilha[count-1];
		pilha[count--] = null;
		return aux;//IMCOMPLETO
	}
	
	public int size() {
		return count;
	}
	
	public Integer top() {
		if(count == 0)throw new EmptyStackException();
		return pilha[count-1];
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public void clear() {
		
	}
}
