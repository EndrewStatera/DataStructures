public class FilaComEncadeamentoDuplo<T> implements Fila<T> {
	DoubleLinkedListGenerica<T> fila = new DoubleLinkedListGenerica<>();

	public FilaComEncadeamentoDuplo() {
		
	}

	@Override
	public void enqueue(T e) {
		fila.add(e);
	}

	@Override
	public T dequeue() {
		if (fila.isEmpty())
			throw new RuntimeException("A fila esta vazia!");
		T aux = head();
		fila.removeByIndex(0);
		return aux;

	}

	@Override
	public T head() {
		if (fila.isEmpty())
			throw new RuntimeException();
		return fila.get(0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return fila.size();
	}

	@Override
	public boolean isEmpty() {
		return fila.isEmpty();
	}

	@Override
	public void clear() {
		fila.clear();
	}
}
