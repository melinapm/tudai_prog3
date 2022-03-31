package p1e8;

/**
 * PROG 3
 * TP 1 - Ejercicio 8
 * 
 * Clase lista doblemente vinculada - Main
 *  
 * @author  Melina PM
*/

public class main {

	public static void main(String[] args) {
		LinkedListDouble listaNumeros = new LinkedListDouble();
//		System.out.println(listaNumeros.isEmpty());	

		listaNumeros.insertFront(5);
		listaNumeros.insertFront(4);
		listaNumeros.insertFront(3);
		listaNumeros.insertFront(2);
		listaNumeros.insertFront(1);
		
		System.out.println(listaNumeros.isEmpty());
		
		listaNumeros.printList();

		System.out.println("Tamaño: " + listaNumeros.getSize());
		
		System.out.println("Pos 0: " + listaNumeros.get(0));
		System.out.println("Pos 1: " + listaNumeros.get(6));
		
		listaNumeros.extractFront();
		listaNumeros.extractFront();
		listaNumeros.extractFront();

		listaNumeros.printList();
		
	}

}
