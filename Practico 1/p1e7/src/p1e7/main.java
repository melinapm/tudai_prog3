package p1e7;

/**
 * PROG 3
 * TP 1 - Ejercicio 7
 * 
 *  
 * @author  Melina PM
*/

public class main {

	public static void main(String[] args) {
	
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		
		l1.insertFront(1);
		l1.insertFront(3);
		l1.insertFront(4);
		l1.insertFront(5);
		l1.insertFront(6);
		l1.insertFront(8);
		
		l2.insertFront(1);
		l2.insertFront(8);
		l2.insertFront(9);
		l2.insertFront(13);
		l2.insertFront(20);
		l2.insertFront(56);
		
		LinkedList resultado = new LinkedList();
		
		// Ejercicio 7
		resultado = diferencia(l1,l2);
		resultado.printList();
		
		
	}
	
	public static LinkedList diferencia(LinkedList lista1, LinkedList lista2){
		LinkedList listaResultado = new LinkedList();
		
		IteradorLista iteradorL1 = lista1.iterator();

		if ((lista1.getSize() != 0) && (lista2.getSize() != 0)) {

			while (iteradorL1.hasNext()) {
				IteradorLista iteradorL2 = lista2.iterator();
				boolean noEncontrado = true;
				while (iteradorL2.hasNext() && noEncontrado) {
					if (iteradorL1.get().equals(iteradorL2.get())) {
						noEncontrado = false; }
					else
						iteradorL2.next();
				}
				if (noEncontrado)
					listaResultado.insertFront(iteradorL1.get());
				iteradorL1.next();
			}
		}
		
		return listaResultado;
	}
	
}
