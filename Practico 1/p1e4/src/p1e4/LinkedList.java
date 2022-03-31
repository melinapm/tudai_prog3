package p1e4;

/**
 * PROG 3
 * TP 1 - Ejercicio 4
 * 
 * Clase lista vinculada con indexOf
 *  
 * @author  Melina PM
*/

public class LinkedList {

	private Node first;
	private Integer size;
	
	public LinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertFront(Object o) {
		Node node = new Node(o, null);
		node.setNext(this.first);
		this.first = node;
		size++;
	}
	
	public Object extractFront() {
		if (size != 0) {
			Object info = first.getInfo(); 
			first = first.getNext();
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
	
	public Integer indexOf(Object o) {
		Node temp = new Node();
		temp = first;
		int i = 0;
		
		while (temp != null) {
			if (temp.getInfo().equals(o))
					return i;
			else {
				i++; 
				temp = temp.getNext();}
		}
		
		return -1;
	}
		
}
