public class ListaArray {
	
	private static final int CAPACIDADE_INICIAL = 10;
	private int length = 0;
	private Object[] data;
	
	public ListaArray() {
		data = new Object[CAPACIDADE_INICIAL];
	}
	
	public ListaArray(int n) {
		data = new Object[n];
	}
	
	public void add(Object obj) {
		if(length >= size()) {
			setCapacity();
		}
	}
	
	public void add(int index, Object obj) {
		
	}
	
	public boolean remove(Object element) {
		for(int i = 0; i < size(); i++) {
			if(element.equals(data[i])) {
				for(int j = i; j < size() - 1; j++) {
					data[j] = data[j+1];
				}
				//data[]
				return true;
			}
		}
		return false;
	}
	public Object get(int index) {
		if(index < 0 || index >= size()) {throw new IndexOutOfBoundsException();}
		return data[index];
	}
	
	public int size() {
		return this.length;
	}
	
	private void setCapacity() {
		
	}
	
	public boolean contains(Object element) {
		return false;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}

}
