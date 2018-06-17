import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PwdGenTest {

	Arguments arg;
	Configuration conf;
	int defaultSize;
	String defaultList;
	String nSysmbols;
	String nNumbres;
	String nLowers;
	String nUppers;
	
	public boolean searchCharters(String password, String symbols) {
		boolean flag = false;
		
		for (int i = 0; i < password.length(); i++) {		
			for (int j = 0; j < symbols.length(); j++) {
				if (password.charAt(i) == symbols.charAt(j)) {
					flag = true;
				}
			}
		}		
		return flag;
	}
	
	public boolean allSysmbolsSame(String password, String symbols)
	{
		boolean flag = false;
		int cont=0;
		
		for (int i = 0; i< password.length(); i++) {
			for (int j = 0; j < symbols.length(); j++) {
				if (password.charAt(i) == symbols.charAt(j)) {
					cont++;
				}
			}
		}			
		
		if (cont == password.length()) {
			flag = true;
		}		
		
		return flag;
	}
	
	public boolean allPasswordsOk(String[] password, String symbols) {
		boolean flag = false;
		int cont= 0;
		
		for (int i= 0 ; i < password.length; i++) {			
			if (allSysmbolsSame(password[i], symbols)== true) {
				cont++;
			}
		}
		
		if (cont == password.length) {
			flag = true;
		}
		
		return flag;
	}
	
	@Before
	public void setUp() {
		arg = new Arguments();
		defaultSize = 16;
		defaultList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!$%'/()_.,<>{}[]+-*@^#=";
		nSysmbols = defaultList.substring(62, 85);
		nNumbres = defaultList.substring(52, 62);
		nLowers = defaultList.substring(0, 26);
		nUppers = defaultList.substring(26, 52);
	}
		
	@Test()
	public void clipBoard_copyText() {
		Assert.assertEquals("eUwjIEgM06lgOIVn", arg.clipBoard("eUwjIEgM06lgOIVn", true));
	}
	
	@Test
	public void size16() {			
		conf =  new Configuration(16, false, false, false, false, " ", " ", 1);	
		int password = arg.generatePassword(conf)[0].length();
		Assert.assertEquals(16, password);
	}
	
	@Test
	public void size30() {	
		conf = new Configuration(30, false, false, false, false, " ", " ", 1); 
		int password = arg.generatePassword(conf)[0].length();
		Assert.assertEquals(30, password);
	}
	
	@Test
	public void total3() {	
		conf = new Configuration (defaultSize, false, false, false, false, " ", " ", 3);
		int password = arg.generatePassword(conf).length;
		Assert.assertEquals(3, password);
	}
	
	@Test
	public void total20() {	
		conf = new Configuration (defaultSize, false, false, false, false, " ", " ", 20);
		int password = arg.generatePassword(conf).length;
		Assert.assertEquals(20, password);
	}
	
	@Test
	public void defaultCharters()
	{ 
		conf = new Configuration (defaultSize, false, false, false, false, " ", " ", 1);
		String password = arg.generatePassword(conf)[0];
		boolean flag = searchCharters(password, nSysmbols);
		Assert.assertFalse(flag);
	}
	
	@Test
	public void withoutLowerCases()
	{
		conf = new Configuration (defaultSize, true, false, true, true, " ", " ", 2);
		String password = arg.generatePassword(conf)[0];
		boolean flag = searchCharters(password, nLowers);
		Assert.assertFalse(flag);
	}
	
	@Test
	public void withoutUperCases()
	{ 
		conf = new Configuration (defaultSize, false, true, true, true, " ", " ", 3);
		String password = arg.generatePassword(conf)[0];
		boolean flag = searchCharters(password, nUppers);
		Assert.assertFalse(flag);
	}
	
	@Test
	public void withoutNumbers()
	{
		conf = new Configuration(defaultSize, true, true, false, true, " ", " ", 41);
		String password = arg.generatePassword(conf)[0];
		boolean flag = searchCharters(password, nNumbres);
		Assert.assertFalse(flag);
	}
	
	@Test
	public void withoutSymbols()
	{
		conf = new Configuration (defaultSize, true, true, true, false, " ", " ", 5);
		String symbols = defaultList.substring(62, 85);
		String password = arg.generatePassword(conf)[0];
		boolean flag = searchCharters(password, symbols);
		Assert.assertFalse(flag);
	}
	
	@Test
	public void excludeSymbols()
	{
		String symbols= "!$%'/()";
		conf = new Configuration (defaultSize, true, true, true, true, symbols, " ", 6);
		String password = arg.generatePassword(conf)[0];
		boolean flag = searchCharters(password, symbols);
		Assert.assertFalse(flag);
	}
	
	@Test
	public void excludeAmbiguous()
	{
		String symbols = "iILl1oO0";
		conf = new Configuration (defaultSize, true, true, true, true, " ", symbols, 7);		
		String password = arg.generatePassword(conf)[0];
		boolean flag = searchCharters(password, symbols);
		Assert.assertFalse(flag);
	}
	
	@Test
	public void onlyLower()
	{
		conf = new Configuration (defaultSize, false, true, false, false, " ", " ", 8);
		String password = arg.generatePassword(conf)[0];
		boolean flag = allSysmbolsSame(password, nLowers);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void onlyUper()
	{
		conf = new Configuration (defaultSize, true, false, false, false, " ", " ", 9);
		String[] password = arg.generatePassword(conf);
		boolean flag = allPasswordsOk(password, nUppers);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void onlyNumbers()
	{
		conf = new Configuration (defaultSize, false, false, true, false, " ", " ", 10);
		String password = arg.generatePassword(conf)[0];
		boolean flag = allSysmbolsSame(password, nNumbres);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void onlySymbols()
	{ 
		conf = new Configuration(defaultSize, false, false, false, true, " ", " ", 11);
		String password = arg.generatePassword(conf)[0];
		boolean flag = allSysmbolsSame(password, nSysmbols);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void lowerUpper()
	{
		conf = new Configuration (defaultSize, true, true, false, false, " ", " ", 12);
		String symbols= nLowers+nUppers; 
		String password = arg.generatePassword(conf)[0];
		boolean flag = allSysmbolsSame(password, symbols);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void lowerNumbers()
	{
		conf = new Configuration(defaultSize, false, true, true, false, " ", " ", 13);
		String symbols = nLowers+nNumbres; 
		String password = arg.generatePassword(conf)[0];
		boolean flag = allSysmbolsSame(password, symbols);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void lowerSymbols()
	{
		conf = new Configuration (defaultSize, false, true, false, true, " ", " ", 14);
		String symbols = nLowers+nSysmbols; 
		String password = arg.generatePassword(conf)[0];
		boolean flag = allSysmbolsSame(password, symbols);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void upperNumbers()
	{
		conf = new Configuration(defaultSize, true, false, true, false, " ", " ", 15);
		String symbols = nUppers+nNumbres; 
		String password = arg.generatePassword(conf)[0];
		boolean flag = allSysmbolsSame(password, symbols);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void numbersSymbols()
	{
		conf = new Configuration (defaultSize, false, false, true, true, " ", " ", 16);
		String symbols = nNumbres+nSysmbols; 
		String password = arg.generatePassword(conf)[0];
		boolean flag = allSysmbolsSame(password, symbols);
		Assert.assertTrue(flag);
	}
}
