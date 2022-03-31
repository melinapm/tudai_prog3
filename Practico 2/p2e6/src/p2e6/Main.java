package p2e6;

import java.util.ArrayList;

/**
 * PROG 3
 * 
 * Ejercicio Entregable - TP2
 * 
 * @author  Melina Perez Mounet
*/

public class Main {

	public static void main(String[] args) {
		
		// Se construye el árbol de ejemplo utilizando el constructor previamente mencionado
		int[] valoresIniciales = new int[] {15, 4, 1, 25, 50, 6, 7, 20, 5, 30};
		// Se construye el árbol de ejemplo utilizando el constructor previamente mencionado
		TreeWithNode miArbol = new TreeWithNode(valoresIniciales);
		
		miArbol.printPreOrden();
		System.out.println(miArbol.getMaxElement());
		System.out.println(miArbol.getHeight());
		System.out.println(miArbol.getLongestBranch());
		System.out.println(miArbol.getElemAtLevel(2));
		System.out.println(miArbol.getFrontera());

		miArbol.add(23);
		miArbol.add(3);
		miArbol.delete(6);
		miArbol.delete(30);

		miArbol.printPreOrden();
		System.out.println(miArbol.getMaxElement());
		System.out.println(miArbol.getHeight());
		System.out.println(miArbol.getLongestBranch());
		System.out.println(miArbol.getElemAtLevel(2));
		System.out.println(miArbol.getFrontera());

		miArbol.add(65);
		miArbol.delete(5);
		miArbol.delete(15);
		miArbol.add(55);

		miArbol.printPreOrden();
		System.out.println(miArbol.getMaxElement());
		System.out.println(miArbol.getHeight());
		System.out.println(miArbol.getLongestBranch());
		System.out.println(miArbol.getElemAtLevel(2));
		System.out.println(miArbol.getFrontera());
		
	}
	
}
