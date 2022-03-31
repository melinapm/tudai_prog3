package p2e6;

import java.util.ArrayList;

/**
 * PROG 3
 * TP 2 - Ejercicio 6
 * 
 * Clase arbol binario de busqueda
 *   
 * @author  Melina Perez Mounet
*/

public class TreeWithNode {

	private TreeNode raiz;
	
	public TreeWithNode() {
		this.raiz = null;
	}

	// O(n*h) donde h es la altura del arbol 
	// y n es el tamaño del arreglo valoresIniciales
	// Por cada valor del arreglo tengo que recorrer el ABB
	// para poder insertar el valor 
	public TreeWithNode(int[] valoresIniciales) {
		for (int i=0; i < valoresIniciales.length; i++) // O(n) donde n = tamaño del arreglo valoresIniciales 
			if (!hasElem(valoresIniciales[i]))
				add(valoresIniciales[i]); // O(h)
	}

	public void add(int value) {
		if (this.raiz == null)
			this.raiz = new TreeNode(value);
		else
			this.add(this.raiz,value); // O(h)
	}
	
	// O(h) donde h es la altura del arbol (la longitud de la rama mas larga)
	// En el peor de los casos el nodo se tiene que 
	// insertar al final de la rama las larga
	private void add(TreeNode actual, int valor) {
		if (actual.getValor() > valor) {
			
			if (actual.getIzq() == null) { 
				TreeNode temp = new TreeNode(valor);
				actual.setIzq(temp);
			} else {
				add(actual.getIzq(),valor);
			}
			
		} else {
			
			if (actual.getDer() == null) { 
				TreeNode temp = new TreeNode(valor);
				actual.setRight(temp);
			} else {
				add(actual.getDer(),valor);
			}
			
		}
	}
	
	public int getHeight() {
		if (this.raiz == null)
			return 0;
		else
			return this.getHeight(this.raiz); // O(n)
	}
	
	// Complejidad O(n) donde n es la cantidad de nodos del arbol
	// En el peor de los casos tengo que recorrer todos los nodos
	// del arbol para obtener la altura
	private int getHeight(TreeNode cursor) {
		
		if (cursor.getIzq() == null && cursor.getDer() == null) { // Si es una hoja
			return 0; // Soy chato, tengo altura 0
		} else {
			// Si tengo al menos un hijo
			
			int alturaIzq = 0;
			int alturaDer = 0;
			
			if (cursor.getIzq() != null)
				alturaIzq = 1 + this.getHeight(cursor.getIzq()); 
			
			if (cursor.getDer() != null)
				alturaDer = 1 + this.getHeight(cursor.getDer());
			
			int mayor = Math.max(alturaIzq, alturaDer);
			
			return mayor;	
		}
	}

	// Complejidad O(1)
	public int getRaiz() {
		return raiz.getValor();
	}
	
	public Boolean hasElem(int elemento) {
		return hasElem(raiz, elemento); // O(h)
	}
	
	// Complejidad O(h) donde h es la altura del arbol (la longitud de la rama mas larga)
	// Por ser ABB, en el peor de los casos tendria que recorrer la rama 
	// mas larga para encontrar el elemento
	private Boolean hasElem(TreeNode nodo, int elemento) {
		
		if (nodo == null)
			return false;
		else if (nodo.getValor() == elemento)
			return true;
		else if (nodo.getValor() > elemento)
			return (hasElem(nodo.getIzq(), elemento));
		else
			return (hasElem(nodo.getDer(), elemento));
				
	}
	
	// Complejidad O(1)
	public Boolean isEmpty() {
		if (raiz == null)
			return true;
		else
			return false;
	}
	
	public void printPosOrden() {
		printPosOrden(raiz); //O(n)
		System.out.println(""); // Lo agrego para que haga un salto de linea y se vea bien por console
	}
	
	// Complejidad O(n) donde n es la cantidad de nodos del arbol
	// En el peor de los casos se recorre todo el arbol para mostrarlo
	private void printPosOrden(TreeNode nodo) {
		if (nodo == null)
			System.out.print(" - ");
		else {
			printPosOrden(nodo.getIzq());
			printPosOrden(nodo.getDer());
			System.out.print(nodo.getValor() + " ");
		}
	}
	
	public void printPreOrden() {
		printPreOrden(raiz); // O(n)
		System.out.println(""); // Lo agrego para que haga un salto de linea y se vea bien por console
	}
	
	// Complejidad O(n) donde n es la cantidad de nodos del arbol
	// En el peor de los casos se recorre todo el arbol para mostrarlo
	private void printPreOrden(TreeNode nodo) {
		if (nodo == null)
			System.out.print(" - ");
		else {
			System.out.print(nodo.getValor() + " ");
			printPreOrden(nodo.getIzq());
			printPreOrden(nodo.getDer());
		}
	}
	
	public void printInOrden() {
		printInOrden(raiz); // O(n)
		System.out.println(""); // Lo agrego para que haga un salto de linea y se vea bien por console
	}
	
	// Complejidad O(n) donde n es la cantidad de nodos del arbol
	// En el peor de los casos se recorre todo el arbol para mostrarlo
	private void printInOrden(TreeNode nodo) {
		if (nodo == null)
			System.out.print(" - ");
		else {
			printInOrden(nodo.getIzq());
			System.out.print(nodo.getValor() + " ");
			printInOrden(nodo.getDer());
		}
	}
	
	public ArrayList getFrontera(){
		ArrayList<Integer> frontera = new ArrayList();
		if (raiz != null)
			getFrontera(raiz, frontera); // O(n)
		return frontera;
	}
	
	// Complejidad O(n) donde n es la cantidad de nodos del arbol
	// En el peor de los casos se recorre todo el arbol para
	// obtener los nodos de la frontera
	private void getFrontera(TreeNode nodo, ArrayList<Integer> frontera){
		
		if (nodo == null)
			return;
		else if (nodo.getIzq() == null && nodo.getDer() == null)
			frontera.add(nodo.getValor());
		else {
			getFrontera(nodo.getIzq(), frontera);
			getFrontera(nodo.getDer(), frontera);
		}

	}
	
	public int getMaxElement() {
		int maxElement = 0;
		if (raiz != null)
			return getMaxElement(raiz, maxElement); // O(h)
		return maxElement;
	}
	
	// Complejidad O(h) donde h es la altura del arbol
	// En el peor de los casos el maximo elemento esta en la 
	// rama mas larga
	private int getMaxElement(TreeNode nodo, int maxElement) {

		if (nodo.getDer() == null)
			maxElement = nodo.getValor();
		else
			return getMaxElement(nodo.getDer(), maxElement);
		return maxElement;
	}
	
	public ArrayList getElemAtLevel(int nivel){
		ArrayList<Integer> elementosNivel = new ArrayList();
		int dondeEstoy = 0;
		if (raiz != null && nivel <= getHeight())
			getElemAtLevel(raiz, elementosNivel, nivel, dondeEstoy); // O(n)
		return elementosNivel;
	}
	
	// Complejidad O(h) donde n es la cantidad de nodos del arbol
	// En el peor de los casos tengo que mostrar los elementos del ultimo nivel
	// y por esto tengo que pasar por todos los nodos
	private void getElemAtLevel(TreeNode nodo, ArrayList<Integer> elementosNivel, int nivel, int dondeEstoy){
		
		if (dondeEstoy == nivel) {
			elementosNivel.add(nodo.getValor());
		}
		else {
			getElemAtLevel(nodo.getIzq(), elementosNivel, nivel, dondeEstoy +1);
			getElemAtLevel(nodo.getDer(), elementosNivel, nivel, dondeEstoy +1);
		}

	}
	
	public boolean delete(int valorABorrar){
		if (hasElem(valorABorrar)) {
			delete(raiz, valorABorrar); // O(h)
			return true; }
		return false;
	}
	 
	// Complejidad O(h) donde h es la altura del arbol (la longitud de la rama mas larga)
	// Por ser ABB, en el peor de los casos tendria que recorrer la rama 
	// mas larga para encontrar el elemento a borrar
    private TreeNode delete(TreeNode nodo, int value) {
        if (nodo.getValor() > value) { // Uso ABB para buscar el nodo a borrar 
        	nodo.setIzq(delete(nodo.getIzq(), value));
        } else if (nodo.getValor() < value) {
        	nodo.setRight(delete(nodo.getDer(), value));
        } else {
            if (nodo.getIzq() != null && nodo.getDer() != null) { // Caso 3: tiene ambos hijos
                TreeNode temp = nodo;
                TreeNode minNodeForRight = ValorNodoMenorISubArbolDer(temp.getDer()); // Necesito el NMISAD
                nodo.setValor(minNodeForRight.getValor()); // Seteo el valor
                nodo.setRight(delete(nodo.getDer(), minNodeForRight.getValor())); // Mando a borrar el NMISAD
            }
            else if (nodo.getIzq() != null) { // Caso 2: Tiene solo hijo izquierdo
            	nodo = nodo.getIzq();
            }
            else if (nodo.getDer() != null) { // Caso 2: Tiene solo hijo derecho
            	nodo = nodo.getDer();
            }
            else {  // Caso 1: Nodo es una hoja
            	if (raiz == nodo) // Cuando borro el unico nodo del arbol
            		raiz = null;
            	else
            		nodo = null; }
        }
        return nodo;
    }
    
	// Complejidad O(h) donde h es la altura del arbol
    // En el peor caso el NMISAD puede ser la hoja de la 
    // rama mas larga.
	public TreeNode ValorNodoMenorISubArbolDer(TreeNode raiz) {
        if (raiz.getIzq() == null)
            return raiz;
        else {
            return ValorNodoMenorISubArbolDer(raiz.getIzq());
        }
    }
	
	public ArrayList getLongestBranch(){
		if (raiz != null)
			return getLongestBranch(raiz); // O(n)
		return null;
	}
	
	// Complejidad O(n) donde n es la cantidad de nodos del arbol
	// En el peor de los casos se recorre todo el arbol para
	// obtener la rama las larga
	private ArrayList<Integer> getLongestBranch(TreeNode nodo){
		ArrayList<Integer> ramaActual = new ArrayList();
		ArrayList<Integer> ramaIzq = new ArrayList();
		ArrayList<Integer> ramaDer = new ArrayList();

	        if (nodo.getIzq() == null && nodo.getDer() == null) { // Si es hoja
	        	ramaActual.add(nodo.getValor());
	            return ramaActual;
	        } else {
	            if (nodo.getIzq() != null) { // Guardo valores por la izq
	            	ramaIzq.add(nodo.getValor());
	            	ramaIzq.addAll(getLongestBranch(nodo.getIzq()));
	            }
	            if (nodo.getDer() != null) { // Guardo valores por la der
	            	ramaDer.add(nodo.getValor());
	            	ramaDer.addAll(getLongestBranch(nodo.getDer()));
	            }
	            
	            if (ramaDer.size() > ramaIzq.size()) { // Comparo cual rama es la mas grande
	            	ramaActual.addAll(ramaDer);
	            } else {
	            	ramaActual.addAll(ramaIzq); // En caso que sean iguales siempre me quedo con la izq
	            }
	        }
	        return ramaActual;
		
	}
	
}