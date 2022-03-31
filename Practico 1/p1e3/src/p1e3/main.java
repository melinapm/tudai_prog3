package p1e3;

/**
 * PROG 3
 * TP 1 - Ejercicio 3
 * 
 * Clase Pila - Main
 * 
 * @author  Melina PM
*/

public class main {

	public static void main(String[] args) {
		
		Pila pilita = new Pila();
		
		pilita.push(1);
		pilita.push(2);
		pilita.push(3);
		pilita.push(4);
		pilita.push(5);
		
//		pilita.printPila();
		
		pilita.reverse();
		
		pilita.printPila();
		
	}

}
