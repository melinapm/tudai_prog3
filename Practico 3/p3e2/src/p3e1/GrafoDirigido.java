package p3e1;

import java.util.ArrayList;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
	
	private ArrayList<Vertice<T>> vertices;
	
	public GrafoDirigido() {
		this.vertices = new ArrayList<Vertice<T>>();
	}

	@Override
	public void agregarVertice(int verticeId) {
		Vertice verticeNuevo = new Vertice<T>(verticeId);
		if (!vertices.contains(verticeNuevo))
			vertices.add(verticeNuevo); 
	}
	
	@Override
	public void borrarVertice(int verticeId) {
		if (vertices.contains(verticeId))
			vertices.remove(verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Arco<T> nuevoArco = new Arco<T>(verticeId1, verticeId2, etiqueta);
		for (int i=0; i<vertices.size(); i++) {
			if (vertices.get(i).getVertice() == verticeId1)
				vertices.get(i).addArco(nuevoArco);
		}
	}

	
	// VER Borrar entrantes y salientes
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		for (int i=0; i<vertices.size(); i++) {
			if (vertices.get(i).getVertice() == verticeId1)
				for (int j=0; j<vertices.get(i).getArcos().size(); j++) {
					if ((vertices.get(i).getArcos().get(j).getVerticeOrigen() == verticeId1) 
							&& (vertices.get(i).getArcos().get(j).getVerticeOrigen() == verticeId2)) {
						vertices.get(i).getArcos().remove(j);
					}
				}		
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		Vertice verticeBuscado = new Vertice<T>(verticeId);
		if (vertices.contains(verticeBuscado))
			return true;
		return false;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		for (int i=0; i<vertices.size(); i++) {
			if (vertices.get(i).getVertice() == verticeId1)
				for (int j=0; j<vertices.get(i).getArcos().size(); j++) {
					if ((vertices.get(i).getArcos().get(j).getVerticeOrigen() == verticeId1) 
							&& (vertices.get(i).getArcos().get(j).getVerticeOrigen() == verticeId2)) {
						return true;
					}
				}		
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		for (int i=0; i<vertices.size(); i++) {
			if (vertices.get(i).getVertice() == verticeId1)
				for (int j=0; j<vertices.get(i).getArcos().size(); j++) {
					if ((vertices.get(i).getArcos().get(j).getVerticeOrigen() == verticeId1) 
							&& (vertices.get(i).getArcos().get(j).getVerticeDestino() == verticeId2)) {
						return vertices.get(i).getArcos().get(j);
					}
				}		
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		int arcosTotales=0;
		for (int i=0; i<vertices.size(); i++)
			arcosTotales += vertices.get(i).getArcos().size();			
		return arcosTotales;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		
		Iterator iteradorVertices = new Iterator<Integer>() {
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < vertices.size() && vertices.get(index) != null;
			}

			@Override
			public Integer next() {
				return vertices.get(index++).getVertice();
			}
			
		};
		return iteradorVertices;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		
		// Busco el vertice y me guardo sus arcos para retornar 
		// los vertices origen que corresponderian a sus adyacentes
		ArrayList<Arco<T>> adyacentes = new ArrayList<Arco<T>>();
		boolean encontro = false;
		int i=0;
		while (!encontro && i < vertices.size()) {
			if (vertices.get(i).getVertice() == verticeId) {
				adyacentes.addAll(vertices.get(i).getArcos());
				encontro = true;				
			} else
				i++;
		}
		
		Iterator iteradorAdyacentes = new Iterator<Integer>() {
			private int index = 0;
			
			@Override
			public boolean hasNext() {
				return index < adyacentes.size() && adyacentes.get(index) != null;
			}

			@Override
			public Integer next() {
				return adyacentes.get(index++).getVerticeDestino();
			}
		};
		return iteradorAdyacentes;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		
		// Me guardo todos los arcos para luego retornarlos
		ArrayList<Arco<T>> arcos = new ArrayList<Arco<T>>();
		for (int i=0; i<vertices.size();i++) {
			arcos.addAll(vertices.get(i).getArcos());	
		}
		
//		Iterator<Arco<T>> iteradorArcos = new Iterator<Arco<T>>() {
//
//			private int index = 0;
//			
//			@Override
//			public boolean hasNext() {
//				return index < arcos.size() && arcos.get(index) != null;
//			}
//
//			@Override
//			public Arco<T> next() {
//				return arcos.get(index++);
//			}
//
//		};
//		return iteradorArcos;
		return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		
		// Busco el vertice y me guardo sus arcos para retornar
		ArrayList<Arco<T>> arcosVertice = new ArrayList<Arco<T>>();
		boolean encontro = false;
		int i=0;
		while (!encontro && i < vertices.size()) {
			if (vertices.get(i).getVertice() == verticeId) {
				arcosVertice.addAll(vertices.get(i).getArcos());
				encontro = true;				
			} else
				i++;
		}
		
//		Iterator<Arco<T>> iteradorArcosPorVertice = new Iterator<Arco<T>>() {
//			private int index = 0;
//			
//			@Override
//			public boolean hasNext() {
//				return index < arcosVertice.size() && arcosVertice.get(index) != null;
//			}
//
//			@Override
//			public Arco<T> next() {
//				return arcosVertice.get(index++);
//			}
//
//		};
//		return iteradorArcosPorVertice;
		return arcosVertice.iterator();
	}

}
