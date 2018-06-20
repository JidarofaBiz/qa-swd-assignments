import java.util.List;
import java.util.ArrayList;

public class Primes {
	
	public static void main (String[] args) {
		
		CircularPrimes primes = new CircularPrimes();
		List<Integer> list = new ArrayList<>();
		list = primes.saveCircularPrimes(1000000);
		
		double begin = System.currentTimeMillis();
		
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		
		System.out.println("-----------------------");
		System.out.println("Total circulars primes:");
		System.out.println(list.size());
		double end = System.currentTimeMillis();
		
		double result = end - begin;
		
		System.out.println("-----------------------");
		System.out.println("Tiempo total ejecución");
		System.out.println(result);
	
	}
}
