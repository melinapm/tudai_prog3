package p1e5;

/**
 * PROG 3
 * TP 1 - Ejercicio 5
 * 
 * Clase lista vinculada + patron iterator iterable - Main
 *  
 * @author  Melina PM
*/

public class main {

	public static void main(String[] args) {
		
		LinkedList listaPrueba = new LinkedList();
		
		listaPrueba.insertFront(5);
		listaPrueba.insertFront(4);
		listaPrueba.insertFront(3);
		listaPrueba.insertFront(2);
		listaPrueba.insertFront(1);
		
		//listaPrueba.printList();
		
		IteradorLista iteradorPrueba = listaPrueba.iterator();
//		for (int i=0; i < listaPrueba.getSize(); i++) {
//			System.out.println(iteradorPrueba.get());
//			iteradorPrueba.next();
//		}
		
		
		// El while no entra cuando en la pos 5 no tengo next,
//			por eso no lo muestra
		while (iteradorPrueba.hasNext()) {
			System.out.println(iteradorPrueba.get());
			iteradorPrueba.next();
		}	
		//System.out.println(iteradorPrueba.get());
		
	}

}
