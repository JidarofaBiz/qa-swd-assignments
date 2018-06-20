
import java.util.List;
import java.util.ArrayList;
/**
 * Esta clase tiene como objetivo generar una lista de numeros primos circulares teniendo como base un numero entero pasado por parametro.
 * La estrtategia usada fue primero determinar si un numero es primo o no, si el numero es primo se envia a otra clase que valida si todos sus valores circulares son primos y los guarda en un ArrayList el cual se retorna para ser manipulado.
 * @author: Jimmy Rodriguez
 * @version: 06/19/2018
 */



public class CircularPrimes {

	/**
     * Método que determina si un numero es primo o no por medio de el modulo de cada numero secuencialmente
     * @return boolean si es true quiere decir que el numero enviado por parametro efectivamente es numero primo
     * Tiempo de ejecución final teniendo en cuenta este metodo entre 15 y 23 minutos
     */
	private boolean toPrime_Op1(int number) {
			
			int cont = 0; 	
			for(int j = 1; j <= number; j++) {
				if (number%j == 0) {
					cont++;			
				}
			}
			if (cont <=2) {
				return true;
			}						
			return false;
	}
	
	/**
     * Refactor del método invirtiendo la logica para que no recorra hasta el final cada numero, sino que si el numero ingresado es divisible por más de 2 valores incluyendo el 1 pues se determina que ya no es primo y se corta el circuito
     * @return boolean si es true quiere decir que el numero enviado por parametro efectivamente es numero primo
     * Tiempo de ejecución final teniendo en cuenta este metodo entre 7 y 15 minutos
     */
	private boolean toPrime_Opc2(int number) {
		
		int cont = 0; 	
		for(int j = 1; j <= number; j++) {
			if (number%j == 0) {
				cont++;			
			}
			
			if (cont >= 3) {
				return false;
			}	
		}							
		return true;
	}
	
	/**
     * Se determina que la logica del metodo no satisface el tiempo de ejecucion, se cambia la logica calculando el numero primo por medio de la raiz cuadrada del numero y validando si el modulo es 0 si es 0 se determina que no es primo y se corta el circuito
     * @return boolean si es true quiere decir que el numero enviado por parametro efectivamente es numero primo
     * Tiempo de ejecución final teniendo en cuenta este metodo variable entre: 2.820299E7  y 3.9352234E7
     */
	public boolean toPrime(int number) {			
		for(int j = 2; j <= Math.sqrt(number); j++) {
			if (number%j == 0) {
				return false;		
			}	
		}							
		return true;
	}
	
	
	private boolean toCircularPrime(int number) {
		
		Integer wrapperNumber = new Integer(number);
		int cont = 0; 	
		String a = wrapperNumber.toString(); 
		
		for (int i = 1; i <= wrapperNumber.toString().length(); i++) {				
			if (toPrime(Integer.parseInt(a))) {
				cont++;
			}
		    a = new StringBuffer(a).append(a.charAt(0)).toString();		
			a = a.substring(1);		
		}			
		if (cont == wrapperNumber.toString().length()) {
			return true;
		}			
		return false;
	}
	
	public List<Integer> saveCircularPrimes(int number) {
		
		List<Integer> circularNumbers = new ArrayList<>();	
		
		for(int i = 2; i <= number; i++) {		
			if (toPrime(i)) {				
				if (toCircularPrime(i)) {	
					circularNumbers.add(i);
				}
			}
		}					
		return circularNumbers;
	}
}
