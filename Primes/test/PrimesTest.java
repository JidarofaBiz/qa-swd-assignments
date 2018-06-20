import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class PrimesTest {
	
	CircularPrimes primes;
	List<Integer> circularNumbers = new ArrayList<>();
	
	public boolean cicularOK(List<Integer> numbers)
	{
		int[] circularNumbers = {2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97, 113, 131, 197, 199, 311, 337, 
				373, 719, 733, 919, 971, 991, 1193, 1931, 3119, 3779, 7793, 7937, 9311, 9377, 11939, 19391, 19937, 
				37199, 39119, 71993, 91193, 93719, 93911, 99371, 193939, 199933, 319993, 331999, 391939, 393919, 
				919393, 933199, 939193, 939391, 993319, 999331};
		int cont = 0;
		
		for (int i = 0; i < circularNumbers.length; i++) {
			for (int j = 0; j < numbers.size(); j++) {
				if (circularNumbers[i] == numbers.get(j) ) {
					cont++;
				}
			}
		}
		
		if (cont == numbers.size()) {
			return true;
		}
		return false;
	}

	@Before
	public void setUp() {
		primes = new CircularPrimes();
	}
	
	@Test()
	public void toPrime_number_2_true() {	
		Assert.assertTrue(primes.toPrime(2));
	}
	
	@Test()
	public void toPrime_number_3_true() {	
		Assert.assertTrue(primes.toPrime(3));
	}
	
	@Test()
	public void toPrime_number_58363_true() {	
		Assert.assertTrue(primes.toPrime(58363));
	}
	
	@Test()
	public void toPrime_number_58363_false() {	
		Assert.assertFalse(primes.toPrime(58362));
	}
	
	@Test()
	public void toPrime_number_4_false() {	
		Assert.assertFalse(primes.toPrime(4));
	}
	
	@Test()
	public void toPrime_number_6_false() {	
		Assert.assertFalse(primes.toPrime(6));
	}
	
	@Test()
	public void toPrime_number_942343_false() {	
		Assert.assertFalse(primes.toPrime(942343));
	}
	
	
	@Test()
	public void CircularPrimes_10_OK() {	
		
		circularNumbers = primes.saveCircularPrimes(10); 	
		Assert.assertTrue(cicularOK(circularNumbers));
	}
	
	@Test()
	public void CircularPrimes_100_OK() {	

		circularNumbers = primes.saveCircularPrimes(100); 	
		Assert.assertTrue(cicularOK(circularNumbers));
	}
	
	@Test()
	public void CircularPrimes_1000_OK() {	
		circularNumbers = primes.saveCircularPrimes(1000); 	
		Assert.assertTrue(cicularOK(circularNumbers));
	}
	
	@Test()
	public void CircularPrimes_10000_OK() {	
		circularNumbers = primes.saveCircularPrimes(10000); 	
		Assert.assertTrue(cicularOK(circularNumbers));
	}
	
	@Test()
	public void CircularPrimes_100000_OK() {	
		circularNumbers = primes.saveCircularPrimes(100000); 	
		Assert.assertTrue(cicularOK(circularNumbers));
	}
	
	@Test()
	public void CircularPrimes_1000000_OK() {	
		circularNumbers = primes.saveCircularPrimes(1000000); 	
		Assert.assertTrue(cicularOK(circularNumbers));
	}
	
	@Test()
	public void CircularPrimes_55_of_1000000() {	
		Assert.assertEquals(55, primes.saveCircularPrimes(1000000).size());
	}
	
	@Test()
	public void CircularPrimes_43_of_100000() {	
		Assert.assertEquals(43, primes.saveCircularPrimes(100000).size());
	}
	
	@Test()
	public void CircularPrimes_33_of_10000() {	
		Assert.assertEquals(33, primes.saveCircularPrimes(10000).size());
	}
	
	@Test()
	public void CircularPrimes_25_of_1000() {	
		Assert.assertEquals(25, primes.saveCircularPrimes(1000).size());
	}
	
	@Test()
	public void CircularPrimes_13_of_100() {	
		Assert.assertEquals(13, primes.saveCircularPrimes(100).size());
	}
	
	@Test()
	public void CircularPrimes_4_of_10() {	
		Assert.assertEquals(4, primes.saveCircularPrimes(10).size());
	}
}
