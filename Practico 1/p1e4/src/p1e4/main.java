package p1e4;

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

		listaNumeros.insertFront("a");
		listaNumeros.insertFront("b");
		listaNumeros.insertFront("c");
		listaNumeros.insertFront("d");
		listaNumeros.insertFront("e");
		
		listaNumeros.printList();
		
		System.out.println(listaNumeros.indexOf("z"));
		
	}

}
