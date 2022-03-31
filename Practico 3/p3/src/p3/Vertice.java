package p3;

import java.util.ArrayList;
/*
 * La clase vertice representa un vertice del grafo. 
 * Contiene el valor del vertice y una lista con los arcos de este.
 */

public class Vertice<T> {

	private int vertice;
    private ArrayList<Arco<T>> arcos;
    
	public Vertice(int vertice) {
		this.vertice = vertice;
		arcos = new ArrayList<Arco<T>>();
	}

	public int getVertice() {
		return vertice;
	}

	public ArrayList<Arco<T>> getArcos() {
		return arcos;
	}

	public void addArco(Arco arco) {
		arcos.add(arco);
	}
	
	public void deleteArco(Arco arco) {
		arcos.remove(arco);
	}
	
    public boolean equals(Vertice objeto) {
    	return (this.vertice == objeto.vertice);
    }
}
