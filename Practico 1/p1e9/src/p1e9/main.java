package p1e9;

/**
 * PROG 3
 * TP 1 - Ejercicio 9
 *   
 * @author  Melina PM
*/

public class main {

	public static void main(String[] args) {

		String palabra = "anilina";
		
		if (capicua(palabra))
			System.out.println("La palabra " + palabra + " es capicua!");
		else
			System.out.println("La palabra " + palabra + " NO es capicua!");
	}
	
	public static boolean capicua(String palabra) {
		
        char[] palabraArray = new char[palabra.length()];
  
        for (int i = 0; i < palabra.length(); i++) {
        	palabraArray[i] = palabra.charAt(i);
        }
        
        boolean esCapicua = false;
        
        
		for (int i=0, j=palabraArray.length -1; i<j; i++,j--) {
			if (palabraArray[i] == palabraArray[j]) {
				esCapicua = true; }
			else
				esCapicua =false;
		}
		
		return esCapicua;
		
	}

}
