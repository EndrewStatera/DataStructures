public class DoubleLinkedListGenerica<T> {
	// Referencia para o sentinela de inicio da lista encadeada.
	private Node header;
	// Referencia para o sentinela de fim da lista encadeada.
	private Node trailer;
	// Contador do numero de elementos da lista.
	private Node current;
	private int count;

	private class Node {
		public T element;
		public Node next;
		public Node prev;

		public Node(T e) {
			element = e;
			next = null;
			prev = null;
		}
		
		public String toString() {
			return "" + this.element;
		}
	}
	
	public void reset() {
		this.current = header.next;
	}
	
	public T next() {
		if(current == trailer) {
			return null;
		}else {
			Node aux = current;
			this.current = current.next;
			return aux.element;
		}
		
	}

	public DoubleLinkedListGenerica() {
		header = new Node(null);
		trailer = new Node(null);
		header.next = trailer;
		trailer.prev = header;
		count = 0;
	}

	/**
	 * Adiciona um elemento ao final da lista
	 * 
	 * @param element elemento a ser adicionado ao final da lista
	 */
	public void add(T element) {
		Node n = new Node(element);
		n.next = trailer;
		n.prev = trailer.prev;
		Node aux = trailer.prev;
		aux.next = n;
		trailer.prev = n;
		count++;
	}
	
	public void add(T[] elements) {
		for(int i = 0; i < elements.length; i++) {
			add(elements[i]);
		}
	}

	/**
	 * Insere um elemento em uma determinada posicao da lista
	 * 
	 * @param index   a posicao da lista onde o elemento sera inserido
	 * @param element elemento a ser inserido
	 * @throws IndexOutOfBoundsException se (index < 0 || index > size())
	 */
	public void add(int index, T element) throws IndexOutOfBoundsException {
		if (index < 0 || index > count) // indice invalido
			throw new IndexOutOfBoundsException();
		if(index == count)add(element);
		else {
			Node n = new Node(element);
			Node aux = getNodeIndex(index);
			n.next = aux;
			n.prev = aux.prev;
			aux.prev.next = n;
			aux.prev = n;
			count++;
		}
		
	}

	/**
	 * Remove a primeira ocorrencia do elemento na lista, se estiver presente
	 * 
	 * @param element o elemento a ser removido
	 * @return true se a lista contem o elemento especificado
	 */
	public boolean remove(T element) {
		Node aux = header.next;
		while (aux != trailer) {
			if (aux.element.equals(element)) {
				aux.prev.next = aux.next;
				aux.next.prev = aux.prev;
				count--;
				return true;
			}
			aux = aux.next;
		}
		return false;
	}
	
	public boolean removeEvenNumbers() {
		Node aux = header.next;
		boolean removido = false;
		while(aux != trailer) {
			if(header.element instanceof Integer && ((Integer)aux.element) % 2 == 0 ) {
				aux.prev.next = aux.next;
				aux.next.prev = aux.prev;
				count--;
				removido = true;
			}
			aux = aux.next;
		}
		return removido;
	}

	/**
	 * Remove o elemento de uma determinada posicao da lista
	 * 
	 * @param index a posicao da lista
	 * @return o elemento que foi removido da lista
	 * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
	 */
	public T removeByIndex(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException();
		}
		Node removendo = getNodeIndex(index);
		removendo.prev.next = removendo.next;
		removendo.next.prev = removendo.prev;
		count--;
		return removendo.element;
	}

	/**
	 * Retorna true se a lista contem o elemento especificado
	 * 
	 * @param element o elemento a ser testado
	 * @return true se a lista contém o elemento especificado
	 */
	public boolean contains(Integer element) {
		Node aux = header.next;
		for (int i = 0; i < count; i++) {
			if (aux.element == element)
				return true;
			aux = aux.next;
		}
		return false;
	}

	/**
	 * Retorna o elemento de uma determinada posicao da lista
	 * 
	 * @param index a posicao da lista
	 * @return o elemento da posicao especificada
	 * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
	 */
	public T get(int index) {
		if ((index < 0) || (index >= count)) {
			throw new IndexOutOfBoundsException();
		}
		if (index < count / 2) {
			Node aux = header.next;
			for (int i = 0; i < index; i++) {
				aux = aux.next;
			}
			return aux.element;
		} else {
			Node aux = trailer.prev;
			for (int i = count; i > index; i--) {
				aux = aux.prev;
			}
			return aux.element;
		}
	}

	public Node getNodeIndex(int index) {
		if ((index < 0) || (index >= count)) {
			throw new IndexOutOfBoundsException();
		}
		if (index < count / 2) {
			Node aux = header.next;
			for (int i = 0; i < index; i++) {
				aux = aux.next;
			}
			return aux;
		} else {
			Node aux = trailer.prev;
			for (int i = count - 1; i > index; i--) {
				aux = aux.prev;
			}
			return aux;
		}
	}

	/**
	 * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
	 * lista não contém o elemento
	 * 
	 * @param element o elemento a ser buscado
	 * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
	 *         lista não contém o elemento
	 */
	public int indexOf(Integer element) {
		Node aux = header.next;
		for(int i = 0; i < count; i++) {
			if(aux.element == element) {
				return i + 1;
			}
			aux = aux.next;
		}
		return -1;
	}

	/**
	 * Substitui o elemento armanzenado em uma determinada posicao da lista pelo
	 * elemento indicado
	 * 
	 * @param index   a posicao da lista
	 * @param element o elemento a ser armazenado na lista
	 * @return o elemento armazenado anteriormente na posicao da lista
	 * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
	 */
	public Integer set(int index, Integer element) {
		if ((index < 0) || (index >= count)) {
			throw new IndexOutOfBoundsException();
		}
		// Implementar este método
		return null;
	}

	/**
	 * Esvazia a lista
	 */
	public void clear() {
		header = new Node(null);
		trailer = new Node(null);
		header.next = trailer;
		trailer.prev = header;
		count = 0;
	}

	/**
	 * Retorna o numero de elementos da lista
	 * 
	 * @return o numero de elementos da lista
	 */
	public int size() {
		return count;
	}

	/**
	 * Retorna true se a lista não contem elementos
	 * 
	 * @return true se a lista não contem elementos
	 */
	public boolean isEmpty() {
		return (count == 0);
	}
	
	public String toStringBackToFront() {
		String saida = "";
		Node aux = trailer.prev;
		while(aux != header) {
			saida += aux.element + "\n";
			aux = aux.prev;
		}
		return saida;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		Node aux = header.next;
		for (int i = 0; i < count; i++) {
			s.append(aux.element.toString());
			s.append("\n");
			aux = aux.next;
		}
		return s.toString();
	}

	/**
	 * Retorna um arranjo com uma copia de um subconjunto dos elementos da lista.
	 *
	 * @param fromIndex a posição inicial ("inclusive") dos elementos a serem
	 *                  incluídos
	 * @param toIndex   a posição final ("exclusive") dos elementos a serem
	 *                  incluídos
	 * @return um arranjo com um subconjunto da lista
	 * @throws IndexOutOfBoundsException se (fromIndex < 0 || toIndex > size())
	 * @throws IllegalArgumentException  se (fromIndex > toIndex)
	 */
	public Object[] subList(int fromIndex, int toIndex) {
		if(fromIndex < 0 || toIndex >= count) {
			throw new IndexOutOfBoundsException();
		}
		if(fromIndex > toIndex) {
			throw new IllegalArgumentException();
		}
		Node aux = getNodeIndex(fromIndex);
		int length = toIndex - fromIndex;
		Object[] elements = new Object[length];
		for(int i = 0; i < length; i++) {
			elements[i] = aux.element;
			aux = aux.next;
		}
		return elements;
	}
	
	public void reverse() {
		Node aux1 = header.next;
		Node aux2 = trailer.prev;
		for(int i = 0; i < (count/2); i++) {
			T aux = aux1.element;
			aux1.element = aux2.element;
			aux2.element = aux;
			aux1 = aux1.next;
			aux2 = aux2.prev;
		}
		
	}
	
	public void unique() {
		Node aux = header.next;
		for(int i = 0; i < count; i++) {
			Node aux2 = header.next;
			for(int j = 0; j < count; j++) {
				if(aux.element.equals(aux2.element) && i != j) {
					removeByIndex(j);
				}
				aux2 = aux2.next;
			}
			aux = aux.next;
		}
	}
	
	public int countOccurrences(Integer numero) {
		Node aux = header.next;
		int cont = 0;
		for(int i = 0; i < count; i++) {
			if(aux.element.equals(numero))cont++;
			aux = aux.next;
		}
		return cont;
	}
	
	
	public int lastIndexOf(int element) {
		Node aux = header.next;
		int indice = -1;
		for(int i = 0; i < count; i++) {
			if(aux.element.equals(element))indice = i;
			aux = aux.next;
		}
		return indice;
	}
}