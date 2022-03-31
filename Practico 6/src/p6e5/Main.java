package p6e5;

import java.util.Enumeration;
import java.util.Hashtable;

public class Main {

	public static void main(String[] args) {

		Hashtable<Integer, Integer> contenedor=new Hashtable<Integer, Integer>();
		contenedor.put(1, 24);
		contenedor.put(2, 4);
		contenedor.put(3, 16);
		contenedor.put(4, 12);
		contenedor.put(5, 91);
		contenedor.put(6, 33);
		contenedor.put(7, 31);
		
		Enumeration enumeration = contenedor.elements();
		Enumeration llaves = contenedor.keys();
		while (enumeration.hasMoreElements()) {
		  System.out.println(""+"hashtable llaves: " + llaves.nextElement() +"-" +"hashtable valores: " + enumeration.nextElement());
		}
	}

}
