package p2e5;

/**
 * PROG 3
 * TP 2 - Ejercicio 4
 *   
 * @author  Melina PM
*/

public class Main {

	public static void main(String[] args) {
		int[] arregloEnteros = new int[10];
		int a[] = {9,5,6,7,2,3,4,1,0,8};
		
//		for(int i=0;i<a.length;i++)  
//			System.out.println(a[i]);
		
		quicksort(a, 0, 9);
		
		for(int i=0;i<a.length;i++)  
			System.out.println(a[i]);
		
				
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
}
