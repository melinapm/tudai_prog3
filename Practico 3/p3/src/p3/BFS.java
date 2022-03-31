package p3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	private Grafo<?> grafo;
	private HashMap<Integer,Boolean> verticesVisitados;
	private Queue<Integer> fila;
	
	
	public BFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.verticesVisitados = new HashMap<>();
		this.fila = new LinkedList();
	}
	
	public void bfs() {
		
		// Marco todos los vertices como no visitados
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			verticesVisitados.put(verticeId, false);
		}
		
		// Por cada vertice no visitado llamo a bfs(v)
		it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			if (!verticesVisitados.get(verticeId))
				bfs(verticeId);
		}		
		
	}
	
	public void bfs(int vertice) {
		fila.clear();
		verticesVisitados.replace(vertice, true); // Marco v como visitado
		fila.add(vertice); // Agrego v a la cola
				
		while (!fila.isEmpty()) {
			vertice = fila.poll();
			System.out.println("Valido adyacentes no visitdos del vertice " + vertice );
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
			while(it.hasNext()) {
				int adyacente = it.next();
				if (!verticesVisitados.get(adyacente)) {
					verticesVisitados.replace(adyacente, true);
					fila.add(adyacente);
					System.out.println("Fila adyacente agregado a visitar: " + adyacente );
				}
			}
		}
		
	}
	

}
