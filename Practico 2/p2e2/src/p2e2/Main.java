package p2e2;

import java.util.ArrayList;

/**
 * PROG 3
 * TP 2 - Ejercicio 2
 *   
 * @author  Melina PM
*/


public class Main {

	public static void main(String[] args) {
//		ArrayList<Integer> lista = new ArrayList<Integer>(5);
//		lista.add(1);
//		lista.add(3);
//		lista.add(5);
//		lista.add(7);
//		lista.add(78);
//		
//		System.out.println(existeElemento(lista, 1, 0));
		
		int arregloEnteros[] = {9,11,13,15,17};
		System.out.println(buscarElemento(arregloEnteros, 12, 0));
		
		
	}
	
	// Complejidad O(n) donde n = lista.size()
	public static Boolean existeElemento(ArrayList<Integer> lista, int elemento, int posicion) {
		if (posicion < lista.size() ) {
			if (lista.get(posicion) != elemento)
				return (existeElemento(lista, elemento, posicion+1));
			else
				return true;
		}
		return false;
	}
	
	// Complejidad O(n) donde n = arreglo.length
	public static int buscarElemento(int[] arreglo, int elemento, int posicion) {
		if (posicion < arreglo.length ) {
			if ((arreglo[posicion] != elemento) && (arreglo[posicion] < elemento)) 
				return (buscarElemento(arreglo, elemento, posicion+1));
			else if (arreglo[posicion] == elemento)
				return posicion+1;
		}
		return -1;
	}
}
