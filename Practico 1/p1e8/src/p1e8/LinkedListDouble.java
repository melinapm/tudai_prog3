package p1e8;

/**
 * PROG 3
 * TP 1 - Ejercicio 8
 * 
 * Clase lista doblemente vinculada
 *  
 * @author  Melina PM
*/

public class LinkedListDouble {

	private Node first;
	private Node last;
	private Integer size;
	
	public LinkedListDouble() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	public void insertFront(Object o) {
		if (size != 0) {
			Node node = new Node(o, null);
			node.setNext(this.first);
			this.first.setPrevious(node);
			node.setPrevious(null);
			this.first = node; }
		else {
			Node node = new Node(o, null);
			node.setNext(null);
			node.setPrevious(null);
			node.setPrevious(null);
			this.first = node; 
			this.last = node; }
		size++;
	}
	
	public Object extractFront() {
		if (size != 0) {
			Object info = first.getInfo(); 
			first = first.getNext();
			first.setPrevious(null);
			size--;
			return info; }
		else
			return -1;
	}
	
	public Boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}	
	
	public Object get(Integer index) {
		Node temp = new Node();
		temp = first;

		int i = 0;
		if (index < size) {
			while (i < index) {
				temp = temp.getNext();
				i++;
			}
			return temp.getInfo();
		}	
		return -1;
	}
	
	public void printList() {
		Node temp = new Node();
		temp = first;
        while (temp != null) {
            System.out.print(temp.getInfo() + " " );
            temp = temp.getNext();
        }
	}

	public Integer getSize() {
		return size;
	}
		
}
