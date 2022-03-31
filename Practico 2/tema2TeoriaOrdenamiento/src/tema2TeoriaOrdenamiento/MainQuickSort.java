package tema2TeoriaOrdenamiento;

/**
 * PROG 3
 * 
 * Ejercicio Teoria
 * Metodo de Ordenamiento para Arreglos
 * Quick-Sort
 * O(n^2) -> donde n es el tamaño del arrglo a ordenar
 * 
 * Caso Promedio: n*log(n)
 * 
 * @author  Melina Perez Mounet
 * 
*/

public class MainQuickSort {

	public static void main(String[] args) {
		int[] arregloEnteros = new int[10];
		int a[] = {9,5,6,7,2,3,4,1,0,8};
		
//		for(int i=0;i<a.length;i++)  
//			System.out.println(a[i]);
		
		quicksort(a, 0, 9);
		
		for(int i=0;i<a.length;i++)  
			System.out.println(a[i]);
		
				
	}
	
	private static void quicksort(int arreglo[], int izquierda, int derecha) {
	    if (izquierda < derecha) {
	        int indiceParticion = particion(arreglo, izquierda, derecha);
	        quicksort(arreglo, izquierda, indiceParticion);
	        quicksort(arreglo, indiceParticion + 1, derecha);
	    }
	}
	
	private static int particion(int arreglo[], int izquierda, int derecha) {
        int pivote = arreglo[izquierda];
        // Ciclo infinito
        while (true) {
            while (arreglo[izquierda] < pivote) {
                izquierda++;
            }
            while (arreglo[derecha] > pivote) {
                derecha--;
            }
            if (izquierda >= derecha) {
                return derecha;
            } else { //Nota: yo sé que el else no hace falta por el return de arriba, pero así el algoritmo es más claro
                int temporal = arreglo[izquierda];
                arreglo[izquierda] = arreglo[derecha];
                arreglo[derecha] = temporal;
                izquierda++;
                derecha--;
            }
            // El while se repite hasta que izquierda >= derecha
        }
    }
}
