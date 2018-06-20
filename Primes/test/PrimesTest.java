import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class PrimesTest {
	
	CircularPrimes primes;

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
	public void toPrime_number_4_false() {	
		Assert.assertFalse(primes.toPrime(4));
	}
	
	@Test()
	public void toPrime_number_6_false() {	
		Assert.assertFalse(primes.toPrime(6));
	}
	
	@Test()
	public void CircularPrimes_4_of_10() {	
		
		Assert.assertEquals(4, primes.saveCircularPrimes(10).size());
	}
	
	@Test()
	public void CircularPrimes_13_of_100() {	
		Assert.assertEquals(13, primes.saveCircularPrimes(100).size());
	}
	
	@Test()
	public void CircularPrimes_25_of_1000() {	
		Assert.assertEquals(25, primes.saveCircularPrimes(1000).size());
	}
	
	@Test()
	public void CircularPrimes_55_of_1000000() {	
		Assert.assertEquals(55, primes.saveCircularPrimes(1000000).size());
	}
	
	

}
