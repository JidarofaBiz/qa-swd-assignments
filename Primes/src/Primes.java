
public class Primes {
	
	public static void main (String[] args) {
		
		CircularPrimes primes = new CircularPrimes();
		
		for(int i = 2; i <= 1000000; i++) {		
			if (primes.toPrime(i)) {				
				if (primes.toCircularPrime(i)) {				
					System.out.println(i);
				}
			}
		}				
	}
}
