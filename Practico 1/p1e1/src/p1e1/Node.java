package p1e1;

/**
 * PROG 3
 * TP 1 - Ejercicio 1
 * 
 * Clase Nodo para lista 
 *  
 * @author  Melina PM
*/

public class Node {

	private Object info;
	private Node next;

	public Node() {
		this.info = null;
		this.next = null;
	}
	
	public Node(Object o, Node n) {
		this.setInfo(o);
		this.setNext(n);
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

}