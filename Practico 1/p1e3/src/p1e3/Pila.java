package p1e3;

/**
 * PROG 3
 * TP 1 - Ejercicio 3
 * 
 * Clase Pila
 *  
 * @author  Melina PM
*/

import p1e1.LinkedList;

public class Pila {

	private LinkedList listaPila;
	
	public Pila() {
		listaPila = new LinkedList();
	}
	
	public void push(Object o) {
		listaPila.insertFront(o);		
	}
	
	public Object pop() {
		return listaPila.extractFront();
	}
	
	public Object top() {
		return listaPila.get(0);
	}
	
	public void reverse() {
		LinkedList tempList = new LinkedList();
		Integer sizeMax = listaPila.getSize();
		
		while (tempList.getSize() < sizeMax)
			tempList.insertFront(listaPila.extractFront());
		
		listaPila = tempList;
	}
	
	public void printPila() {
		listaPila.printList();
	}
	
}
