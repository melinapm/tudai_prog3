package p2e3;

/**
 * PROG 3
 * TP 2 - Ejercicio 3
 *   
 * @author  Melina PM
*/


public class Main {

	public static void main(String[] args) {
		int a[] = {9,11,13,15,17};
		//ordenamientoSeleccion(a);
		ordenamientoBurbujeo(a);
		
		for(int i=0;i<a.length;i++)  
			System.out.println(a[i]);
		
	}
	
	// Complejidad O(n^2) donde n = arreglo.length
	public static void ordenamientoSeleccion(int[] arreglo) {
		for (int i=0; i < arreglo.length; i++) {
			int k = i;
			for (int j= i+1; j< arreglo.length; j++) {
				if (arreglo[j] < arreglo[k])
					k = j;
			}
			int aux = arreglo[i];
			arreglo[i] = arreglo[k];
			arreglo[k] = aux;
		}		
	}
	
	// Complejidad O(n^2) donde n = arreglo.length
	public static void ordenamientoBurbujeo(int[] arreglo) {
		for (int i=0; i< arreglo.length; i++) {
			for (int j=0; j < arreglo.length - 1; j++) {
				if (arreglo[j] > arreglo[j+1]) {
					int aux = arreglo[j];
					arreglo[j] = arreglo[j+1];
					arreglo[j+1] = aux;
				}
			}
		}
	}
}
