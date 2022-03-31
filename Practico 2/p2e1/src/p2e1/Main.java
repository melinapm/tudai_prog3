package p2e1;

/**
 * PROG 3
 * TP 2 - Ejercicio 1
 *   
 * @author  Melina PM
*/


public class Main {

	public static void main(String[] args) {
		int arregloEnteros[] = {1,2,3,4,5};
		
		System.out.println(arrayOrdenado(arregloEnteros, 0));	
				
	}
	
	// Complejidad O(n) donde n = arreglo.length
	public static Boolean arrayOrdenado(int arreglo[], int posicion) {
		if (posicion < arreglo.length -1 ) {
			if (arreglo[posicion] < arreglo[posicion+1])
				return (arrayOrdenado(arreglo, posicion+1));
			else
				return false;
		}
		return true;
	}
	
}
