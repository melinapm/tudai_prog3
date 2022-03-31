package p1e7;

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
	
	public T get() {
		return (T) cursor.getInfo();
	}
	
	// Ver si esto esta ok
	public void setInfo(Object info) {
		cursor.setInfo(info);
	}
	
	@Override
	public T next() {
		Node aux = cursor;
		cursor = cursor.getNext();
		return (T) aux.getInfo();
	}
	
	public T nextInfo() {
		Node aux = cursor;
		return (T) aux.getNext().getInfo();
	}
	
}
