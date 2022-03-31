package p1e6;

/**
 * PROG 3
 * TP 1 - Ejercicio 6
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
		l1.insertFront(5);
		l1.insertFront(20);
		l1.insertFront(56);
		l1.insertFront(99);
		
		l2.insertFront(1);
		l2.insertFront(8);
		l2.insertFront(9);
		l2.insertFront(13);
		l2.insertFront(20);
		l2.insertFront(56);
		
		LinkedList resultado = new LinkedList();
		
		// Ejercicio 6 - a
//		resultado = interseccion(l1,l2);
//		resultado.printList();
//		ordenarBurbuja(resultado);
//		resultado.printList();
		
		// Ejercicio 6 - b
		resultado = interseccionOrdenado(l1,l2);
		resultado.printList();
		
	}
	
	public static LinkedList interseccion(LinkedList lista1, LinkedList lista2){
		LinkedList listaResultado = new LinkedList();
		
		IteradorLista iteradorL1 = lista1.iterator();

		if ((lista1.getSize() != 0) && (lista2.getSize() != 0)) {

			while (iteradorL1.hasNext()) {
				IteradorLista iteradorL2 = lista2.iterator();
				boolean noEncontrado = true;
				while (iteradorL2.hasNext() && noEncontrado) {
					if (iteradorL1.get().equals(iteradorL2.get())) {
						listaResultado.insertFront(iteradorL1.get());
						noEncontrado = false; }
					else
						iteradorL2.next();
				}
				iteradorL1.next();
			}
		}
		
		return listaResultado;
	}
	
	public static void ordenarBurbuja (LinkedList lista) {
		for (int i=0; i< lista.getSize(); i++) {
			System.out.println("for");
			IteradorLista<Integer> iteradorLista = lista.iterator();
			for (int j=0; j < lista.getSize() - 1; j++) {
				if ((iteradorLista.get() > iteradorLista.nextInfo())) {
					Object aux = iteradorLista.get();
					iteradorLista.setInfo(iteradorLista.nextInfo());
					iteradorLista.next();
					iteradorLista.setInfo(aux);
				}
			}
		}
	}
	
	public static LinkedList interseccionOrdenado(LinkedList lista1, LinkedList lista2){
		LinkedList listaResultado = new LinkedList();
		
		IteradorLista<Integer> iteradorL1 = lista1.iterator();

		if ((lista1.getSize() != 0) && (lista2.getSize() != 0)) {

			while (iteradorL1.hasNext()) {
				IteradorLista<Integer> iteradorL2 = lista2.iterator();
				boolean noEncontrado = true;
				while (iteradorL2.hasNext() && noEncontrado) {
					if (iteradorL1.get().equals(iteradorL2.get())) {
						listaResultado.insertFront(iteradorL1.get());
						noEncontrado = false; }
					else if (iteradorL1.get() > iteradorL2.get())
						noEncontrado = false;
					else
						iteradorL2.next();
				}
				iteradorL1.next();
			}
		}
		
		return listaResultado;
	}
	
}
