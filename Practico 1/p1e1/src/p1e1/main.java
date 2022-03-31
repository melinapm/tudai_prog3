package p1e1;

/**
 * PROG 3
 * TP 1 - Ejercicio 1
 * 
 * Clase lista vinculada - Main
 *  
 * @author  Melina PM
*/

public class main {

	public static void main(String[] args) {
		LinkedList listaNumeros = new LinkedList();
//		System.out.println(listaNumeros.isEmpty());	

		listaNumeros.insertFront(5);
		listaNumeros.insertFront(4);
		listaNumeros.insertFront(3);
		listaNumeros.insertFront(2);
		listaNumeros.insertFront(1);
		
//		System.out.println(listaNumeros.isEmpty());
//		
//		listaNumeros.printList();
//
//		System.out.println("Tamaño: " + listaNumeros.getSize());
//		
//		System.out.println("Pos 0: " + listaNumeros.get(0));
//		System.out.println("Pos 1: " + listaNumeros.get(6));
//		
		listaNumeros.extractFront();
		listaNumeros.extractFront();
		listaNumeros.extractFront();

		listaNumeros.printList();
		
	}

}
