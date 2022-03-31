package p1e5;

import java.util.Iterator;

public class IteradorLista<T> implements Iterator<T>{

	private Node cursor;
	
	public IteradorLista(Node first) {
		cursor = first;
	}
	
	@Override
	public boolean hasNext() {
		//return cursor.getNext() != null;
		return cursor != null; // Lo cambie para tener el ultimo valor en los while
	}
	
	public Object get() {
		return cursor.getInfo();
	}

	@Override
	public T next() {
		Node aux = cursor;
		cursor = cursor.getNext();
		return (T) aux.getInfo();
	}
	
}
