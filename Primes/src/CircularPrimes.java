
public class CircularPrimes {

	public boolean toPrime_Op1(int number) {
			
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
	
	public boolean toPrime(int number) {
		
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
	
	public boolean toCircularPrime(int number) {
		
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
}
