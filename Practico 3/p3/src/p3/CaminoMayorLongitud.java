package p3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CaminoMayorLongitud {

	private Grafo<?> grafo;
	private HashMap<Integer, String> colores;
	private int origen;
	private int destino;

	public CaminoMayorLongitud(Grafo<?> grafo, int origen, int destino) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.origen = origen;
		this.destino = destino;
	}

	public ArrayList<Integer> encontrarCaminoMasLargo() {

		Iterator<Integer> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			colores.put(verticeId, "blanco");
		}

		ArrayList<ArrayList<Integer>> todosLosCaminos = encontrarCaminos(this.origen);
		ArrayList<Integer> elCaminoMasLargo = encontrarElCaminoMasLargo(todosLosCaminos);
		
		return elCaminoMasLargo;
	}

	private ArrayList<Integer> encontrarElCaminoMasLargo(ArrayList<ArrayList<Integer>> todosLosCaminos) {
		ArrayList<Integer> elCaminoMasLargo = new ArrayList<Integer>();
		
		for (int i=0; i< todosLosCaminos.size(); i++) {
			for (int j=0; j < todosLosCaminos.size() - 1; j++) {
				if (todosLosCaminos.get(i).size() < todosLosCaminos.get(j).size())
					elCaminoMasLargo = todosLosCaminos.get(j);
				else
					elCaminoMasLargo = todosLosCaminos.get(i);
				}
		}
		
		return elCaminoMasLargo;
	}

	private ArrayList<ArrayList<Integer>> encontrarCaminos(int vertice) {

		colores.put(vertice, "amarillo");

		ArrayList<ArrayList<Integer>> resultado = new ArrayList<>();
		
		if (vertice == this.destino) {
			ArrayList<Integer> unicoCamino = new ArrayList<>();
			unicoCamino.add(vertice);
			resultado.add(unicoCamino);
		} else {
		
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
			while (it.hasNext()) {
				int adyacente = it.next();
				if (colores.get(adyacente).equals("blanco")) {
					ArrayList<ArrayList<Integer>> caminosParciales = encontrarCaminos(adyacente);
					
					for (ArrayList<Integer> caminoParcial: caminosParciales) {
						ArrayList<Integer> caminoCompleto = new ArrayList<>();
						caminoCompleto.add(vertice);
						caminoCompleto.addAll(caminoParcial);
						resultado.add(caminoCompleto);
					}

				}
					
			}
	
		}
		
		colores.put(vertice, "blanco");

		return resultado;
	}

}
