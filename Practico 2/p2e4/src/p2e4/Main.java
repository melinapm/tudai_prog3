package p2e4;

import java.util.Arrays;
import java.util.Timer;

/**
 * PROG 3
 * TP 2 - Ejercicio 4
 *   
 * @author  Melina PM
*/

public class Main {

	public static void main(String[] args) {
		int[] a = crearArregloEnterosAleatorio(100);
		
		long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
		TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
		int i=0;
		while (i<10000) {
//			ordenamientoSeleccion(a);
//				ordenamientoBurbujeo(a);
//				mergesort(a, 0, 99);
//				quicksort(a, 0, 99);
			Arrays.sort(a);
			i++;
		}
		
		TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
		tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
		System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos

				
	}
	
	// Complejidad QuickSort O(n^2) - Caso promedio n*log(n)
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
	
	// Complejidad MergeSort O(n^2) - Caso promedio n*log(n)
	public static void mergesort(int A[],int izq, int der){
	    if (izq < der){
	            int m=(izq+der)/2;
	            mergesort(A,izq, m);
	            mergesort(A,m+1, der);                                                                                
	            merge(A,izq, m, der);                                                                                 
	    }
	}
	
	private static void merge(int A[],int izq, int m, int der){
		   int i, j, k;
		   int [] B = new int[A.length]; //array auxiliar
		   for (i=izq; i<=der; i++)      //copia ambas mitades en el array auxiliar                                       
		        B[i]=A[i];

		   i=izq; j=m+1; k=izq;
		     
		   while (i<=m && j<=der) //copia el siguiente elemento más grande                                      
		          if (B[i]<=B[j])
		              A[k++]=B[i++];
		          else
		              A[k++]=B[j++];
		        
		   while (i<=m)         //copia los elementos que quedan de la
		         A[k++]=B[i++]; //primera mitad (si los hay)
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
	
	public static int[] crearArregloEnterosAleatorio(int tamanio) {
		int[] arreglo = new int[tamanio];
		
		for (int i=0; i < tamanio; i++) {
			arreglo[i] = (int)(Math.random()*10000+1);
		}
		
		return arreglo;				
	} 
}
