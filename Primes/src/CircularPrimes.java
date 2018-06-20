
import java.util.List;
import java.util.ArrayList;

public class CircularPrimes {

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
	
	private boolean toPrime(int number) {
			
		int cont = 0; 			
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
