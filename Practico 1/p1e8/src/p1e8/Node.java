package p1e8;

/**
 * PROG 3
 * TP 1 - Ejercicio 8
 * 
 * Clase Nodo para lista doblemente vinculada 
 *  
 * @author  Melina PM
*/

public class Node {

	private Object info;
	private Node next;
	private Node previous;

	public Node() {
		this.info = null;
		this.next = null;
		previous = null;
	}
	
	public Node(Object o, Node n) {
		this.setInfo(o);
		this.setNext(n);
		this.setPrevious(n);
	}
	
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

}